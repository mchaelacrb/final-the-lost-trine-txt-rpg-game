package Main;

import java.util.Random;
import java.util.Scanner;

/**
 * The Battle class class represents the battle system in a game. 
 * It contains various methods and variables related to battles between the player and enemies.
 */
public class Battle {

    /**
     * The number of experience dropped...
     */
    public static int xpDropped;
    static Scanner scan = new Scanner(System.in);
    static Random rd = new Random();

    //Game Variables
    static int maxEnemyHealth = 75;
    /**
        *The Maximum health of the enemy.
    */
    static int enemyAttackDmg = 40;
    /**
        *The Amount of damage the enemy can inflict.
    */
    static int numEnemy = 10;
    /**
        * Number of enemies in the game
    */
    static String enemyPlace;
    /**
        * Represents the location where the enemy is encountered
    */

    //Player variable
    static int PHealth;
    static int PAttackDmg;
    static int PDefense;
    static int numHealthPotion = 3;
    static int healthPotionHealAmnt = 40;
    static int healthPotionDropChance = 50; //percentage

    //gems
    static int gem1 = 0;
    static int gem2 = 0;
    static int gem3 = 0;


    /**
     * This method is for the battle system.
     */
    public static void battleSystem() {

        boolean game = true;

        System.out.println(Effects.ANSI_BOLD + "\n\n\t**While finding the gem, a bunch of " + enemyPlace
                + " has appeared!**" + Effects.ANSI_RESET);

        BATTLE:
        while (game) {
            try {
                Effects.printLines(100);
                int enemyHealth = rd.nextInt(maxEnemyHealth) + 1;
                Effects.printLines(100);

                while (numEnemy > 0) {
                    //try {
                    Effects.printLines(100);
                    System.out.println("\nThere are " + numEnemy + "/10 " + enemyPlace + " enemies.");

                    while (enemyHealth > 0) {
                        //try {
                        if (PHealth >= 50) {
                            System.out.println("\nYour HP: " + Effects.ANSI_GREEN + "" + PHealth + "" + Effects.ANSI_RESET);
                        } else {
                            System.out.println("\nYour HP: " + Effects.ANSI_RED + "" + PHealth + "" + Effects.ANSI_RESET);
                        }
                        System.out.println(enemyPlace + "'s HP: " + enemyHealth);

                        System.out.println("\nwhat do you want to do next?");
                        System.out.print("\n1:[FIGHT]"
                                + "\n2:[DRINK POTION] "
                                + "\n3:[RUN]\n\n> ");

                        String input = scan.nextLine();

                        if (input.equalsIgnoreCase("1")) {
                            int damageDealt = rd.nextInt(PAttackDmg);
                            int defenseOn = rd.nextInt(PDefense);
                            int damageTaken = rd.nextInt(enemyAttackDmg) + 1 - defenseOn;

                            enemyHealth -= damageDealt;

                            if (damageTaken <= 0) {
                                damageTaken = 0;
                                PHealth -= damageTaken;
                            } else {
                                PHealth -= damageTaken;

                            }
                            Effects.printLines(100);

                            if (PHealth < 1) {
                                Effects.redText("You have taken too much damage,"
                                        + " you are too weak... You need to level up!" + Effects.ANSI_RESET);

                                PHealth = Xp.updatedHP;

                                outside();
                                break BATTLE;
                            } else if (damageDealt <= 0) {
                                System.out.println("You missed to hit the target!");
                                System.out.println("Yet, you receive " + damageTaken + "damage!");

                            } else if (damageTaken <= 0) {
                                System.out.println("That didn't hit you, nice dodge!");
                                System.out.println("Haha, you still hit the " + enemyPlace + " for " + damageDealt
                                        + " damage.");
                            } else {
                                System.out.println("\nYou hit the " + enemyPlace + " for " + damageDealt
                                        + " damage.");
                                System.out.println("You receive " + damageTaken + " in counterattack!\n");
                            }

                        } else if (input.equalsIgnoreCase("2")) {
                            if (numHealthPotion > 0) {

                                if (PHealth >= Xp.updatedHP) {
                                    Effects.printLines(100);
                                    System.out.println("Your Health is full, you can't heal yourself anymore.");
                                    Effects.printLines(100);
                                } else {
                                    PHealth += healthPotionHealAmnt;
                                    numHealthPotion--;
                                    if (PHealth >= Xp.updatedHP) {
                                        PHealth = Xp.updatedHP;
                                    }
                                    Effects.delayPrint(0, "\nYou drink a health potion, healing yourself for "
                                            + healthPotionHealAmnt + "!");
                                    Effects.delayPrint(0, "\nYou now have " + PHealth + ".");
                                    Effects.delayPrint(0, "\nYou have " + numHealthPotion + " health left in your inventory.");

                                    Effects.printLines(100);
                                }

                            } else {
                                System.out.println("You have no health potion left! Deafeat enemies for a chance to get a potion!");
                            }

                        } else if (input.equalsIgnoreCase("3")) {
                            System.out.println("You run away from the " + enemyPlace + ".");
                            int runEncounterChance = rd.nextInt(100);
                            if (runEncounterChance >= 65) {
                                System.out.println("You got out of the battle field.");
                                outside();
                                break;
                            } else {
                                System.out.println("Unfortunately, you encounter a bunch of " + enemyPlace
                                        + " again!");
                                continue BATTLE;
                            }

                        } else if (input.equalsIgnoreCase("menu")) {
                            Menu.menuButtons();
                            continue BATTLE;

                        } else {
                            System.out.println("Invalid input!");
                            Effects.printLines(100);
                        }

                    }//WHILE ENEMY LOOP

                    if (PHealth < 0) {
                        System.out.println("\nYou died in the battle.");
                        outside();

                    } else if (enemyHealth < 0) {
                        Effects.printLines(100);
                        System.out.println("**You have defeated the " + enemyPlace + "!**");
                        System.out.println("You now have " + PHealth + " HP left.");
                    }

                    xpDropped = rd.nextInt(Xp.xpDrop) + 20;
                    System.out.println("You've got " + xpDropped + " Xp.");
                    Xp.levelUp();
                    int r = Xp.xpNeeded - Xp.xp;
                    System.out.println("You need " + r + "XP to level up.");

                    int maxCoinsDrop = 50;
                    int droppedCoins = rd.nextInt(maxCoinsDrop) + 10;
                    Main.shop.setPlayerCoins(droppedCoins);
                    System.out.println("+" + droppedCoins + " dropped coins. You now have " + Main.shop.getPlayerCoins() + " coins");

                    if (rd.nextInt(100) < healthPotionDropChance) {
                        numHealthPotion++;
                        System.out.println("\n**The " + enemyPlace + " dropped a health potion!**");
                        System.out.println("You now have " + numHealthPotion + " health potion(s).");
                    }

                    numEnemy--;
                    continue BATTLE;

                }

                break;
            } catch (Exception e) {
                System.out.println("There is something wrong.");
                continue BATTLE;
            }
        }
            Effects.yellowText("You've killed all of them, congratulation!" + Effects.ANSI_RESET);
            Effects.printLines(40);
    }

