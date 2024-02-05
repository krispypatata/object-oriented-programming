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
// set to public since it will be used in the OnlineShopApp class which is outside the onlineshop package
public class OnlineShop {

	public final static int 	MAX_SELLER = 50;

	private Seller[] 	sellerList;
	private String 		name;
	private int 		sellerCount;

	//constructor
	// set to public (can be instantiated anywhere)
	public OnlineShop(String name) {
		this.name 			= name;
		this.sellerList 		= new Seller[OnlineShop.MAX_SELLER];
		this.sellerCount 	= 0;
	}

	//TODO: insert getters and setters here


	// other method/s
	// can be called by a class outside this package
	public void addSeller(Seller s1) {
		if(this.sellerCount < OnlineShop.MAX_SELLER) {
			this.sellerList[this.sellerCount] = s1;
			this.sellerCount++;
		}
	}

	// Show all products
	// can be called by a class outside this package
	public void showProducts() {
		for (int i = 0; i<this.sellerCount; i++ ) {
			this.sellerList[i].showProducts();
		}
	}

	// Show all sellers
	// can be called by a class outside this package
	public void showSellers() {
		for (int i = 0; i<this.sellerCount; i++ ) {
			this.sellerList[i].viewState();
		}
	}

	// can be called by a class outside this package
	public Product searchProductById(int productID) {
		for (int i = 0; i<this.sellerCount; i++ ) {
			Product p = sellerList[i].searchProductById(productID);
			if(p!=null) {
				p.viewState();
				return p;  // returns the product object found
			}
		}
		System.out.println("Product with product ID "+productID+" not found.");
		return null; // product does not exist in the store, returns null
	}

	// can be called by a class outside this package
	public void viewState() {
		System.out.println("\n\t\t\tOnline Shop name:\t\t" 	+ this.name);
		System.out.println("\n\t\t\tNo. of sellers:\t\t" 	+ this.sellerCount);
	}

}
