package assignemnt2;
// Aleksandr Kudin, 101258693
// Matthew Campbell, 101289518
// Michael Sirna, 101278670
// Stephen Davis, 101294116
public class Node {
    public KeyValuePair data;
    public Node next;

    public Node(KeyValuePair keyValuePair) {
        this.data = keyValuePair;
        this.next = null;
    }
}
