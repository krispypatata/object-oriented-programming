/* package declaration if necessary*/
package onlineseller;

/* import statements if necessary */

/* This class and all its attributes and methods are
 * currently declared with a default access modifier.
 * Apply the correct access modifiers to them based on
 * the given problem domain. */

public class Product {
	private int 	productID;

	private String 	name;
	private String 	description;

	private float 	price;

	private Seller seller;

	private static int totalProducts;

	//constructor
	// set to default (can be instantiated within the package)
	Product(String name, String description, float price) {

		this.productID 		= Product.totalProducts++;		// starts from 0 and increments every newly created product
		this.name 			= name;
		this.description	= description;
		this.price 			= price;
		this.seller			= null;
	}

	//TODO: insert getters and setters here

	// **********************************************************************
	// setter for the seller of the product
	// can be called by a package-mate class
	void setSeller(Seller seller) {
		this.seller = seller;
	}

	// getter for the price of the product
	// can be called by a class outside this package
	public float getPrice() {
		return this.price;
	}

	// getter for the seller of the product
	// can be called by a class outside this package
	public Seller getSeller() {
		return this.seller;
	}

	// getter for the ID of the product
	// can be called by a package-mate class
	int getProductID() {
		return this.productID;
	}

	// getter for the name of the product
	// can be called by a class outside this package
	public String getName() {
		return this.name;
	}

	// **********************************************************************
	// other method/s
	// can be called by a class outside this package
	public void viewState() {

		System.out.println("\t\t\tSeller name:\t" 	+ this.seller.getName());
		System.out.println("\t\t\tName:\t\t" 		+ this.name);
		System.out.println("\t\t\tProduct ID:\t" 	+ this.productID);
		System.out.println("\t\t\tDescription:");
		System.out.println("\t\t\t\t" 				+ this.description);
		System.out.println("\t\t\tPrice is " 		+ this.price + ".\n");

	}

}
