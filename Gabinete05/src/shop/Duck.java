package shop;

import player.Player;

public final class Duck extends Pet{
	// constructor(s)
	public Duck(String petType){
		super(Pet.DUCK);

		this.attackLvl = 1;
		this.healthLvl = 3;
	}

	@Override
	public void specialAbility(Player player, int petCounter, int position) {
		if (isSellMethod) {
			System.out.println("***Buff health of all friends...");
			// loop through the party Pet array and apply the logic on each pet's attack and health level
			for (int index=0; index<Player.MAX_PETS; index++) {
				if ( (player.getParty()[index] != null) && (index!=(position-1)) ) {
					player.getParty()[index].healthLvl +=1;
					System.out.println("***Buffing health of pet at position " + index);
				} // end of the if statement
			} // end of the for loop
		}
	}
}
