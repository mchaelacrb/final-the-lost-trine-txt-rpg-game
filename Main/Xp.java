package Main;

/**
 	* This class serves to track the stats and experience of battles in the game.
 */
public class Xp {

	public static int xpDrop =  50;
	/**
         * The amount of experience points (XP) dropped by an entity.
		 * This field represents the number of experience points dropped by an entity when defeated or killed.
         * The value of this field is set to 50, indicating a standard XP drop amount.
         * Experience points serve as rewards for players, 
		   allowing them to level up and improve their character's abilities. 
	 */
	public static int xpNeeded = 200;
	/**
	* The amount of experience points (XP) needed to level up.
	* This field represents the number of experience points required for a player to level up.
    * The value of this field is set to 200, indicating the XP threshold for advancing to the next level.
    * Players must accumulate this amount of XP to progress and unlock new abilities or features.
 */
	
	public static int xp;
	/**
		 *This field represents the amount of experience points accumulated by the player.
         * Experience points are a measure of the player's progress and skill level within the game.
         * Higher XP values indicate more advanced gameplay and achievements.
	 */
	public static int level = 1;
	/**
          * The current level of the player.
 		  * This field represents the current level of the player character.
          * The initial value is set to 1, indicating the starting level.
          * As the player gains experience points (XP), they can level up and increase their level.
	 */
    public static final int MAX_LEVEL = 100;
	/**
        * The maximum level attainable.
 		* This field represents the maximum level that a player can reach.
	 	* The value of this field is set to 100, indicating the highest achievable level in the game.
 		* Once a player reaches this level, they have reached the pinnacle of progression and have unlocked all available features or abilities.
 		* This field is marked as 'final' to indicate that its value cannot be modified.
	 */
	public static int battleXp;
	/**
		 * The experience points (XP) gained in a battle.
		 * This field represents the amount of experience points gained by the player in a battle.
         * It is used to track the XP earned specifically from combat encounters.
         * The value of this field is incremented or updated after each battle, reflecting the XP gained.
         * These battle XP contribute to the player's overall progress and can help them level up.
	*/
	public static int updatedHP = Characters.health;
	
	/**
         * The updated health points (HP) of a character.
 		 * This field represents the current health points of a character after an update.
 		 * The value of this field is set to the value of the 'health' field of the Characters class,
 		 * which represents the maximum health points of the character.
 		 * This field is used to store the current HP value after any changes or updates to the character's health.
		 * It ensures that the HP value remains synchronized and up-to-date for further calculations or display purposes.
	 */
	
	public static void levelUp() {
		xp = xp + Battle.xpDropped;
		battleXp = xp;
		
		/**
         * When the player have been leveled up.
	 */
		if (battleXp >= 200) {
			
			Effects.yellowText(Effects.ANSI_BOLD+"You've leveled up! You are now level " + (level + 1) + "!\nYou have been rewarded 100 coins! Level Up!");
			xp = 0;
			xpNeeded += 500;
			level++;
			Battle.PHealth += 50;
			updatedHP += 50;
			Battle.enemyAttackDmg += 10;
			
			
			Main.shop.setPlayerCoins(100);
			
			if (level == 9) {
	          System.out.println("You've leveled up! You are now level" + (level + 1) + "\nYou have been rewarded 250 coins! Level Up!");
	            level = 10;
	            Main.shop.setPlayerCoins(250);;

			}else if(level > MAX_LEVEL){
				System.out.println("You're cheating.");
	            level = 100;
			}else if(level == 99){
	            level = 100;
	            xp = 49000;
			}
				
		}
		
	}

}
