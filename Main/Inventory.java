package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * The Inventory class is responsible for managing the player's inventory.
 * It provides methods for adding and removing items, displaying the inventory,
 * and handling user interaction.
*/
public class Inventory {
    
    /**
     * Array list to store the items added in the inventory.
     */
    
    public static Map<String, Integer> items = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    /**
     * To add an item to the inventory
     * @param item The name of the item.
     * @param pcs The quantity of the item.
     */
    
    public static void addItem(String item, int pcs) {
        items.put(item, pcs);
        System.out.println(item + " added to the inventory.");
    }
    
    public static void removeItem(String item) {
        items.remove(item);
    }
    
    /**
     * This method is made to display the items in the inventory.
     */
    
    public static void displayItems() {
        //System.out.println("Inventory Items:");
        System.out.println("Potion: " + Battle.numHealthPotion);
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("  \t"  + entry.getKey() + ": " +entry.getValue() + "");
        }
    }
    
    /**
     * This is what the player sees in the inventory.
     */

    public static void inventory(){        
        
        while (true) {
            try {
            System.out.print(Effects.ANSI_BLUE+"\n\tINVENTORY"+Effects.ANSI_RESET
            		+ "\n\t0 - Back"
            		+ "\n\t");
            		displayItems();
            System.out.print("\n> ");

            int option = scanner.nextInt();scanner.nextLine();
            
            switch (option) {
                case 0:
                    System.out.println("");
                    Effects.printLines(option);
                    Menu.menuButtons();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    inventory();
            	}
            } catch (Exception e){
        	System.out.println("Invalid input.");
        	Effects.printLines(50);
                scanner.nextLine();
        	inventory();
        	}
                	
        }
    }
}