// package declaration
package superautopets;

// import statement
import java.util.Random;

// class definition
public class Pet {
	// attribute(s)
	String type;
	int attackLvl;
	int healthLvl;
	int tier = 1;

	// constants
	final static String ANT = "Ant";
	final static String BEAVER = "Beaver";
	final static String BLUEFISH = "Blue Fish";
	final static String OTTER = "Otter";


	// constructor(s)
	Pet(String petType, int petAttackLvl, int petHealthLvl, int petTier) {
		this.type = petType;
		this.attackLvl = petAttackLvl;
		this.healthLvl = petHealthLvl;
		this.tier = petTier;
	}

	// method(s)

	// buff certain pet/s
	// accepts parameters with data type String (for the pet specific type), Player (for the instance of a Player class)
	// integer (for the total number of pets in the party of pets of the player, integer (for the position of the newly added pet instance)
	void buff(String petType, Player player, int petCounter, int partyPosition) {
		switch(petType) {
			case Pet.ANT:
				break;

			case Pet.BEAVER:
				break;

			case Pet.BLUEFISH:
				// check if the newly added otter is the only content of the player's party
				if (petCounter == 1) {
					System.out.println("***** No pet friend is available to buff");
					break;
				} // end of the if statement

				// loop through the party Pet array and apply the logic on each pet's attack and health level
				for (int index=0; index<Player.MAX_PETS; index++) {
					if ( (player.party[index] != null) && (index!=(partyPosition-1)) ) {
						player.party[index].attackLvl += 1;
						player.party[index].healthLvl +=1;
					} // end of the if statement
				} // end of the for loop
				System.out.println("\n***** Blue fish gives all friends +1 attack and +1 health ...");
				break;

			case Pet.OTTER:
				int randomIndex;
				boolean foundRandomPetToBuff = false;

				Random randomNoGenerator = new Random();

				// displays a message that says program is trying to buff a random pet friend
				System.out.println("\n***** Otter to buff random friend...");

				// check if the newly added otter is the only content of the player's party
				if (petCounter == 1) {
					System.out.println("***** No pet friend is available to buff");
					break;
				} // end of the if statement

				do {
					// generate a number from 0-4 and store it in the randomIndex integer variable
					randomIndex = randomNoGenerator.nextInt(Player.MAX_PETS);
					// buff a random pet friend's attack and health level attributes
					// check if the currently selected index of the party Pet array isn't empty and isn't equal to the position of the newly created pet instance
					if ( (player.party[randomIndex] != null) && (randomIndex!=(partyPosition-1)) ) {
						player.party[randomIndex].attackLvl += 1;
						player.party[randomIndex].healthLvl += 1;
						foundRandomPetToBuff = true;

						System.out.println("***** Buff pet "+ player.party[randomIndex].type.toLowerCase() + " at position " + (randomIndex+1));
					} // end of the if statement
				} while (foundRandomPetToBuff == false);
				// end of the do-while loop
				break;

			default:
				break;
		} // end of the swith-case statement
	} // end of the method
} // end of the class definition
