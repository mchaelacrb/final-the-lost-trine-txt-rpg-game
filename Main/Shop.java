package Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * It states that the shop is used to buy items for the player, including weapons.
*/
public class Shop {

    /**
     * Array list to store the items that can be bought in the shop.
     */
    
    public static Map<String, Integer> items = new HashMap<>();
    
    /**
     * Array list to store the items that can be upgraded in the shop.
     */
    
    public static Map<String, Integer> weaponUpgrades = new HashMap<>();
    static final int DEFAULT_COINS = 500;
    private static int playerCoins = DEFAULT_COINS;
    static Scanner scanner = new Scanner(System.in);
    static int pcs;

    /**
     * This is to add an item to the shop.
     *
     * @param item is used to store the item in the array items.
     * @param price is used to add a value in the item.
     */
    public static void addItem(String item, int price) {
        items.put(item, price);
    }

    /**
     * This is to add what weapon the player can upgrade to the shop..
     *
     * @param weapon to be upgraded
     * @param upgradeCost how much it will cost
     */
    public static void addWeaponUpgrade(String weapon, int upgradeCost) {
        weaponUpgrades.put(weapon, upgradeCost);
    }

    /**
     * This is to remove an item to the shop.
     *
     * @param item the item to be removed
     */
    public static void removeItem(String item) {
        weaponUpgrades.remove(item);
    }

    /**
     * This method is made to display the items in the shop.
     */
    public static void displayItems() {
        System.out.println("Shop Items:");
        System.out.println("   Potion - 15 coins");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("   " + entry.getKey() + " - " + entry.getValue() + " coins");
        }
    }

    /**
     * This method is made to display what weapon can be upgraded in the shop.
     */
    public static void displayWeaponUpgrades() {
        System.out.println("Weapon Upgrades:");
        for (Map.Entry<String, Integer> entry : weaponUpgrades.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " coins");
        }
    }

    /**
     * This method is made for the player to buy an item in the game.
     */
    public static void buyItem(String item) {

        if (items.containsKey(item)) {
            int price = items.get(item);
            if (playerCoins >= price) {

                System.out.print("\nHow many?\n> ");
                pcs = scanner.nextInt();

                int x = price * pcs;

                if (item.equalsIgnoreCase("armor")) {
                    if (x <= playerCoins) {
                        playerCoins -= x;
                        Battle.PDefense += 10;
                        System.out.println("You bought " + pcs + " of " + item + " for " + x + " coins.");
                        Effects.printLines(50);

                    } else {
                        System.out.println("Insufficient coins to buy an armor.");
                        Effects.printLines(50);
                    }
                }
                Effects.printLines(50);
            } else {
                System.out.println("Insufficient coins to buy " + item + ".");
                Effects.printLines(50);
            }
        } else if (item.equalsIgnoreCase("potion")) {
            if (playerCoins >= 15) {

                System.out.print("How many?\n> ");
                pcs = scanner.nextInt();

                int x = 15 * pcs;
                if (x <= playerCoins) {
                    playerCoins -= x;
                    Battle.numHealthPotion += pcs;
                    System.out.println("You bought " + pcs + " of potion for " + x + " coins.");
                    Effects.printLines(50);
                    Inventory.addItem(item, pcs);
                } else {
                    System.out.println("Insufficient coins to buy a potion.");
                    Effects.printLines(50);
                }

            } else {
                System.out.println("Insufficient coins to buy a potion.");
                Effects.printLines(50);
            }
        } else {
            System.out.println(item + " is not available in the shop.");
            Effects.printLines(50);
        }
    }

    /**
     * This method is for the player to upgrade a weapon in the shop
     */
    public static void upgradeWeapon(String weapon) {
        if (weaponUpgrades.containsKey(weapon)) {
            int upgradeCost = weaponUpgrades.get(weapon);
            if (playerCoins >= upgradeCost) {

                if (weapon.equalsIgnoreCase(Characters.weapon2)) {
                    if (Characters.selectedHero == "Archer") {
                        if (Inventory.items.containsKey("Barrel") && Inventory.items.containsKey("Magazine")
                                && Inventory.items.containsKey("Trigger")) {

                            Battle.PAttackDmg += 100;
                            playerCoins -= upgradeCost;
                            System.out.println("You used a barrel, Magazine, and a trigger for the upgrade.");
                            System.out.println("+100 Attact Damage!");
                            Inventory.removeItem("Barrel");
                            Inventory.removeItem("Gun powder");
                            Inventory.removeItem("Magazine");
                            Inventory.removeItem("Gun powder");

                        } else {
                            Effects.printLines(100);
                            System.out.println("Insufficient materials to upgrade. You can get it by finishing a quest!");
                        }

                    } else if (Characters.selectedHero == "Warrior") {
                        if (Inventory.items.containsKey("Steel") && Inventory.items.containsKey("Blank")
                                && Inventory.items.containsKey("Half")) {

                            Battle.PAttackDmg += 100;
                            playerCoins -= upgradeCost;
                            System.out.println("You used a steel, woodhandle, and a half for the upgrade.");
                            System.out.println("+100 Attact Damage!");
                            Inventory.removeItem("Steel");
                            Inventory.removeItem("Half");
                            Inventory.removeItem("woodhandle");
                            Inventory.removeItem("Blank");

                        } else {
                            Effects.printLines(100);
                            System.out.println("Insufficient materials to upgrade. You can get it by finishing a quest!");
                        }

                    }

                } else if (weapon.equalsIgnoreCase(Characters.weapon)) {
                    playerCoins -= upgradeCost;
                    Battle.PAttackDmg += 10;
                    System.out.println("You upgraded your " + weapon + " for " + upgradeCost + " coins.");
                }

                Effects.printLines(50);
            } else {
                System.out.println("Insufficient coins to upgrade " + weapon + ".");
                Effects.printLines(50);
            }
        } else {
            System.out.println("Upgrades for " + weapon + " are not available in the shop.");
            Effects.printLines(50);
        }
    }

    /**
     * To set the money of the player.
     */
    public void setPlayerCoins(int coins) {
        playerCoins += coins;

    }

    /**
     * To get the money of the player.Or to be displayed.
     */
    public int getPlayerCoins() {
        return playerCoins;
    }

    /**
     * This is what the player sees when they wanted to but or upgrade an item.
     */
    public static void buyShop() {

        Shop.addItem("armor", 50);

        while (true) {
            try {
                System.out.println("\nPlayer's coins: " + Main.shop.getPlayerCoins());
                System.out.print("Enter an option: "
                        + "\n\t1 - Buy item"
                        + "\n\t2 - Upgrade weapon"
                        + "\n\t3 - Quit"
                        + "\n> ");
                int option = scanner.nextInt(); scanner.nextLine();

                switch (option) {
                    case 1:
                        System.out.println("0 - Back");
                        displayItems();
                        System.out.print("Enter the item name to buy:\n> ");
                        String buyItem = scanner.next().toLowerCase();
                        if (buyItem.equalsIgnoreCase("0")) {
                            buyShop();
                        } else {
                            buyItem(buyItem);
                        }
                        break;

                    case 2:
                        displayWeaponUpgrades();
                        System.out.println("Enter the weapon name to upgrade:");
                        String upgradeWeapon = scanner.next().toLowerCase();
                        upgradeWeapon(upgradeWeapon);
                        break;

                    case 3:
                        System.out.println("Exiting...");
                        Menu.menuButtons();
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid inputtt. Please try again.");
                }

            } catch (Exception e) {
                System.out.println("Invalid Input. Please try again.");
                scanner.nextLine();
                buyShop();
            }
        }
    }
}
