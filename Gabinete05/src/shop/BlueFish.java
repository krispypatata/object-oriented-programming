package shop;

import player.Player;

public final class BlueFish extends Pet{
	// constructor(s)
	public BlueFish(String petType){
		super(Pet.BLUE_FISH);

		this.attackLvl = 2;
		this.healthLvl = 3;
	}

	// method(s)

	@Override
	public void specialAbility(Player player, int petCounter, int position) {
		System.out.println("\n***Buff all friends");
		System.out.println("***Cannot buff self");

		// loop through the party Pet array and apply the logic on each pet's attack and health level
		for (int index=0; index<Player.MAX_PETS; index++) {
			if ( (player.getParty()[index] != null) && (index!=(position-1)) ) {
				player.getParty()[index].attackLvl += 1;
				player.getParty()[index].healthLvl +=1;
				System.out.println("***Buffing pet at position " + (index+1));
			} // end of the if statement
		} // end of the for loop
	}
}
