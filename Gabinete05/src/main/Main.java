/*********************************************************************************************************
 * CMSC 22: Introduction to Object-Oriented Programming
 * Laboratory exercise
 * Topic: Inheritance
 *
 * This program revolves around the game called Superautopets
 *
 * Superautopets is a game where two players separately assemble a team of pets.  Each of the pets are
 * selected for their unique abilities in preparation for battle against another team of pets. The game
 * provides a shop that contains a collection of animals (“main collection”) that players can choose to
 * buy from.
 *
 * A player of Superautopets starts with 10 gold, 10 hearts, 0 trophies, and a turn/round counter of 0.
 * Once a player joins the game, a name is assigned to his/her team and the turn count is set to 1.
 * Initially the player’s collection of animals/pets (also called “party”) is empty. The player can add
 * at most 5 pets to his/her party.
 *
 * Crucial to the game is the strategic placement of pets in the party.  For each round, a player goes
 * through a shop phase where he/she chooses from a collection of animals.  Whenever a player buys an
 * animal, the player specifies the position in the party where he/she would like to place the animal.
 *
 * The shop provides shop item choices for the player and it is composed of three (3) animals,  randomly
 * chosen from a bigger collection of animals. The player can buy animals for 3 gold (unless stated
 * otherwise).  The player can also sell pets for 1 gold (unless stated that the animal’s selling value
 * is bigger).
 *
 * The player may choose to “roll” for 1 gold which results in the shop providing a different set of
 * shop items.
 *
 * There are different types of animals and each differ in attack and health levels. All pets start with
 * tier value initially set to 1.  Each of these animals also have special abilities.  The following are
 * the specific abilities upon purchase (in square brackets are the attack and health levels):
 * 		Blue fish[2,3]:  Once bought gives all animals in the party +1 attack and health levels
 *		Otter[1,2]: Once bought, buffs a random friend (buffs by adding 1 to attack and health)
 *		Beaver[2,2]: None upon purchase
 *		Ant[2,1]: None upon purchase
 *		Horse[2,1]: None upon purchase
 *		Duck[1,3]: Whenever the duck is sold, animals currently in the party gain +1 health
 *
 * (c) Institute of Computer Science, CAS, UPLB
 *
 * @author Keith Ginoel S. Gabinete
 * @date 2023-04-1 17:08
 *
 *********************************************************************************************************/
// package declaration
package main;

// import statements
import shop.Pet;
import shop.Shop;
import player.Player;

public class Main {

	public static void main(String[] args) {

		Shop shop = new Shop();
		shop.viewState();

		Player player1 = new Player("Boring icecubes");

		//Game starts; Roll for new set of choices
		shop.roll(player1);

		// shop phase for player 1
		// generate random collection of animals to choose from
		//choose first animal in the list then put in position 5
		Pet p = null;

		p = shop.choose(1);
		if (player1.addPet(p, 5)) shop.setAsBought(1);
		player1.viewState();

		//choose second animal in the list then put in position 4
		p = shop.choose(2);
		if (player1.addPet(p, 4)) shop.setAsBought(2);
		player1.viewState();

		//choose third animal in the list then put in position 3
		p = shop.choose(3);
		if (player1.addPet(p, 3)) shop.setAsBought(3);
		player1.viewState();

		//player1.incrementTurn();

		//sell a pet
		player1.sellPet(3);
		player1.viewState();

		//sell a pet
		player1.sellPet(4);
		player1.viewState();

		//sell a pet
		player1.sellPet(5);
		player1.viewState();



	}

}
