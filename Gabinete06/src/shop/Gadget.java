// package declaration
package shop;

// class definition
public class Gadget extends Product{
	private String type;

	public final static String LAPTOP = "Laptop";
	public final static String CELLPHONE = "Cellphone";
	public final static String TABLET = "Tablet";
	public final static String SMARTWATCH = "Smartwatch";

	public Gadget(String name, String description, String type, float price) {
		super(name, description, price);
		this.type = type;
	}

	public void viewInfo(){
		System.out.println("===========GADGET STATE=============");
		super.viewState();
		System.out.println("\tType : "+this.type);
		System.out.println("===================================");

	}
}
