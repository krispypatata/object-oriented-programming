package shop;

import player.Player;

public final class Horse extends Pet{
	// constructor(s)
	public Horse(String petType){
		super(Pet.HORSE);

		this.attackLvl = 2;
		this.healthLvl = 1;
	}

	@Override
	public void specialAbility(Player player, int petCounter, int position) {
		// Don't do anything
	}
}
