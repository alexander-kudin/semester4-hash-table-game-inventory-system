package assignemnt2;
// Aleksandr Kudin, 101258693
// Matthew Campbell, 101289518
// Michael Sirna, 101278670
// Stephen Davis, 101294116
public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addFront(KeyValuePair keyValuePair){
        Node newNode = new Node(keyValuePair);
        if (head == null){ // Check whether the Linked List is empty.
            head = newNode; // Create first node.
            return;
        }
        newNode.next = head;  // Insert current head of the Linked List in the new node.
        head = newNode; // Insert the new node in the front of Lhe linked List.
    }

    // Exist Function. Checks whether the item exist in the current Link List.
    public boolean itemExist(String key){
        Node curr = head;
        while (curr != null){ // Checking each node in the list.
            if (curr.data.key.equalsIgnoreCase(key)){ // Match the key.
                return true;
            }
            curr = curr.next; // Go to the next node.
        }
        return false;
    }

    // Get Function. Returns the node data value (Weapon) by the KeyValuePair key (Weapon name).
    public Weapon getItem(String key){
        Node curr = head;
        while (curr != null){ // Checking each node in the list.
            if (curr.data.key.equalsIgnoreCase(key)){ // Match the key.
                return curr.data.getValue(); // Return the Weapon object.
            }
            curr = curr.next; // Go to the next node.
        }
        return null; // The weapon not found.
    }

    // Print Function. Prints all nodes and their data (KeyValuePairs).
    public void printList(){
        Node curr = head; // Start from the head (the first) node.
        while (curr != null){ // Go through each node in the list.
            System.out.println(curr.data.getValue().toString()); // Print KeyValuePair values information.
            curr = curr.next; // Go to the next node.
        }
    }
}
