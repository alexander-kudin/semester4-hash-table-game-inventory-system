package assignemnt2;
// Aleksandr Kudin, 101258693
// Matthew Campbell, 101289518
// Michael Sirna, 101278670
// Stephen Davis, 101294116
public class Backpack {
    private SeparateChainingHashTable inventory;
    private int numItems;
    private int maxItems;

    // Constructor.
    public Backpack(int maxItems) {
        this.inventory = new SeparateChainingHashTable(maxItems);
        this.numItems = 0;
        this.maxItems = maxItems;
    }

    // Add Method.
    public boolean addItem(Weapon weapon){
        if (isFull()){ // Check if the number of items hit the maximum limit.
            System.out.println("The backpack is full!");
            return false; // Backpack is full.
        }
        if (weaponExist(weapon.name)) { // Check if the Weapon already exist.
            getWeapon(weapon.name).quantity += weapon.quantity; // Increment the Weapon quantity.
            numItems += weapon.quantity; // Increment the number of current number of items in the backpack.
            return true;
        }
        inventory.insert(weapon); // Insert the new type of Weapon in the Backpack (in the HashTable).
        numItems += weapon.quantity; // Increment the number of current number of items in the backpack.
        return true;
    }

    // Weapon Exist Method. Check whether the Weapon object exists in the backpack hashtable or not.
    public boolean weaponExist(String weaponName){
        int loc = inventory.search(weaponName);
        return loc != -1;
    }

    // Get Method. Returns the Weapon object from the backpack hash table.
    public Weapon getWeapon(String weaponName){
        return inventory.getWeapon(weaponName);
    }

    // View Backpack Method. Print all the information about the back pack and the list of weapons in it.
    public void viewBackpack(){
        System.out.println("\n===================================================");
        System.out.printf("%-38s %s %d/%d\n", "My Backpack".toUpperCase(), "ITEMS:", numItems, maxItems);
        System.out.println("===================================================");
        if (numItems == 0) {
            System.out.println("Your backpack is empty..");
        }else{
            System.out.printf("%-35s %-8s %-8s\n", "NAME", "PRICE", "WEIGHT");
        }
        inventory.printTable();
        System.out.println("===================================================");
    }

    // The method check whether the backpack hit the maximum items limit.
    public boolean isFull() {
        return numItems == maxItems;
    }
}




