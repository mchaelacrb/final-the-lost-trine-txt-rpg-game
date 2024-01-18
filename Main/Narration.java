package Main;

import java.util.Scanner;
/**
    * The Narration class handles the introductory storyline and game setup.
 */
public class Narration {
	static Scanner in = new Scanner(System.in);
	
        /**
         * Backstory of the game.
         */
        
        public static void startingLine() {
            Effects.printLines(100);
            
            System.out.println("[An old sorcerer sits in a dimly lit room, a gem glowing in \r\n"
            		+ "his hands. An ordinary guy enters, curious and slightly nervous.]\n");
            System.out.println(Effects.ANSI_CYAN +"Sorcerer: "+Effects.ANSI_RESET +"Ah, you've come. Take a seat, my friend. I \r\n"
            		+ "\thave something important to entrust to you.\n");
            Effects.purpleText("Guy: ");
            System.out.println("What is it wise sorcerer?\n");
            System.out.println(Effects.ANSI_CYAN +"Sorcerer:"+Effects.ANSI_RESET +" This gem holds immense power, and\r\n"
            		+ "\tit must be protected at all costs. It's only one piece of \r\n"
            		+ "\ta larger set. You must find the rest of the gems, or countless\r\n"
            		+ "\tlives will be in peril.\n");
            Effects.purpleText("Guy: ");
            System.out.println("Me? But I'm just an ordinary person. How can I accomplish such a task?\n");
            System.out.println(Effects.ANSI_CYAN +"Sorcerer:"+Effects.ANSI_RESET +" Destiny has chosen you, my friend."
            		+ "\n\tTrust in your heart, and the path will unfold before you. Take this gem and guard it with your life."
            		+ "\n\tSeek the others, for their union is crucial for the world's safety.");
            
            
            System.out.println("\n\n[The ordinary guy, now a king, stands before a grand audience in the magnificent hall of his castle.]");
            
           
            Effects.delayPrint(0, "\nOne day, the king summoned a brave and skilled adventurer to his court.\n"
                            + "The king entrusted the adventurer with a very important mission: to find and retrieve the 3 precious"
                            + "\ngems that were scattered in different places throughout the kingdom.");
            Effects.delayPrint(0, "\n\nThe four gems were known to be powerful talismans that had the \npower to protect the kingdom from the bad entities.");
            Effects.delayPrint(0, "The king is looking someone who is brave enough to take the challenge \nto bring back the peace in the kingdom.\r\n");
            Effects.clearConsole();
            
            start:
            while(true) {
            Effects.printLines(100);
            System.out.println(Effects.ANSI_BOLD + Effects.ANSI_RED + "Are you willing to accept the challenge?" + Effects.ANSI_RESET);
            Effects.printLines(100);
            System.out.print("Enter \"START\"!\n> ");
            

            
            try {
            
            String input = in.nextLine();
            if(input.equalsIgnoreCase("start")) {
            	Effects.delayPrint(20, "The game is starting.......\n");
            	Characters.characterCreation();
            	break;
            	
            } else {
            	Effects.redText("Invalid Input.");
            	continue start;
            }
            
            } catch (Exception e) {
            	Effects.redText("Invalid Input. You need to enter the word \"START\".");
            	continue start;
            }
            
            
            }


            }

}

