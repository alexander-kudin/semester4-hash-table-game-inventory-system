// Aleksandr Kudin, 101258693
// Matthew Campbell, 101289518
// Michael Sirna, 101278670
// Stephen Davis, 101294116
public class Weapon {
    public String name;
    public double buyPrice;
    public double weight;
    public int quantity;
    public int range;
    public int damage;

    public Weapon(String name, double weight, double buyPrice, int range, int damage) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.weight = weight;
        this.range = range;
        this.damage = damage;
        this.quantity = 0;
    }

    public Weapon(String name, double weight, double buyPrice, int range, int damage, int quantity) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.weight = weight;
        this.range = range;
        this.damage = damage;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-35s %-8.2f %.2f", name + " (" + quantity + ")", buyPrice, weight);
    }
}