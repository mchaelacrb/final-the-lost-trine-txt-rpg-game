package Main;

import java.util.Scanner;
/**
         * This will serves as the settings of the game.

	 */
public class Menu {

    Inventory inventory = new Inventory();
    static Scanner in = new Scanner(System.in);

    /**
     * This method is to call the map.
     */
    public static void map() {
        System.out.println("THE MAP");
        Story.story.nextPosition();
    }

    /**
     * What the player see when they go to the menu.
     */
    public static void menuButtons() {
        System.out.println("MENU");
        System.out.println("1 : MAP");
        System.out.println("2 : INVENTORY");
        System.out.println("3 : SHOP");
        System.out.println("4 : PROFILE");

        try {
            System.out.print("\n> ");
            int input = in.nextInt();
            in.nextLine();

            switch (input) {

                case 1:
                    map();

                case 2:
                    Inventory.inventory();

                case 3:
                    Shop.buyShop();

                case 4:
                    Player.playerProfile();
                default:
                    System.out.println("Invalid Input");
                    in.nextLine();
                    menuButtons();
            }
        } catch (Exception e) {
            System.out.println("Invalid Input.");
            in.nextLine();
            menuButtons();
        }

    }

}
