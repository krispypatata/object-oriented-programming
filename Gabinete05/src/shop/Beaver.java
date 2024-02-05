package shop;

import player.Player;

public final class Beaver extends Pet{
	// constructor(s)
	public Beaver (String petType){
		super(Pet.BEAVER);

		this.attackLvl = 2;
		this.healthLvl = 2;
	}

	// method(s)

	@Override
	public void specialAbility(Player player, int petCounter, int partyPosition) {
		// Don't do anything
	}
}
