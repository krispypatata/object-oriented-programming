/***************************************************************************************
 * CMSC 22: Introduction to Object-Oriented Programming
 * Laboratory exercise
 * Topic: Encapsulation
 *
 * This is a simple program that simulates an online shop
 *
 * An online shop sells products from various sellers (maximum of 50 sellers, and 50
 * products per seller). An item has a unique product ID, name, description, seller,
 * and price. Sellers have a profit, initially 5000, which increases when its product
 * is bought. A seller can add products to their list of products.
 *
 * The customer, with an initial credit of 1000, can buy an item by indicating the
 * product ID. When a product is bought, the price is deducted from the customer’s
 * credit and added to the seller’s profit. The product is then added to the customer’s
 * list of product purchases.
 *
 * (c) Institute of Computer Science, CAS, UPLB
 *
 * @author Keith Ginoel S. Gabinete
 * @date 2023-03-26 12:18
 *
 ***************************************************************************************/

// package declaration
package user;

/* import statements if necessary */
import java.util.Scanner;				// java built-in package

//import user-defined packages
import onlineseller.Seller;
import onlineseller.Product;
import onlineshop.Customer;
import onlineshop.OnlineShop;

class OnlineShopApp {

	public static void main(String[] args){
		int choice;
		Scanner sc = new Scanner(System.in);

		OnlineShop shop = new OnlineShop("Lazhopee");

		// Online shop can have up to 50 sellers
		Seller s1 = new Seller("Kimmy Store");

		// Product p1 = new Product("Wireless Charger", "Wireless charger for android phones", 1000.0f);
		Product p1 = s1.createProduct("Wireless Charger", "Wireless charger for android phones", 1000.0f);

		// Add product to seller's array of products
		s1.addProduct(p1);

		// Add seller to online shop's array of sellers (up to 50)
		shop.addSeller(s1);

		// Online shop can have up to 50 sellers
		Seller s2 = new Seller("CDR-Queen");

		// Each seller can have up to 50 products
		// Product p2 = new Product("SD Card", "Class 10 MicroSD", 500.0f);
		Product p2 = s2.createProduct("SD Card", "Class 10 MicroSD", 500.0f);

		// Add product to seller's array of products (up to 50)
		s2.addProduct(p2);

		// Add seller to online shop's array of sellers (up to 50)
		shop.addSeller(s2);

		shop.viewState();

		Customer customer = new Customer("Juan dela Cruz");

		do{
			OnlineShopApp.printMenu();
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			OnlineShopApp.executeChoice(choice,customer,shop);

		}while(choice!=0);
	}//end of main method

	static void printMenu(){
		System.out.println("\n\n==========ONLINE SHOP MENU==========");
		System.out.println("[1] - View all products");
		System.out.println("[2] - Buy");
		System.out.println("[3] - View my information");
		System.out.println("[4] - View all sellers (For verification only)");
		System.out.println("[0] - Exit");
		System.out.println("====================================");

	}//end of printMenu

	static void executeChoice(int choice, Customer customer, OnlineShop shop){
		Scanner sc = new Scanner(System.in);

		switch(choice){
				case 1: System.out.println("View all products");
						shop.showProducts();
						break;
				case 2: System.out.println("Buy");
						System.out.println("Enter product ID:");
						int productID = sc.nextInt();

						Product foundProduct = shop.searchProductById(productID);
						if(foundProduct != null) {
							boolean b = customer.buy(foundProduct);

							if(b) System.out.println("\n\tSuccessfully bought "+foundProduct.getName()); // if buy() method returns true
							else System.out.println("\n\tTransaction unsuccessful.");
						}
						break;
				case 3: System.out.println("View my information");
						customer.viewState();
						break;
				case 4: System.out.println("View all sellers");
						shop.showSellers();
						break;
				case 0: System.out.println("Bye!");
						System.exit(1);
				default: System.out.println("Invalid input. Try again.");
			}
	}


}
