package shop;

import java.util.Random;

import player.Player;

public final class Otter extends Pet{
	// constructor(s)
	public Otter(String petType){
		super(Pet.OTTER);

		this.attackLvl = 1;
		this.healthLvl = 2;
	}

	@Override
	public void specialAbility(Player player, int petCounter, int position) {
		// Once bought, buffs a random friend (buffs by adding 1 to attack and health)
		int randomIndex;
		boolean foundRandomPetToBuff = false;

		Random randomNoGenerator = new Random();
		// displays a message that says program is trying to buff a random pet friend
		System.out.println("***Buff a random friend...");

		do {
			// generate a number from 0-4 and store it in the randomIndex integer variable
			randomIndex = randomNoGenerator.nextInt(Player.MAX_PETS);
			// buff a random pet friend's attack and health level attributes
			// check if the currently selected index of the party Pet array isn't empty and isn't equal to the position of the newly created pet instance
			if ( (player.getParty()[randomIndex] != null) && (randomIndex!=(position-1)) ) {
				player.getParty()[randomIndex].attackLvl += 1;
				player.getParty()[randomIndex].healthLvl += 1;
				foundRandomPetToBuff = true;

				System.out.println("***Try pet at position " + (randomIndex+1));
				System.out.println("***Buff friend at position " + (randomIndex+1));
			} // end of the if statement
		} while (foundRandomPetToBuff == false);
		// end of the do-while loop
	}
}

