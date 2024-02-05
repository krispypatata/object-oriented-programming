// package declaration
package shop;

//class definition
public class Product {
	private int productID;

	protected String name;
	private String description;

	protected float price;

	private Seller seller;

	private static int totalProducts;

	//constructor
	public Product(String name, String description, float price) {

		this.productID = Product.totalProducts++;		// starts from 0 and increments every newly created product
		this.name = name;
		this.description = description;
		this.price = price;
		this.seller	= null;
	}

	public String getName() {
		return this.name;
	}

	int getProductID() {
		return this.productID;
	}

	float getPrice() {
		return this.price;
	}

	Seller getSeller() {
		return this.seller;
	}

	void setSeller(Seller seller) {
		this.seller = seller;
	}


	protected void viewState() {

		System.out.println("\t\t\tSeller name:\t" 	+ this.seller.getName());
		System.out.println("\t\t\tName:\t\t" 		+ this.name);
		System.out.println("\t\t\tProduct ID:\t" 	+ this.productID);
		System.out.println("\t\t\tDescription:");
		System.out.println("\t\t\t\t" 				+ this.description);
		System.out.println("\t\t\tPrice is " 		+ this.price + ".\n");

	}

}