/* package declaration if necessary*/
package onlineseller;

/* import statements if necessary */

/* This class and all its attributes and methods are
 * currently declared with a default access modifier.
 * Apply the correct access modifiers to them based on
 * the given problem domain. */

// class definition
public class Seller {
	// attributes
	public final static int MAX_PRODUCT = 50;

	private Product[] 	productList;
	private String 		name;
	private float 		profit;
	private int 		productCount;

	//constructor
	// set to public (can be instantiated anywhere)
	public Seller(String name) {
		this.name 			= 	name;
		this.profit		= 	5000f;
		this.productCount	=	0;
		this.productList 	= 	new Product[Seller.MAX_PRODUCT];
	}

	//TODO: insert getters and setters here

	// **********************************************************************
	// setter for the profit of the seller
	// can be called by a class outside this package
	public void setProfit(float productPrice) {
		this.profit += productPrice;
	}

	// getter for the name of the seller
	// can be called by a package-mate class
	String getName() {
		return this.name;
	}
	// **********************************************************************
	// created method
	// can be called by a class outside this package
	public Product createProduct(String name, String description, float price) {
		return new Product(name, description, price);
	}
	// **********************************************************************
	// method(s)
	// can be called by a class outside this package
	public void addProduct(Product p1) {

		this.productList[this.productCount] = p1;
		p1.setSeller(this);
		this.productCount++;
	}

	// can be called by a class outside this package
	public void showProducts() {

		for (int i=0; i<this.productCount; i++) {
			Product p = this.productList[i];
			p.viewState();
		}
	}

	// can be called by a class outside this package
	public Product searchProductById(int productId) {

		for (int i=0; i<this.productCount; i++) {
			Product p = this.productList[i];
			if (p.getProductID() == productId) {
				return p;
			}
		}
		return null;	// if product is not found
	}

	// can be called by a class outside this package
	public void viewState() {
		System.out.println("\n\t\t\tSeller name:\t\t" 		+ this.name);
		System.out.println("\t\t\tProfit:\t\t"				+ this.profit);
		System.out.println("\n\t\t\tNo. of products:\t\t" 	+ this.productCount);
		this.showProducts();
	}

}
