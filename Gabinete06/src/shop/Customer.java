// package declaration
package shop;

// import statement(s)
import java.util.ArrayList;

//class definition
public class Customer {

	public final static int MAX_PRODUCT = 50;

	// private Gadget[] gadgetList = new Gadget[Customer.MAX_GADGET];
	// array for the customer's purchases (replacement for the code above)
	private ArrayList<Product> productList = new ArrayList<Product>();

	private String 	name;
	private int productCount;
	private float credit;



	//constructor
	public Customer(String customerName, float credit) {
		this.name 	= customerName;
		this.credit = credit;
	}

	private boolean canAfford(Product p){
		if(this.credit >= p.getPrice()) {
			return true;
		}
		else {
			return false;
		}
	}

	public void buy(Product p){
		System.out.println("#########");
		System.out.println("\tCustomer "+this.name+" is trying to buy "+p.getName()+" from the "+p.getSeller().getName()+".");

		if(this.productCount < Customer.MAX_PRODUCT){	//if customer hasn't reached the max number of products
			if(p.getSeller().find(p.getName())){	//if product is in the collection of seller and is available
				if(this.canAfford(p)){
					this.productList.add(p);
					this.productCount++;

					float val 		= p.getPrice();
					this.credit 	-= val;

					Seller s = p.getSeller();
					s.setProfit(val);
					System.out.println("\tThe product was successfully bought.");
				}else System.out.println("\t"+this.name+" can't afford "+p.getName()+".");
			}else System.out.println("\tThe product "+p.getName()+" is not available in the "+p.getSeller().getName()+".");
		}else System.out.println("\tMaximum number of products bought reached. ");
		System.out.println("#########");
	}

	private void showProducts() {
		for (int i=0; i<this.productCount; i++) {
			Product p = this.productList.get(i);
			System.out.println("\t\t\t\t"+p.getName());
		}
	}

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