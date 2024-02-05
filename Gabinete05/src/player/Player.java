// package declaration
package player;

import shop.Ant;
import shop.BlueFish;
import shop.Duck;
import shop.Pet;

// class definition
public class Player {
	// attribute(s)
	private int gold;
	private int hearts;
	private int trophies;
	private int turnCounter;
	private String teamName;
	private Pet[] party;
	private int petCounter = 0;

	public final static int MAX_PETS = 5;	// constant class attribute

	// constructor(s)
	public Player(String playerTeamName) {
		// initialize attributes for an instance of the Player
		this.gold = 10;
		this.hearts = 10;
		this.trophies = 0;
		this.turnCounter = 1;

		// assigned the passed parameter playerTeamName to the teamName of the current instance
		this.teamName = playerTeamName;

		// initialize a collection of pets with MAX_PETS size
		this.party = new Pet[Player.MAX_PETS];
	}

	// setter(s) and getter(s)
	public Pet[] getParty(){
		return this.party;
	}

	// getter for gold
	public int getGold(){
		return this.gold;
	}

	// setter for gold
	public void setGold(int change) {
		this.gold+=change;
	}

	// method(s)

	// buy a pet from the shop
	public boolean addPet(Pet pet, int position) {
		if (this.gold>=3) {
			System.out.println("\n***Trying to buy " + pet.getType() + "...\n");
			// check if the position the pet will be placed into is still empty or not
			if (isOccupied(this.party[position-1]) == false) {

				this.petCounter++;	// increment the petCounter
				gold -= 3;		// apply the logic for gold (decreases by 3 every time a player buys something)

				if (pet.getType().equals(Pet.OTTER)) {
					pet.specialAbility(this, this.petCounter, position); // buff a pet friend
					this.party[position-1] = pet; // assignment of the pet to the empty position
				} else {
					this.party[position-1] = pet; // assignment of the pet to the empty position
					pet.specialAbility(this, this.petCounter, position); // buff a pet friend
				}

				// inform the user if the pet has been successfully added to the party and placed in a position
				System.out.println("***Successfully bought " + pet.getType() + ". Placing on position " + position +".\n");

				return true;
			} else {
				System.out.println("***Failed to place pet " + pet.getType() + " at position " + position +" since it was already occupied.");
				return false;
			}

		} else {
			// inform the player if he/she doesn't have enough gold to purchase something
			System.out.println("\n***Insufficient Gold!");
			return false;
		}
	}


	// sell a pet from the player's party
	public void sellPet(int position) {
		if (isOccupied(this.party[position-1]) == false) {
			System.out.println("\n***Trying to sell... ERROR");
			System.out.println("***There's no pet in position " + position + "...\n");
		} else {
			System.out.println("\n***Trying to sell " + this.party[position-1].getType() + " at position " + position + "...\n");
			if (this.party[position-1].getType().equals(Pet.DUCK)) {
				this.party[position-1].setIsSellMethod(true);
				// buff a pet friend
				this.party[position-1].specialAbility(this, this.petCounter, position);
			}


			this.party[position-1] = null;
			this.gold+=1;

		}
	}

	// check if the there's no pet in the current index of the player's pet party
	boolean isOccupied(Pet pet) {
		if (pet==null) {
			return false;
		} else {
			return true;
		}
	}

	// display the current state of the instances of the class Player
	public void viewState() {
		System.out.println("------------ PLAYER -------------");
		System.out.println("Team Name: " + this.teamName);
		System.out.print("Gold: " + this.gold);
		System.out.print("  Hearts: " + this.hearts);
		System.out.print("  Trophies: " + this.trophies);
		System.out.println("  Turn: " + this.turnCounter);
		System.out.print("Pet Party: <<");

		// print the contents of the Pet array named party
		for (int i =0; i<Player.MAX_PETS; i++) {
			if (isOccupied(this.party[i])==false) {
				System.out.print(" ___");
				if (i!=Player.MAX_PETS-1) {
					System.out.print(",");
				}
			} else {
				System.out.print(" ");
				this.party[i].viewState();
				if (i!=Player.MAX_PETS-1) {
					System.out.print(",");
				}
			}
		}
		System.out.print(">>\n");

	} // end of the method

	// increment's player turn
	public void incrementTurn() {
		this.turnCounter++;
	}

	// create a method that will provide new pet choices for the user
	public void roll(Pet[] choices) {
		// check if the player still has enough gold
		if (this.gold>0) {
			choices[0] = new Ant(Pet.ANT);
			choices[1] = new Duck(Pet.DUCK);
			choices[2] = new BlueFish(Pet.BLUE_FISH);

			System.out.println("\n***Rolling... ");
			System.out.println("***Cost: 1 gold ");
			System.out.println("Animal choices: ");
			System.out.print("<< ");
			choices[0].viewState();
			System.out.print(", ");
			choices[1].viewState();
			System.out.print(", ");
			choices[2].viewState();
			System.out.println(">>");

			this.gold--; // decrement the value of gold by 1 when the roll method is called
		} else {
			System.out.println("\n***** Insufficient Gold!");
		}
	}

} // end of the class definition
