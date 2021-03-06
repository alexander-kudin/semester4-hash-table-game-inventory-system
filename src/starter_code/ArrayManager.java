package starter_code;

public class ArrayManager {

    int maxItems;    // records the max size of the table
    int numItems;       // records number of items in the list
    ShopItem[] table; //hashtable itself

    public ArrayManager(int size)
    {
        maxItems = size;
        numItems = 0;
        table = new ShopItem[maxItems];
    }

    public void put(Weapon item,int quantity)
    {
        if (numItems<maxItems){
            table[numItems] = new ShopItem(item,quantity);
            numItems++;
        }

    }

    public ShopItem get(String key)
    {
        int location = 0; //gets location in table based on key

        while (location <numItems && key.compareTo(table[location].item.weaponName) != 0)
        {  // not empty and not item
            location++;
        }
        if (location<numItems){
            return table[location];
        }
        return null;
    }

    public void printTable()
    {
        int count = 0;
        for (int x = 0; x < numItems; x++)
        {
            System.out.println("Name: " +table[x].item.weaponName+"   Damage:"+table[x].item.damage+"    Cost:"+table[x].item.cost+"     Quantity in stock:"+table[x].numberInStock);
        }
    }
}

