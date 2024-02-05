/*************************************************************************************
 * CMSC 22: Introduction to Object-Oriented Programming
 * Laboratory exercise
 * Topic: Abstraction
 *
 * This program revolves around the game called Superautopets
 *
 * A player of Superautopets starts with 10 gold, 10 hearts, 0 trophies, and a
 * turn counter of 0. Once a player joins the game, a name is assigned to the team.
 * Initially the player’s collection of pets (also called “party”) is empty.
 * Later on, the player can add at most 5 animals or pets to the party.
 *
 * Crucial to the game is the strategic placement of animals in the party.
 * Each animal is assigned a “pet type”, attack level, health level, and tier (initially at 1).
 * A collection of 3 pets is available for the player to choose from.
 * The following are the animals that can show up in the collection: Blue fish, Beaver, Otter and Ant.
 * Each of these animals have special abilities.  The following are the specific abilities upon purchase:
 * Blue fish: Once bought gives all animals in the party +1
 * Otter: Once bought, buffs a random friend (buffs by adding 1 to attack and health)
 * Beaver: None upon purchase
 * Ant: None upon purchase
 *
 * The player can “roll” which costs 1 gold and this results in a fresh collection of animals to choose from.
 *
 * The goal is to prepare the player for combat.
 *
 * (c) Institute of Computer Science, CAS, UPLB
 *
 * @author Keith Ginoel S. Gabinete
 * @date 2023-03-18 03:41
 *
 *************************************************************************************/
// package declaration
package superautopets;

public class Main {

	public static void main(String[] args) {

		/* First, a Player object.
		 *
		 * When creating Player objects, the following are set:
		 *  hearts, gold, trophies, turn_counter, collection of pets (array with max size of 5),
		 *  and pet counter
		 */
		Player player = new Player("The Crunchy Teabags");
		player.viewState(); // show the state of object


		/* Next, create animals/pets that player can choose from.
		 *
		 * When creating Pet objects, the following are specified
		 *  (in the same order as it appears in the code below):
		 *  pet type, attack level, health level, and tier
		 *  -- note that some of these attributes are not really used here in this app yet such as tier, etc.
		 *  but they are part of the game specs
		 */
		Pet otter1 = new Pet(Pet.OTTER,2,3,1);
		Pet beaver1 = new Pet(Pet.BEAVER,2,2,1);
		Pet fish1 = new Pet(Pet.BLUEFISH,2,3,1);

		/* Next, create pet choices array.
		 */
		Pet[] petChoices = new Pet[3];
		petChoices[0] = otter1;
		petChoices[1] = beaver1;
		petChoices[2] = fish1;

		/* Player starts to buy pets and strategically places them at certain positions.
		 */
		player.buy(petChoices, 3, 4);
		player.viewState();

		player.buy(petChoices, 1, 3);
		player.viewState();

		/* Player would like a new set of pets to choose from.
		 */
		player.roll();

		Pet ant1 = new Pet(Pet.ANT,2,1,1);
		Pet fish2 = new Pet(Pet.BLUEFISH,2,3,1);
		Pet ant2 = new Pet(Pet.ANT,2,1,1);

		Pet[] petChoices2 = new Pet[3];
		petChoices2[0] = ant1;
		petChoices2[1] = fish2;
		petChoices2[2] = ant2;

		/* Player buys another pet and strategically places them at a certain position
		 */
		player.viewState();

		player.buy(petChoices2, 2, 5);

		player.viewState();

		System.out.println("\nREADY FOR COMBAT :)");


	}

}
