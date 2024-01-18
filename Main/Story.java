package Main;

import java.util.Scanner;

/**
 * Where the adventure of the player begins. 
 */

public class Story {

    Scanner in = new Scanner(System.in);
    public String nextPosition;
    static Story story = new Story();

    /**
     * Where the kingdom is located.
     */
    
    public void defaultPlace() {

        Effects.cyanText("\n\nKing: ");
        System.out.print("Ah, brave adventurer, I commend your courage for undertaking this perilous quest"
                + "\n\tThe gem we seek is a sacred artifact, rumored to possess immense power."
                + "\n\tThe forest is known to be inhabited by various dark creatures and hidden traps."
                + "\n\tMy advice to you is to tread carefully and remain vigilant at all times."
                + "\n\tThe gem must be retrieved at any cost, for it is crucial to our kingdom's well-being.");
        Effects.cyanText("\n\nKing: ");
        System.out.print("One final piece of information, adventurer."
                + "\n\tThere have been reports of an ancient guardian spirit,"
                + "\n\tbenevolent entity said to inhabit the depths of the forest.\n\n");
        Effects.purpleText(Characters.player.getName()+ ": ");
        System.out.println("Thank you, Your Majesty, for entrusting me with this vital mission."
                + "\n\tI shall return with the gem or not at all. The fate of our kingdom rests upon my success.");

        System.out.println("\nYou're tasked to go to forest, Where do you want next?\n");
        nextPosition();

    }
    
    /**
     * Dialogue for quest number two.
     */

    public void questTwo() {
        Effects.cyanText("\n\nKing: ");
        System.out.println("There is another gem, adventurer, hidden deep within the caverns beyond the forest."
                + "\n\tLegends speak of a cave inhabited by the very entities that hide and guard these precious stones.");
        Effects.cyanText("\n\nKing: ");
        System.out.println("May fortune favor your steps once more, brave adventurer."
                + "\n\tThe fate of our realm rests on your shoulders. "
                + "\n\tReturn to us with the second gem and know that our gratitude and rewards shall know no bounds.");
        nextPosition();
    }
    
    /**
     * Dialogue for quest number three.
     */

    public void questThree() {
        Effects.cyanText("\n\nKing: ");
        System.out.println("Ah, brave adventurer, welcome back! I heard the news of your triumph. Congratulations on acquiring the precious gem."
        		+ "\n\tYou have proven yourself worthy of the title bestowed upon you.\n\n");
        Effects.purpleText(Characters.player.getName()+ ": ");
        System.out.println("Thank you, Your Majesty. It was indeed a perilous journey, but with determination and a bit of luck, I managed to retrieve the gem from the treacherous cavernss");
        Effects.cyanText("\n\nKing: ");
        System.out.println("Your courage and skill are unmatched, my loyal adventurer. The kingdom owes you a debt of gratitude."
        		+ "\n\tThis gem holds great significance for our people, and it shall be safely displayed in the royal treasury. However, another task awaits you."
        		+ "\n\tDeep within the ancient temple lies another gem of immense power  I ask that you embark on a new quest, venture into the depths of the temple, and retrieve this precious artifact."
        		+ "\n\tFarewell, brave adventurer. Return to us safely, and may your journey be filled with both courage and fortune.");
        nextPosition();
    }
    
    /**
     * Dialogue and story for the ending part of the game.
     */
    
    public void ending() {
    	System.out.println("The adventurer's footsteps echoed through the grand halls of the castle as they made their way towards the throne room."
    			+ "\nThe air was thick with anticipation, and the flickering torches cast dancing shadows on the stone walls."
    			+ "\nAs they approached, the doors swung open, revealing the weary yet determined king sitting upon his throne.");
    	
    	Effects.printLines(100);
    	Effects.yellowText(Effects.ANSI_BOLD+ "CONGRATULATION! YOU HAVE ACCOMPLISH FINDING ALL THE GEMS!");
    	Effects.printLines(100);
    	
        Effects.cyanText("\n\nKing: ");
        System.out.println("Welcome, brave adventurer. You have returned victorious, and for that, I am eternally grateful.\n\n");
        Effects.purpleText(Characters.player.getName()+ ": ");
        System.out.println("Thank you, Your Majesty. It was an honor to serve and protect the kingdom.");
        
        Effects.cyanText("\n\nKing: ");
        System.out.println("But my dear "+Characters.player.getName()+", there is something of great importance I must share with you."
        		+ "\n\tThere is something big coming, with the power of the four gems combing, out of my knowledge that it will awaken"
        		+ "\n\the realm of darkness where every evil things live on. I believe we have to be ready for our next journey my brave, "
        		+Characters.player.getName());
        
    	Effects.printLines(100);
    	System.out.println("ABCMN Production © 2023");
    	Effects.printLines(100);
    	
    	end:
    	while(true) {
    		try {
    	System.out.print("\n\n\nDo you want to enter a new game? Enter y for YES and n for NO\n> ");
    	System.out.println("Note: if you enter n, the game will end.");
    	
    	String input = in.nextLine();
    	if (input.equalsIgnoreCase("y")) {
    		Effects.clearConsole();
    		Effects.delayPrint(30, "Entering new game...................");
    		Effects.printLines(100);
    		Narration.startingLine();
    		
		} else if (input.equalsIgnoreCase("n")) {
    		Effects.delayPrint(30, "Exiting..............................");
			System. exit(0);
			
		} else {
			Effects.redText("Invalid Input.");
    		Effects.printLines(100);
    		continue end;
			
		}
    	}catch (Exception e) {
			Effects.redText("Invalid Input.");
    		Effects.printLines(100);
    		continue end;

    	}
    	}
    	
    }
    
