// package declaration
package shop;

//import statement(s)

public class Clothing extends Product implements Refundable{
	// attribute(s)
	private String category;
	private String fabric;

	// Constructor(s)
	public Clothing(String name, String description, String category, String fabric, float price) {
		super(name, description, price);
		this.category = category;
		this.fabric = fabric;
	}

	// method(s)
	// display the state of the clothing product
	public void viewInfo(){
		System.out.println("===========CLOTHING STATE=============");
		super.viewState();
		System.out.println("\tCategory : "+this.category);
		System.out.println("\tFabric : "+this.fabric);
		System.out.println("===================================");

	}

	@Override
	public void refund() {
		// No Need to apply the logic on refunding
	}

}
