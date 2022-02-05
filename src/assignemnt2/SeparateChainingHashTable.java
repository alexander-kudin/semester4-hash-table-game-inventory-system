package assignemnt2;
// Aleksandr Kudin, 101258693
// Matthew Campbell, 101289518
// Michael Sirna, 101278670
// Stephen Davis, 101294116
public class SeparateChainingHashTable {
    private int numItems;
    private int tableSize;
    private LinkedList[] table;
    private final double LOAD_FACTOR = 0.80;

    // Constructor. Takes maximum number of items needed and calculates the table size.
    public SeparateChainingHashTable(int maxItems){
        numItems = 0;
        tableSize = (int)Math.ceil(maxItems/LOAD_FACTOR); // Multiply the maximum number of items needed by the load factor.
        table = new LinkedList[tableSize];
    }

    // Hash Method. Returns the hash value of the weapon key (weapon name).
    private int hashFunction(String key){
        key = key.toLowerCase();
        int value = 0, weight = 1;
        for (int x = 0; x < key.length(); x++){
            value += (key.charAt(x) -'a'+ 1) * weight;
            weight++;
        }
        if (value < 0) { value *= -1; } // If the value is negative, make it positive.
        return value % tableSize;
    }

    // Insert Method. Insert Weapon object in the location based on the value of the hash method.
    public void insert (Weapon weapon){
        if ((double)numItems/tableSize < LOAD_FACTOR){
            int loc = hashFunction(weapon.name);
            if (table[loc] == null){ // Check if Linked List object is created.
                table[loc] = new LinkedList(); // Create new Linked ist object.
                numItems++; // Increment the number of items in the hash table.
            }
            // Add the Weapon object in the front of the Linked List object.
            table[loc].addFront(new KeyValuePair(weapon.name, weapon));
        }
    }

    // Search Method. Search for a Weapon object in the hash table by its key (weapon name) and returns its location.
    public int search(String key){
        int loc = hashFunction(key);
        if (table[loc] == null){ // Check if the Linked List object exist.
            return -1; // Linked List object not exist. Weapon cannot be found.
        }
        if (!table[loc].itemExist(key)){ // Check if the Weapon object exist in the Linked List object.
            return -1; // Weapon object does not exist.
        }
        return loc;
    }

    // Get Method. Search for a Weapon object in the hash table by its key (weapon name) and returns the object if found.
    public Weapon getWeapon(String key){
        int loc = search(key);
        if (loc != -1){ // Weapon found.
            return table[loc].getItem(key); // Return the Weapon object.
        }
        return null; // Weapon not found.
    }

    // Print Method. Calls the printList method of each Linked List object in the hash table.
    public void printTable(){
        for (int x = 0; x < tableSize; x++){
            if (table[x] != null){
                table[x].printList();
            }
        }
    }
}
