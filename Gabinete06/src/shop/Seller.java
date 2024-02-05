// package declaration
package shop;

// import statement(s)
import java.util.ArrayList;

//class definition
public class Seller {
	// attribute(s)
	public final static int MAX_PRODUCT = 50;

	// private Gadget[] 	gadgetList;
	// array for seller's available products (replacement for the code above)
	private ArrayList<Product> productList;

	private String 		name;
	private float 		profit;
	private int 		productCount;

	//constructor
	public Seller(String name) {
		this.name 			= 	name;
		this.profit		= 	5000f;
		this.productCount	=	0;
		this.productList 	= 	new ArrayList<Product>();
	}

	// a seller can add products to their list of products
	public void add(Product p1) {

		if(this.productCount < Seller.MAX_PRODUCT){
			this.productList.add(p1);
			p1.setSeller(this);
			this.productCount++;
			System.out.println("Product "+p1.getName()+" added to "+p1.getSeller().getName()+"'s collection.");
		}else{
			System.out.println("Maximum number of allowed products reached.");
		}

	}



	// All the following methods should be default not public
	void showProducts() {

		for (int i=0; i<this.productCount; i++) {
			Product p = this.productList.get(i);
			System.out.println("\t\t\t\t"+p.getName());
		}
	}


	String getName() {
		return this.name;
	}

	void setProfit(float val) {
		this.profit += val;
	}

	public boolean find(String name2) {
		for(int i=0;i<this.productCount;i++){
			if(name2.equals(this.productList.get(i).getName())){
				//if the ebook is in the collection
				System.out.println("\tThe product "+name2+" is in seller "+this.name+"'s collection.");
				return true;
			}
		}
		return false;
	}

	public void viewState() {
		System.out.println("\n\t\t\tSeller name:\t\t" + this.name);
		System.out.println("\t\t\tProfit:\t\t" + this.profit);
		System.out.println("\n\t\t\tNo. of products:\t\t" + this.productCount);
		this.showProducts();
	}

	// View the refundable products in seller's shop
	public void preview() {
		for (int i=0; i<this.productCount; i++) {
			if(this.productList.get(i) instanceof Refundable) {
				System.out.println(">> Refunding... " + this.productList.get(i).getName());
			}
		}
	}

}