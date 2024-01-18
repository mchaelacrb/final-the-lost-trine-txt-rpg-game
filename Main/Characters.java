package Main;
import java.util.Scanner;

/**
 * This class is for the character hero's of the game.
 * @author Bianca
 */
public class Characters {
	static Scanner in = new Scanner(System.in);
	static Player player = new Player();
	static int hero;
	static String selectedHero;
	
	
    //based attributes for each hero//
        
        public static int attackDamage;
      /**
		* Represents the default amount of damage the player can inflict on enemies.
	  */
        
        public static int health;
        /**
		* Represents the default health of the player.
		*/
        
        
        public static int defense;
        /**
        * Represents the player's default defense, which reduces incoming damage.
        */
        
        public static String weapon;
        /**
		* Represents the player's primary weapon.
		*/
        
        
        public static String weapon2;
	/**
	 * Represents the player's secondary weapon.
	 */
        
	public static void archerStats() {
		attackDamage = 40;
		health = 75;
		defense = 10;
		weapon = "bow";
		weapon2 = "gun";
		
		Battle.PHealth = health;
		Battle.PAttackDmg = attackDamage;
		Battle.PDefense = defense;
		
		Shop.addWeaponUpgrade(weapon, 100);
		Shop.addWeaponUpgrade(weapon2, 700);
		
	}
	
        /**
         * Statistics for warrior, where every attribute of warrior is defined here.
         */
        
	public static void warriorStats() {
		attackDamage = 20;
		health = 100;
		defense = 20;
		weapon = "sword";
		weapon2 = "axe";
		
		Battle.PHealth = health;
		Battle.PAttackDmg = attackDamage;
		Battle.PDefense = defense;
		
		Shop.addWeaponUpgrade(weapon, 100);
		Shop.addWeaponUpgrade(weapon2, 1000);
		
	}
	
        /**
         * Creating of a character happens in this method, where we set the players name.
         */

	public static void characterCreation() {
	
        Effects.printLines(100);
        Effects.delayPrint(0, "Enter your name: ");
		String inname = in.nextLine();
	    player.setName(inname);
		Effects.delayPrint(0, player.getName() + " is your name? Enter y if yes and n for no.\n> ");
		String ansName = in.nextLine();
				if (ansName.equalsIgnoreCase("y") ) {
					heroSelection();
					
				} else if (ansName.equalsIgnoreCase("n")) {
						characterCreation();
						Effects.printLines(100);
				} else {
					Effects.redText("Invalid Input. \n");
					characterCreation();
				}	
	}
	
        /**
         * Selecting a hero happens in this method, where we set what the player preferred hero.
         */
	
	public static void heroSelection() {
		
		try{
		Effects.printLines(100);
		System.out.println("Please choose a Hero:");
		System.out.println();
		System.out.print("1 : Warrior\n2 : Archer\nEnter the number:\n> " );
		hero = in.nextInt();in.nextLine();
		Effects.printLines(100);
                
                } catch(Exception e){
        			Effects.redText("Invalid Input. Enter the number indecated above.");
                    in.nextLine();
                    heroSelection();
                } 
                
                        
		boolean heroSelecton = true;
		
		
		CHOOSE:
		while (heroSelecton) {
                try {
		if (hero == 1) {
			System.out.println("Hello "+ player.getName()+ ", You chose Warrior Are you sure?");
			System.out.print("Enter y if yes and n for no\n> ");
			selectedHero = "Warrior";
			warriorStats();
	
			String warrior = in.nextLine();
			
				if (warrior.equalsIgnoreCase("y") ) {
					Effects.printLines(100);
					Effects.delayPrint(60,"Game Starting");
					Effects.periods(50);
					Effects.printLines(100);
					Effects.clearConsole();
					//Player.playerProfile();
					Story.story.defaultPlace();
					

					break;

					} else if (warrior.equalsIgnoreCase("n")) {
						Effects.printLines(100);
						Shop.removeItem(weapon);
						Shop.removeItem(weapon2);
						heroSelection();
			
					} else {
						Effects.redText("Invalid Input.");
						Effects.printLines(100);
						continue CHOOSE;
					}
				
		} else if (hero == 2) {
			System.out.println("Hello "+ player.getName()+ ", You chose Archer Are you sure?");
			System.out.print("Enter y if yes and n for no\n> ");
			selectedHero = "Archer";
			archerStats();

			
			String archer = in.nextLine();
			
			if (archer.equalsIgnoreCase("y") ) {
				Effects.printLines(100);
				Effects.delayPrint(60,"Game Starting");
				Effects.periods(50);
				Effects.printLines(100);
				Effects.clearConsole();
				Story.story.defaultPlace();

				break;

			} else if (archer.equalsIgnoreCase("n")) {
				Effects.printLines(100);
				Shop.removeItem(weapon);
				Shop.removeItem(weapon2);
				heroSelection();
				
			} else {
				Effects.redText("Invalid Input.");
				Effects.printLines(100);
				continue CHOOSE;
				}
			
		} else {
			Effects.redText("Invalid Input.");
            heroSelection();
			
		}
		
		} catch (Exception e) {
			Effects.printLines(100);
			System.out.println("Invalid Input.Please try again.");
            in.nextLine();	
		    continue CHOOSE;

		}
		}
		
	}

	
}


