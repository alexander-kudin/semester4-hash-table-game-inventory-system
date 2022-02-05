package assignemnt2;
// Aleksandr Kudin, 101258693
// Matthew Campbell, 101289518
// Michael Sirna, 101278670
// Stephen Davis, 101294116
public class QuadraticHashTable {
    private int numItems;
    private int tableSize;
    private KeyValuePair[] table;
    private final double LOAD_FACTOR = 0.80;

    // Constructor. Table size is hardcoded.
    public QuadraticHashTable(){
        numItems = 0;
        tableSize = 101; // 101 is a prime number suitable for the hash table.
        table = new KeyValuePair[101];
    }

    // Hash Method. Returns the hash value of the Weapon key (weapon name).
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
    public boolean insert (Weapon weapon){
        if ((double)numItems/tableSize < LOAD_FACTOR){
            int count = 1;
            int loc = hashFunction(weapon.name);
            // Loop while it's not NULL AND the Key Value Pair value is not deleted.
            while (table[loc] != null && table[loc].key != null){
                loc = (loc + count * count) % tableSize; // Quadratic probing.
                count++;
            }
            table[loc] = new KeyValuePair(weapon.name, weapon);
            numItems++;
            return true;
        }
        return false; // Load Factor Error.
    }

    // Search Method. Search for a Weapon object in the hash table by its key (weapon name) and returns its location.
    public int search(String key){
        int loc = hashFunction(key);
        int count = 1;
        // Loop while it's not NULL AND the key value in the Key Value Pair does not match.
        while (table[loc] != null && !table[loc].getKey().equalsIgnoreCase(key)){
            loc = (loc + count * count) % tableSize; // Quadratic probing.
            count++;
        }
        if (table[loc] == null){ // Weapon not found.
            return -1;
        }
        return loc;
    }

    // Delete Method. Search for a Weapon object in the hash table by its key (weapon name) and reset the Key Value Pair object.
    public void delete(String key){
        int loc = search(key);
        if (loc == -1){ return; } // Weapon not found.
        table[loc].drop(); // Reset the Key Value Pair object with the Weapon object in it.
        numItems--;
    }

    // Get Method. Search for a Weapon object in the hash table by its key (weapon name) and returns the object if found.
    public Weapon getWeapon(String key){
        int loc = search(key);
        if (loc != -1){ // Weapon is found.
            return table[search(key)].getValue(); // Return the Weapon object.
        }
        return null; // Weapon not found.
    }

    // Print Method. Check for existing in the hash table Weapon objects and print their value.
    public void printTable(){
        for (int x = 0; x < tableSize; x++){
            if (table[x] != null && table[x].getValue() != null){
                System.out.println(table[x].getValue().toString());
            }
        }
    }
}