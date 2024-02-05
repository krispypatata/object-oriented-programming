// package declaration
package shop;

import player.Player;

// class definition
public abstract class Pet {
	// attribute(s)
	protected String type;
	protected int attackLvl;
	protected int healthLvl;
	protected int tier = 1;
	protected int cost = 3;
	protected boolean isSellMethod = false;

	// constants
	public final static String ANT = "Ant";
	public final static String BEAVER = "Beaver";
	public final static String BLUE_FISH = "Blue Fish";
	public final static String OTTER = "Otter";
	public final static String HORSE = "Horse";
	public final static String DUCK = "Duck";

	// constructor(s)
	public Pet(String petType) {
		this.type = petType;
	}

	// setter(s) and getter(s)
	// getter for petType
	public final String getType() {
		return this.type;
	}

	// setter for isSellMethod
	public final void setIsSellMethod(boolean bool) {
		this.isSellMethod = bool;
	}

	// buff certain pet/s
	// accepts parameters with data type Player (for the instance of a Player class),
	// integer (for the total number of pets in the party of pets of the player, integer (for the position of the newly added pet instance)
	public abstract void specialAbility(Player player, int petCounter, int position);


	// view the state of the current pet
	public void viewState() {
		System.out.print(this.type + "[" + this.attackLvl + "," + this.healthLvl + "]");
	}


} // end of the class definition