    /**
     * Story inside the forest.
     */
    
    public void forest() {
        if (Xp.level >= 1) {

            System.out.println("You're currently infront of the forest, Do you want to explore?");
            System.out.print(" y : YES" + "\n n : NO\n>");
            String exploreOrnah = in.nextLine();
            if (exploreOrnah.equalsIgnoreCase("y")) {
                System.out.println("Venturing deeper into the forest, cautiously moving through the dense foliage, and keeping a keen eye out for any signs of the gem."
                		+ "\nThis forest is indeed treacherous, but I must press on. The Guardian Oak and the enchanted river should be nearby.");
                System.out.println("As the adventurer continues, a rustling sound echoes through the trees, catching their attention."
                		+ "\nSuddenly, a towering creature with gnarled limbs and glowing red eyes emerges from the shadows.");
                System.out.println("Monster: growling menacingly, its sharp claws scraping against the ground Who dares intrude upon my domain? You shall not leave this forest alive!");
                Battle.battleInForest();

            } else if (exploreOrnah.equalsIgnoreCase("n")) {
                defaultPlace();

            } else {
                System.out.println("The Forest Shadow: A realm of darkness where ancient trees reach for the sky, enveloped in mist and inhabited eerie entities.");
                nextPosition();
            }
        }
    }
    
    /**
     * Story inside the cave.
     */

    public void cave() {

        if (Xp.level >= 5) {

            System.out.println("");
            System.out.println("You're currently at the front of the cave, Do you want to explore?");
            System.out.println(" y : YES" + "\n n : NO");
            String exploreOrnah = in.nextLine();
            if (exploreOrnah.equalsIgnoreCase("y")) {
                System.out.println("As the adventurer ventures deeper into the cave, the path becomes winding and treacherous. "
                        + "\nThe sharp stalagmites and slippery rocks pose constant obstacles, requiring them to tread cautiously to avoid injury. "
                        + "\nStrange shadows dance and flicker on the cave walls, creating an unsettling atmosphere.");
                System.out.println("Suddenly, a low, haunting growl reverberates through the cave, causing the adventurer to halt in their tracks. "
                        + "\nA pair of glowing red eyes emerge from the darkness, followed by the silhouette of a grotesque creature.");
                System.out.println("Entity: emitting an otherworldly hiss Intruder! "
                        + "\nYou dare disturb the sacred realm of the Cave of Shadows? "
                        + "\nPrepare to face the consequences!");
                Battle.battleInCave();

            } else if (exploreOrnah.equalsIgnoreCase("n")) {
                defaultPlace();

            }
        } else {
            Effects.printLines(100);
            System.out.println("\nYou must be level 5 with high attack damage in order to come here.");
            System.out.println("The Whispering Abyss: A haunting cave veiled in darknes, where mysterious whispers drift through winding tunnels.\n");
            nextPosition();
        }
    }

    /**
     * Story inside the temple.
     */
    
    public void temple() {
        if (Xp.level >= 10) {
            System.out.println("The adventurer makes their way to the Temple of Serenity, a place rumored to hold ancient secrets and guarded by mystical entities."
            		+ "\nAs they step through the temple's grand entrance, a hushed silence falls upon the surroundings.");
            System.out.println("The air grows heavy with an aura of anticipation as the adventurer cautiously explores the temple's corridors."
            		+ "\nSuddenly, a low rumble echoes through the hall, and a group of ethereal beings materializes before them, their eyes glowing with otherworldly energy.");
            System.out.println("Witch: Intruder! You dare disturb the sacred sanctum of the Temple of Serenity? Prepare to face the consequences of your audacity!");
            System.out.println("What do you want to do next?");
            Battle.battleInTemple();

        } else {
            Effects.printLines(100);
            System.out.println("\nYou must be level 10 with high attack damage in order to come here.");
            System.out.println("The Haunted Sorcerer's Temple: An eerie sanctuary gripped by shadows, where wicked sorcerers practice forbidden arts, enveloping the surroundings in an unsettling atmosphere of fear and mystery.\n");
            nextPosition();
        }

    }
    
    /**
     * What the player sees on the map.
     */

    public void nextPosition() {
        Effects.printLines(100);
        System.out.println("Where do you want to go?");
        System.out.println("\n\tn : GO TEMPLE");
        System.out.println("\tw : GO CAVE");
        System.out.println("\ts : GO FOREST ");
        System.out.println("\te : GO EAST\n ");

        Effects.printLines(100);
        System.out.print("type the letter:\n> ");

        String nextPosition = in.nextLine();

        try {
            if (nextPosition.equalsIgnoreCase("n")) {
                temple();

            } else if (nextPosition.equalsIgnoreCase("w")) {
                cave();

            } else if (nextPosition.equalsIgnoreCase("s")) {
                forest();

            } else if (nextPosition.equalsIgnoreCase("e")) {
                defaultPlace();

            } else if (nextPosition.equalsIgnoreCase("menu")) {
                Menu.menuButtons();

            } else {
            	Effects.redText("Invalid Input.");
                nextPosition();
            }
        } catch (Exception e) {
        	Effects.redText("Invalid Input.");

        }
    }
}
