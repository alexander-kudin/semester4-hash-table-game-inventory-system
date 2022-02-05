package assignemnt2;
// Aleksandr Kudin, 101258693
// Matthew Campbell, 101289518
// Michael Sirna, 101278670
// Stephen Davis, 101294116
public class Store {
    private String storeName;
    private QuadraticHashTable inventory;
    private int numItems;
    private int maxItems;

    // Constructor. Set the store name and inventory limit.
    public Store(String storeName, int maxSlots){
        this.storeName = storeName;
        this.inventory = new QuadraticHashTable();
        this.numItems = 0;
        this.maxItems = maxSlots;
    }

    // Add Method. Add NEW TYPE of Weapon in the inventory.
    public boolean addWeapon(Weapon weapon){
        if (numItems != maxItems){ // Check for the items limit.
            numItems++; // Increment the number of TYPES of weapon in the inventory.
            return inventory.insert(weapon);
        }
        return false; // Maximum items limit is hit.
    }

    // Delete Method. Delete the selected TYPE of Weapon in the inventory.
    public boolean deleteWeapon(String weaponName) {
        if (weaponExist(weaponName)){
            numItems--; // Decrement the number of TYPES of weapon in the inventory.
            inventory.delete(weaponName); // Calls the delete method in the hash table by passing the item key (weapon name);
            return true;
        }
        return false; // Weapon not found.
    }

    // Sell Method. Decrements the quantity of the Weapon TYPE and returns a singe copy of that Weapon.
    public Weapon sellWeapon(Weapon weapon){
        Weapon soldItem;
        weapon.quantity--; // Decrement the quantity of the Weapons in store storage.
        // Create an instance of the weapon with single quantity.
        soldItem = new Weapon(weapon.name, weapon.weight, weapon.buyPrice, weapon.range, weapon.damage, 1);
        return soldItem; // Return the singe instance copy.
    }

    // Exist Method. Check whether the Weapon is exist in the store.
    public boolean weaponExist(String weaponName){
        int loc = inventory.search(weaponName);
        return loc != -1;
    }

    // Get Method. Return the Weapon object from the store by its name.
    public Weapon getWeapon(String weaponName){
        return inventory.getWeapon(weaponName);
    }

    // View Store Method. Format and print the store information and all the items in the inventory.
    public void viewStore(){
        System.out.println("\n===================================================");
        System.out.printf("%-38s %s %d/%d\n", storeName.toUpperCase(), "ITEMS:", numItems, maxItems);
        System.out.println("===================================================");
        System.out.printf("%-35s %-8s %-8s\n", "NAME", "PRICE", "WEIGHT");
        inventory.printTable();
        System.out.println("===================================================\n");
    }

    // The method checks whether the Weapon is exist and in stock. (For the Game Logic.)
    public boolean isWeaponAvailable(String weaponName) {
        if (weaponExist(weaponName)){
            return inventory.getWeapon(weaponName).quantity > 0; // Whether the quantity in stock is more than zero.
        }
        return false; // Weapon not found.
    }
}