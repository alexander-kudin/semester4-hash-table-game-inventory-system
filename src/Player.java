// Aleksandr Kudin, 101258693
// Matthew Campbell, 101289518
// Michael Sirna, 101278670
// Stephen Davis, 101294116
public class Player {
    private String name;
    private Backpack backpack;
    private double coins;
    private double currWeight;
    private double maxWeight;

    // Constructor.
    public Player(String name, int maxItems) {
        this.name = name;
        this.coins = 45;
        this.backpack = new Backpack(maxItems);
        this.currWeight = 0;
        this.maxWeight = 90;
    }

    // View Player Method. Display all the information about the player (Amount of money and the weight carried) and the backpack,
    public void viewPlayer() {
        System.out.println("\n===================================================");
        System.out.printf("%s %-10s %s %.2f   %s %.1f/%.1f\n", "PLAYER:", name.toUpperCase(), "MONEY:", coins, "WEIGHT:", currWeight, maxWeight);
        System.out.println("===================================================");
        viewBackpack();
    }

    public void viewBackpack() {
        backpack.viewBackpack();
    }

    // Can Afford Method. The method checks whether the player has meet all the requirement in order to get an item from the store.
    public boolean canAfford(Weapon weaponToBuy) {
        if (coins - weaponToBuy.buyPrice < 0){
            System.out.println("You don't have enough coins.");
            return false; // Not enough money.
        }
        if (currWeight + weaponToBuy.weight > maxWeight){
            System.out.println("You don't have enough weight to carry.");
            return false; // Too much weight.
        }
        if (backpack.isFull()) {
            System.out.println("You don't have enough space in your backpack.");
            return false; // No space in the backpack.
        }
        return true; // All good! Can afford!
    }

    // Buy Item Method. Implements the Buy Weapon Logic.
    public void buyItem(Weapon weaponToBuy) {
        coins -= weaponToBuy.buyPrice; // Removes amount of money the new Weapon cost.
        currWeight += weaponToBuy.weight; // Adds amount of weight the new Weapon weight.
        backpack.addItem(weaponToBuy); // Finally, add the new item into the back pack.
    }
}

