// package declaration
package shop;

public class Grocery extends Product implements Refundable{
	// attribute(s)
	private String brand;
	private int stock;

	// Constructor(s)

	public Grocery(String name, String description, String brand, int stock, float price) {
		super(name, description, price);
		this.brand = brand;
		this.stock = stock;
	}

	// method(s)
	// display the state of the grocery product
	public void viewInfo(){
		System.out.println("===========GROCERY STATE=============");
		super.viewState();
		System.out.println("\tBrand : "+this.brand);
		System.out.println("\tStocks : "+this.stock);
		System.out.println("===================================");

	}

	@Override
	public void refund() {
		// No Need to apply the logic on refunding
	}
}
