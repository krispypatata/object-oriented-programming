// package declaration
package shop;

//class definition
public class OnlineShop {

	private final static int 	MAX_SELLER = 50;

	private Seller[] 	sellerList;
	private String 		name;
	private int 		sellerCount;

	//constructor
	public OnlineShop(String name) {
		this.name 			= name;
		this.sellerList 	= new Seller[OnlineShop.MAX_SELLER];
		this.sellerCount 	= 0;
	}

	public void addSeller(Seller s1) {
		if(this.sellerCount < OnlineShop.MAX_SELLER) {
			this.sellerList[this.sellerCount] = s1;
			this.sellerCount++;
		}
	}

	// Show all products
	public void showProducts() {
		for (int i = 0; i<this.sellerCount; i++ ) {
			this.sellerList[i].showProducts();
		}
	}

	// Show all sellers
	public void showSellers() {
		for (int i = 0; i<this.sellerCount; i++ ) {
			this.sellerList[i].viewState();
		}
	}


	public void viewState() {
		System.out.println("\n\t\t\tOnline Shop name:\t\t" 	+ this.name);
		System.out.println("\n\t\t\tNo. of sellers:\t\t" 	+ this.sellerCount);
	}

}