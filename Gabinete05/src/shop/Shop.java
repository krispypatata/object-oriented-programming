package shop;

import player.Player;

public class Shop {
	// attribute(s)
	private Pet mainCollection[];
	private Pet choices[];

	public static int ANIMAL_COLLECTION = 6;
	public static int MAX_ANIMAL_CHOICES = 3;

	// constructor(s)
	public Shop() {
		mainCollection = new Pet[Shop.ANIMAL_COLLECTION];
		mainCollection[0] = new BlueFish(Pet.BLUE_FISH);
		mainCollection[1] = new Otter(Pet.OTTER);
		mainCollection[2] = new Beaver(Pet.BEAVER);
		mainCollection[3] = new Ant(Pet.ANT);
		mainCollection[4] = new Horse(Pet.HORSE);
		mainCollection[5] = new Duck(Pet.DUCK);

		choices = new Pet[Shop.MAX_ANIMAL_CHOICES];
	}


	// method(s)
	// view the state of the shop
	// can be accessed by a class outside this package
	public void viewState() {
		System.out.println("-------------- Superautopets Shop -----------------");
		System.out.println("Available animals: << "+ Pet.BLUE_FISH +", "+ Pet.OTTER +", "+ Pet.BEAVER +", "+ Pet.ANT +", "+ Pet.HORSE +", "+ Pet.DUCK +">> ");

	}

	// create a method that will provide new pet choices from the shop
	public void roll(Player player) {
		// sample run 1
		choices[0] = new Ant(Pet.ANT);
		choices[1] = new Duck(Pet.DUCK);
		choices[2] = new BlueFish(Pet.BLUE_FISH);

		// sample run 2
//		choices[0] = new Duck(Pet.DUCK);
//		choices[1] = new Duck(Pet.DUCK);
//		choices[2] = new Ant(Pet.ANT);

		// sample run 3
//		choices[0] = new Ant(Pet.ANT);
//		choices[1] = new Horse(Pet.HORSE);
//		choices[2] = new Otter(Pet.OTTER);

		System.out.println("\n***Rolling... ");
		System.out.println("Animal choices: ");
		System.out.print("<< ");
		choices[0].viewState();
		System.out.print(", ");
		choices[1].viewState();
		System.out.print(", ");
		choices[2].viewState();
		System.out.println(">>");
	}

	// choose a pet to be sold from the available choices
	public Pet choose(int position) {
		if (this.choices[position-1] == null) {
			System.out.println("***Failed to choose a pet from the shop...");
			System.out.println("***There's no pet in the desired position...");
		} else {
			return this.choices[position-1];
		}
		return null;
	}

	// removes the sold pet from the availabe choices
	public void setAsBought(int position) {
		this.choices[position-1] = null;
	}
}