    /**
     * This method is used after finishing a quest.
     */
    
    public static void nextThingToDo() {
        System.out.println("\nWhat would you like to do now?");
        System.out.print("\n1:[Continue] \n2:[Exit forest]\n> ");

        String input = scan.nextLine();

        while (!input.equalsIgnoreCase("1") && !input.equalsIgnoreCase("2")) {
            System.out.println("Invalid Input!");
            Effects.printLines(100);
            input = scan.nextLine();
        }

        if (input.equalsIgnoreCase("1")) {
            if (gem1 == 1){
                Story.story.questTwo();
            } else if(gem2 == 1){
                Story.story.questThree();

            } else if (gem3 == 1){
            	Effects.yellowText("You have finished all of the quest! You must await for the next one!");
                Effects.printLines(40);
                Story.story.ending();
        }
            

        } else if (input.equalsIgnoreCase("2")) {
            System.out.println("\nYou got out of the forest alive. Congrats!");
            Menu.menuButtons();

        }
    }

    /**
     * This method is used when the player tried to run away on the battle field.
     */
    
    public static void outside() {
        Effects.printLines(100);
        System.out.println("\nYou are now safe here, what do you want to do now?\n");
        Menu.menuButtons();
    }

    /**
     * The quest in the forest will start here.
     */
    
