/*********************************************************************************************************
 * CMSC 22: Introduction to Object-Oriented Programming
 * Laboratory exercise
 * Topic: Polymorphism
 *
 * This program simulates an online shop
 *
 * ONLINE SHOP
 * An online shop sells products from various sellers (maximum of 50 sellers, and 50 products per seller).
 * The online shop sells three kinds of product: clothing, gadget and grocery. A product has a unique
 * product ID, name, description, seller, and price. A gadget has a product ID, name, description, seller,
 * price, and type. Gadget type can be Laptop, Cellphone, Tablet, Smartwatch. A product can be bought by
 * a customer from a seller. Sellers have a profit, initially 5000, which increases when its product is
 * bought. A seller can add products to their list of products.
 *
 * The customer, with an initial credit of 10000, can buy an item by indicating the product name. If a
 * customer tries to buy a product, the seller finds the product from its collection. If the product is
 * found and the customer can afford it, the customer’s money is decreased by the product’s price and
 * added to the seller’s profit. The product is then added to the customer’s list of product purchases.
 *
 * Clothing and Grocery products are refundable. A refundable object can be refunded to the shop
 * (Just print: Refunding ….<product name>)
 *
 * A seller has a name and its collection of products. It can add products to its collection. A seller
 * can also preview all its products that are refundable. When preview is availed, all refundable products
 * in the collection is displayed.
 *
 * (c) Institute of Computer Science, CAS, UPLB
 *
 * @author Keith Ginoel S. Gabinete
 * @date 2023-04-26 20:08
 *
 *********************************************************************************************************/

// package declaration
package user;

// import statement(s)
import shop.*;

// class definition
public class Main {
	// start of the main program
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OnlineShop shop = new OnlineShop("Lazhopee");

		// Online shop can have up to 50 sellers
		Seller s1 = new Seller("Kimmy Store");

		Customer juan = new Customer("Juan dela Cruz",10000);
		Customer cardo = new Customer("Cardo Dalisay",10000);

		Gadget gadget1 = new Gadget("Nokia 3210", "A vintage phone",Gadget.CELLPHONE, 1000.0f);
		Gadget gadget2 = new Gadget("Ipad 8th Gen", "Second hand tablet used for online class only" , Gadget.TABLET, 12000);
		Gadget gadget3 = new Gadget("Xiaomi Mi Band 7 Pro", "Leather Textured Silicone Strap Global Version With 1.64 Inch Amoled", Gadget.SMARTWATCH,5000);

		Clothing clothing1 = new Clothing("Women Sleepwear Pajama", "Very Comfortable night wear during summer ","New Arrival", "Cotton",750f);
		Clothing clothing2 = new Clothing("Satin Sleeveless Dress", "Fashionalbe Elegant Dress for Weddings", "Dress","Silk", 1500f);

		Grocery grocery1 = new Grocery("Toothpaste","Whitens teeth with fresh breathness","Colgate",3,215);
		Grocery grocery2 = new Grocery("Mango","Ripe Mango from Zambales","N/A",5,95);

		// Add seller to online shop's array of sellers (up to 50)
		shop.addSeller(s1);

		s1.add(gadget1);
		s1.add(gadget2);
		s1.add(gadget3);
		s1.add(clothing1);
		s1.add(clothing2);
		s1.add(grocery1);
		s1.add(grocery2);

		juan.buy(gadget1);
		juan.buy(gadget3);
		juan.buy(gadget2);
		juan.buy(grocery1);
		cardo.buy(clothing1);
		cardo.buy(clothing2);
		cardo.buy(grocery2);
		s1.viewState();

		juan.viewState();
		cardo.viewState();

		gadget1.viewInfo();
		gadget2.viewInfo();
		gadget3.viewInfo();
		clothing1.viewInfo();
		clothing2.viewInfo();
		grocery1.viewInfo();
		grocery2.viewInfo();

		s1.preview();

	}

}
