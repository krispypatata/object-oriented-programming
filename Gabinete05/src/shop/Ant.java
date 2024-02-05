package shop;

import player.Player;

public final class Ant extends Pet{
	// constructor(s)
	public Ant(String petType){
		super(Pet.ANT);

		this.attackLvl = 2;
		this.healthLvl = 1;
	}

	@Override
	public void specialAbility(Player player, int petCounter, int partyPosition) {
		// Don't do anything
	}
}
