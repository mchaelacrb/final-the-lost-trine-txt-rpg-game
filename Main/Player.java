package Main;

/**
    * This class represents the player and provides methods to get and set the player's name,
    * As well as display the player's profile.
 */
public class Player {
	
	private String name;
    /**
         * The name of the player
         * This field stores the name associated with the object. It serves as a unique identifier or label
         * that helps identify and differentiate the object from others. The name provides a descriptive and meaningful
         * representation of the object, facilitating easy recognition and referencing within the system.
	 */
	private String hero;

    /**
     * To get or display the name of the player.
     * @return 
     */

    public String getName() {
        return name;
    }
    
    /**
     * To set the name of the player.
     * @param name 
     */

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * To display the profile of the player.
     */
	
    public static void playerProfile() {
    	Effects.yellowText(Effects.ANSI_BOLD +"\t\t\t" +Characters.player.getName() + "\n\t\tPlayer's Name"  );
    	System.out.println("\t"+ Characters.selectedHero);
    	Effects.greenText("\t\tLevel: " + Xp.level + "" +Effects.ANSI_RESET);
    	Effects.greenText("\t\tHealth: " + Battle.PHealth+ "/" + Xp.updatedHP);
    	Effects.greenText("\t\tEXP: " + Xp.battleXp+ "/" +Xp.xpNeeded);
    	System.out.println();
    	Effects.yellowText(Effects.ANSI_BOLD +"\t\tStats:"  );
    	
    	Effects.greenText("\t\tAttack Damage: " + Battle.PAttackDmg);
    	Effects.greenText("\t\tDefense: " + Battle.PDefense);
    	Effects.greenText("\t\tWeapon: " + Characters.weapon);


    	System.out.println();
    	Menu.menuButtons();
    	
    }
    
}

