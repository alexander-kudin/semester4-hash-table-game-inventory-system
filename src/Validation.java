import java.util.Scanner;
// Aleksandr Kudin, 101258693
// Matthew Campbell, 101289518
// Michael Sirna, 101278670
// Stephen Davis, 101294116
public class Validation {
    public static int getInteger(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        while (!sc.hasNextInt())
        {
            sc.nextLine(); //clear the invalid input ...
            System.out.print(message);
        }
        return sc.nextInt();
    }

    public static String getString(String message){
        Scanner sc = new Scanner(System.in);
        String string;
        System.out.print(message);
        string = sc.nextLine();
        return string;
    }

    public static double getDouble(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        while (!sc.hasNextDouble())
        {
            sc.nextLine(); //clear the invalid input ...
            System.out.print(message);
        }
        return sc.nextDouble();
    }

    public static int getValidChoice(int max, String menu)
    {
        int choice;
        System.out.println(menu);
        choice = Validation.getInteger("Menu Option: ");
        while (choice < 1 || choice > max)
        {
            System.out.println(menu);
            choice = Validation.getInteger("Menu Option: ");
        }
        return choice;
    }
}
