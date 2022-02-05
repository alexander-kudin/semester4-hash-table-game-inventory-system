// Aleksandr Kudin, 101258693
// Matthew Campbell, 101289518
// Michael Sirna, 101278670
// Stephen Davis, 101294116
public class Program {

    static Store blacksmithStore;
    static Player bravePlayer;

    public static void viewPlayer() {
        bravePlayer.viewPlayer();
        Validation.getString("\nPress ENTER to continue return to the main menu.");
    }

    public static void viewBackpack() {
        bravePlayer.viewBackpack();
        Validation.getString("\nPress ENTER to continue return to the main menu.");
    }

    public static void addStoreItem() {
        String iname;
        double iweight, icost;
        int irange, idamage;
        blacksmithStore.viewStore();
        System.out.println("-----------Add Item----------");
        iname = Validation.getString("Please enter the item's name(0 to exit): ");
        if (iname.equalsIgnoreCase("0")){
            System.out.println("Return to the menu..");
            return;
        }
        if (blacksmithStore.weaponExist(iname)){
            System.out.println("The item is already exist..");
            addItemInStock(iname);
            return;
        }
        iweight = Validation.getDouble("Please enter the item's weight: ");
        icost = Validation.getDouble("Please enter the item's cost: ");
        irange = Validation.getInteger("Please enter the item's range: ");
        idamage = Validation.getInteger("Please enter the item's damage: ");
        if (blacksmithStore.addWeapon(new Weapon(iname, iweight, icost, irange, idamage))){
            System.out.println("Item successfully added..");
            addItemInStock(iname);
        }
        else{
            System.out.println("Item was not added..");
        }
    }

    public static void addItemInStock(String weaponName){
        int iquantity;
        iquantity = Validation.getInteger("Please enter the item's quantity: ");
        blacksmithStore.getWeapon(weaponName).quantity = blacksmithStore.getWeapon(weaponName).quantity + iquantity;
        System.out.println(iquantity + " " + weaponName.toUpperCase() + " have/has been added in stock.");
        Validation.getString("\nPress ENTER to continue return to the main menu.");
    }

    public static void deleteStoreItem() {
        String itemName;
        blacksmithStore.viewStore();
        itemName = Validation.getString("Please enter an item's name to delete(0 to exit): ");
        if (itemName.equalsIgnoreCase("0")){
            System.out.println("Return to the menu..");
            return;
        }
        if (blacksmithStore.deleteWeapon(itemName)) {
            System.out.println("Item " + itemName.toUpperCase() + " deleted..");
        }
        else {
            System.out.println("Item " + itemName.toUpperCase() + " was not found..");
        }
        Validation.getString("\nPress ENTER to continue return to the main menu.");
    }

    // Business Logic of buying weapon.
    public static void buyItem() {
        String itemName;
        Weapon soldWeapon;
        bravePlayer.viewPlayer();
        blacksmithStore.viewStore();
        System.out.println("-----------Buy Weapon----------");
        itemName = Validation.getString("Please enter a weapon name to buy(0 to exit): ");
        if (itemName.equalsIgnoreCase("0")){
            System.out.println("Return to the main menu..");
            return;
        }
        if (!blacksmithStore.isWeaponAvailable(itemName)){
            System.out.println("The weapon is not available in the store...");
            return;
        }
        if (!bravePlayer.canAfford(blacksmithStore.getWeapon(itemName))){
            System.out.println("The item cannot be added in your backpack...");
            return;
        }
        soldWeapon = blacksmithStore.sellWeapon(blacksmithStore.getWeapon(itemName));
        bravePlayer.buyItem(soldWeapon);
        System.out.println("Thank you for purchasing " + itemName.toUpperCase());
        System.out.println(itemName.toUpperCase() + " has been added in your backpack");
        bravePlayer.viewBackpack();
        Validation.getString("\nPress ENTER to continue return to the main menu.");
    }

    public static String storeManageMenu() {
        String s = "\nPlease select a choice from the menu below:\n";
        s += "1: Add Store Item \n";
        s += "2: Delete Item \n";
        s += "3: Return to the main menu.";
        return s;
    }

    public static String mainMenu() {
        String s = "\nPlease select a choice from the menu below:\n";
        s += "1: Buy Item \n";
        s += "2: View Player \n";
        s += "3: View Backpack \n";
        s += "4: Store Manage Options \n";
        s += "5: Exit";
        return s;
    }

    public static void runStoreManageMenu() {
        String menu = storeManageMenu();
        blacksmithStore.viewStore();
        int choice = Validation.getValidChoice(3, menu);
        while (choice != 3)
        {
            if (choice == 1) { addStoreItem(); }
            if (choice == 2) { deleteStoreItem(); }
            blacksmithStore.viewStore();
            choice = Validation.getValidChoice(3, menu);
        }
    }

    public static void runProgram() {
        String menu = mainMenu();
        int choice = Validation.getValidChoice(5, menu);
        while (choice != 5)
        {
            if (choice == 1) { buyItem(); }
            if (choice == 2) { viewPlayer(); }
            if (choice == 3) { viewBackpack(); }
            if (choice == 4) { runStoreManageMenu(); }

            choice = Validation.getValidChoice(5, menu);
        }
    }

    public static void createPlayer(){
        String playerName = Validation.getString("Enter the player name: ");
        bravePlayer = new Player(playerName, 30);
    }

    public static void main(String[] args) {
        blacksmithStore = new Store("Blacksmith's Store", 80);
        blacksmithStore.addWeapon(new Weapon("Iron Sword", 11, 10, 1, 7, 4));
        blacksmithStore.addWeapon(new Weapon("Steel Sword", 15, 15, 1, 8, 1));
        blacksmithStore.addWeapon(new Weapon("Orcish Sword", 11, 10, 1, 9));
        blacksmithStore.addWeapon(new Weapon("Iron War Axe", 11, 10, 1, 8, 1));
        blacksmithStore.addWeapon(new Weapon("Glass War Axe", 13, 50, 1, 16, 2));
        blacksmithStore.addWeapon(new Weapon("Steel War Axe", 11, 15, 1, 9, 2));
        blacksmithStore.addWeapon(new Weapon("Iron Dagger", 2, 4, 1, 4, 5));
        blacksmithStore.addWeapon(new Weapon("Steel Dagger", 2.5, 5, 1, 5));
        blacksmithStore.addWeapon(new Weapon("Steel Battleaxe", 21, 30, 1, 18));
        blacksmithStore.addWeapon(new Weapon("Steel Warhammer", 25, 20, 1, 20, 2));
        blacksmithStore.addWeapon(new Weapon("Wizard Necronomicon", 2.5, 35, 1, 12, 1));
        blacksmithStore.addWeapon(new Weapon("Hunting Bow", 7, 25, 8, 7, 6));
        blacksmithStore.addWeapon(new Weapon("Long Bow", 5, 10, 7, 6));
        createPlayer();
        bravePlayer.viewPlayer();
        runProgram();
    }
}