    public static void battleInForest() {
       enemyPlace = Enemies.GHOST.toString();
               
        OPEN:
        while(true){
        	try {
        if (gem1 == 0) {

            battleSystem();
            
            CHESS:
            while (true) {
            	System.out.println("For your triumph, here's a chest full of your reward");
            	System.out.println("");
            	System.out.print("Would you like to open the chest?\nType \"y\" to open.\n> ");
            	String input = scan.nextLine();
                if (input.equalsIgnoreCase("y")) {
                    System.out.println("A radiant gem beaming with ethereal brilliance, its shimmering glow captivating all who behold its mesmerizing luminescence.");
                    if (Characters.selectedHero == "Archer") {
                        System.out.println("Together with a Barrel and a gun powder.");
                        System.out.print("Type \"y\" to take these rewards.\n> ");
                        String input2 = scan.nextLine();
                        if (input2.equalsIgnoreCase("y")) {
                            Inventory.addItem("Gem1", 1);
                            Inventory.addItem("Barrel", 1);
                            Inventory.addItem("Gun powder", 1);
                            gem1 = 1;
                            Effects.printLines(100);
                            nextThingToDo();
                            break;
                        } else {
                        	Effects.printLines(100);
                			Effects.redText("Invalid Input.");
                            continue CHESS;
                        }

                    } else if (Characters.selectedHero == "Warrior") {
                        System.out.println("Together with a steel and a Blank");
                        System.out.println("Type \"y\" to take these rewards\n> ");
                        String input2 = scan.nextLine();
                        if (input2.equalsIgnoreCase("y")) {
                            Inventory.addItem("Gem1", 1);
                            Inventory.addItem("Steel", 1);
                            Inventory.addItem("Blank", 1);
                            gem1 = 1;
                            Effects.printLines(100);
                            nextThingToDo();

                            break;

                        } else {
                        	Effects.printLines(100);
                			Effects.redText("Invalid Input.");
                            continue CHESS;
                        }
                    }

                } else {
                	Effects.printLines(100);
        			Effects.redText("Invalid Input.");
                    continue CHESS;
                }

            }

        } else if (gem1 == 1) {
            numEnemy = 10;
            battleSystem();
        }
        } catch (Exception e) {
        	Effects.printLines(100);
			Effects.redText("Invalid Input.");
			continue OPEN;
        }
      } 
}
    
    /**
     * The quest in the temple will start here.
     */
    
