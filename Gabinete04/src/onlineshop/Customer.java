/* package declaration if necessary*/
package onlineshop;

import onlineseller.Product;
import onlineseller.Seller;

/* import statements if necessary */

/* This class and all its attributes and methods are
 * currently declared with a default access modifier.
 * Apply the correct access modifiers to them based on
 * the given problem domain. */

// class definition
public class Customer {

	public final static int 	MAX_PRODUCT = 50;

	private Product[] 	productList = new Product[Customer.MAX_PRODUCT];
	private String 		name;
	private int 		productCount;
	private float		credit;

	//constructor
	// set to public (can be instantiated anywhere)
	public Customer(String customerName) {
		this.name 	= customerName;
		this.credit = 1000f;
	}

	//TODO: insert getters and setters here

	// method(s)
	// can be called by a class outside this package
	public boolean buy(Product p) {
		if (this.productCount < Customer.MAX_PRODUCT) {
			if (this.credit >= p.getPrice()) {
				this.productList[this.productCount] = p;
				this.productCount++;

				float val 	= p.getPrice();		// store product price in variable val
				this.credit -= val;			// deduct val from this customer's credit

				Seller s	= p.getSeller();		// s refers to the product's seller
				s.setProfit(val);			// increase seller's profit by val (product's price)

				return true;
			}
			System.out.println("\t\t\tSorry, you do not have enough credit.");
			return false;
		}
		System.out.println("\t\t\tSorry, maximum no. of products reached.");
		return false;
	}

	// can only be called within this class
	private void showProducts() {
		for (int i=0; i<this.productCount; i++) {
			Product p = this.productList[i];
			p.viewState();
		}
	}

	// can be called by a class outside this package
	public void viewState() {
		System.out.println("\n\t\t--------------------------------------------------------------");
		System.out.println("\t\t\tCustomer Information:");
		System.out.println("\t\t--------------------------------------------------------------");

		System.out.println("\t\t\tName: "					+ this.name);
		System.out.println("\t\t\tCredit: "					+ this.credit);
		System.out.println("\t\t\tNo. of products bought: " + this.productCount);
		System.out.println("\t\t\tProducts bought:");
		this.showProducts();

		System.out.println("");
		System.out.println("\t\t--------------------------------------------------------------");

	}


}
