// package declaration
package superautopets;

// class definition
public class Player {
	// attribute(s)
	int gold;
	int hearts;
	int trophies;
	int turnCounter;
	String teamName;

	Pet[] party;
	final static int MAX_PETS = 5;	// constant class attribute
	int petCounter = 0;


	// constructor(s)
	Player(String playerTeamName) {
		// initialize attributes for an instance of the Player
		this.gold = 10;
		this.hearts = 10;
		this.trophies = 0;
		this.turnCounter = 0;

		// assigned the passed parameter playerTeamName to the teamName of the current instance
		this.teamName = playerTeamName;

		// initialize a collection of pets with MAX_PETS size
		this.party = new Pet[Player.MAX_PETS];
	}

	// method(s)
	void buy(Pet[] petChoices, int choiceIndex, int partyPosition) {
		// check if the player still has enough gold to buy something
		if (gold >= 3) {
			System.out.println("\n***** Trying to buy a pet " + petChoices[choiceIndex-1].type.toLowerCase() + "...");
			// check if the position the pet will be placed into is still empty or not
			if (this.party[partyPosition-1] == null) {

				this.party[partyPosition-1] = petChoices[choiceIndex-1]; // assignment of the pet to the empty position
				this.petCounter++;	// increment the petCounter
				gold -= 3;		// apply the logic for gold (decreases by 3 every time a player buys something)

				// inform the user if the pet has been successfully added to the party and placed in a position
				System.out.println("\n***** Successfully placed pet " + petChoices[choiceIndex-1].type.toLowerCase() + " at position " + partyPosition +".");

				// buff a pet friend
				this.party[partyPosition-1].buff(this.party[partyPosition-1].type, this, this.petCounter, partyPosition);

			} else {
				System.out.println("***** Failed to place pet " + petChoices[choiceIndex-1].type.toLowerCase() + " at position " + partyPosition +" since it was already occupied.");
			} // end of an if-else statement

		} else {
			// inform the player if he/she doesn't have enough gold to purchase something
			System.out.println("\n***** Insufficient Gold!");
		} // end of an if-else statement
	} // end of the method

	void roll() {
		// check if the player still has enough gold
		if (gold>0) {
			System.out.println("\nRolled for better pets collection");
			System.out.println("Cost: 1 gold");

			this.gold--; // decrement the value of gold by 1 when the roll method is called
		} else {
			System.out.println("\n***** Insufficient Gold!");
		}

	} // end of the method

	// display the current state of the instances of the class Player
	void viewState() {
		System.out.println("------------ PLAYER -------------");
		System.out.println("Team Name: " + this.teamName);
		System.out.println("Gold: " + this.gold);
		System.out.println("Hearts: " + this.hearts);
		System.out.println("Trophies: " + this.trophies);
		System.out.println("Turn Counter: " + this.turnCounter);
		System.out.println("\nPets(" + this.petCounter + "):");

		// check if the Pet array is still empty or not
		if (this.petCounter == 0) {
			System.out.println("No pets yet.");
		} else {
			int petNumber = 0;
			for (int index = 0; index<Player.MAX_PETS; index++) {
				if (this.party[index] != null) {
					System.out.println("\t" + ++petNumber + ". " + this.party[index].type +"[" + this.party[index].attackLvl + "," + this.party[index].healthLvl + "]" + " at position " + (index+1));
				} // end of if statement
			} // end of for loop
		} // end of if-else statement
	} // end of the method
} // end of the class definition