    public static void battleInTemple() {
        enemyPlace = Enemies.WITCH.toString();
        Effects.printLines(100);
        System.out.println("********** Note: In this map once you got out, the number of enemy will be reset to 10. "
                + "You must make a wise decisions! ***********");

               
        if (gem3== 0) {
			numEnemy = 10;
			battleSystem();
			
			OPEN:
				while (true) {
				try {
					System.out.println("For your triumph, here's a chest full of your reward");
					System.out.println("");
					System.out.print("Would you like to open the chest?\nType \"y\" to open.\n> ");
					String input = scan.nextLine();

					CHESS: while (true) {
						if (input.equalsIgnoreCase("y")) {

							System.out.println(
									"A radiant gem beaming with ethereal brilliance, its shimmering glow captivating all who behold its mesmerizing luminescence.");
							if (Characters.selectedHero == "Archer") {
								System.out.println("Together with a trigger.");
								System.out.print("Type \"y\" to take these rewards.\n> ");
								String input2 = scan.nextLine();
								if (input2.equalsIgnoreCase("y")) {
									Inventory.addItem("Gem3", 1);
									Inventory.addItem("Trigger", 1);
									gem3 = 1;
									Effects.printLines(100);
									nextThingToDo();
									break;
								} else {
									Effects.printLines(100);
									Effects.redText("Invalid Input.");
									continue CHESS;
								}

							} else if (Characters.selectedHero == "Warrior") {
								System.out.println("Together with a half.");
								System.out.print("Type \"y\" to take these rewards.\n> ");
								String input2 = scan.nextLine();
								if (input2.equalsIgnoreCase("y")) {
									Inventory.addItem("Gem3", 1);
									Inventory.addItem("Half", 1);
									gem3 = 1;
									Effects.printLines(100);
									nextThingToDo();
									break;
								} else {
									Effects.printLines(100);
									Effects.redText("Invalid Input.");
									continue CHESS;
								}
							}
							
						} else {
							Effects.printLines(100);
							Effects.redText("Invalid Input.");
							continue OPEN;
						}
					}

				} catch (Exception e) {
					Effects.printLines(100);
					Effects.redText("Invalid Input.");
					continue OPEN;
				}
			}

		} else if (gem3 == 1) {
			numEnemy = 10;
			battleSystem();
			
		}
    }

    /**
     * The quest in the cave will start here.
     */
	public static void battleInCave() {
		enemyPlace = Enemies.GOBLIN.toString();
		Effects.printLines(100);
		System.out.println("********** Note: In this map once you got out, the number of enemy will be reset to 10. "
				+ "You must make a wise decisions! ***********");

		if (gem2 == 0) {

			numEnemy = 10;
			battleSystem();
			OPEN: while (true) {
				try {
					System.out.println("For your triumph, here's a chest full of your reward");
					System.out.println("");
					System.out.print("Would you like to open the chest?\nType \"y\" to open.\n> ");
					String input = scan.nextLine();

					CHESS: while (true) {
						if (input.equalsIgnoreCase("y")) {

							System.out.println(
									"A radiant gem beaming with ethereal brilliance, its shimmering glow captivating all who behold its mesmerizing luminescence.");
							if (Characters.selectedHero == "Archer") {
								System.out.println("Together with a magazine.");
								System.out.print("Type \"y\" to take these rewards.\n> ");
								String input2 = scan.nextLine();
								if (input2.equalsIgnoreCase("y")) {
									Inventory.addItem("Gem2", 1);
									Inventory.addItem("Magazine", 1);
									gem2 = 1;
									Effects.printLines(100);
									nextThingToDo();
									break;
								} else {
									Effects.printLines(100);
									Effects.redText("Invalid Input.4");
									continue CHESS;
								}

							} else if (Characters.selectedHero == "Warrior") {
								System.out.println("Together with a steel and a woodhandle");
								System.out.print("Type \"y\" to take these rewards.\n> ");
								String input2 = scan.nextLine();
								if (input2.equalsIgnoreCase("y")) {
									Inventory.addItem("Gem2", 1);
									Inventory.addItem("Steel", 1);
									Inventory.addItem("woodhandle", 1);
									gem2 = 1;
									Effects.printLines(100);
									nextThingToDo();
									break;
								} else {
									Effects.printLines(100);
									Effects.redText("Invalid Input.");
									continue CHESS;
								}
							} 

						} else {
							Effects.printLines(100);
							Effects.redText("Invalid Input.");
							continue OPEN;
						}
					}

				} catch (Exception e) {
					Effects.printLines(100);
					Effects.redText("Invalid Input.");
					continue OPEN;
				}
			}

		} else if (gem2 == 1) {
			numEnemy = 10;
			battleSystem();
		}

	}
    

}
