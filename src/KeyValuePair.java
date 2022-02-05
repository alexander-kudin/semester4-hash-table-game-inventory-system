// Aleksandr Kudin, 101258693
// Matthew Campbell, 101289518
// Michael Sirna, 101278670
// Stephen Davis, 101294116
public class KeyValuePair {
    public String key;
    private Weapon value;

    public KeyValuePair(String key, Weapon weapon) {
        this.key = key;
        this.value = weapon;
    }

    // Drop Function. Implements when the Weapon is being deleted from the hash table.
    public void drop(){
        key = null;
        value = null;
    }

    public Weapon getValue(){ return value; }

    public String getKey() {
        if (key != null){
            return key;
        }
        return "DELETED"; // If the Weapon is deleted.
    }
}