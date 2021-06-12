// This class represent the Menu
import java.util.Scanner;

public class Menu {
//----------------------------------------------------------------------------------------------------------------------
    //Opening message
    public static void helloMessage(){
        System.out.println("Hello there, Welcome to the \"General Store\"");
    }
//----------------------------------------------------------------------------------------------------------------------
    // Prints the menu
    public static void printMenu(){
        System.out.println("---Menu---");
        System.out.println("1.Show Products List");
        System.out.println("2.Add Product to the Cart");
        System.out.println("3.Remove Product from the Cart");
        System.out.println("4.Show my List");
        System.out.println("5.Show the Bill");
        System.out.println("6.Checkout");
        System.out.println("7.Show Menu");
        System.out.println("8.Show Total Sells");
        System.out.println("9.Show cash status");
        System.out.println("10.Call it a day");

    }
//----------------------------------------------------------------------------------------------------------------------
    // Prints the products list
    public static void showProductsList(){
        System.out.println("In our shop you can buy:");
        System.out.println("1) Pen 8.45");
        System.out.println("2) Eraser 6.70");
        System.out.println("3) Bucket 9.90");
        System.out.println("4) Pickaxe 15.50");
        System.out.println("5) Hammer 20.00");
        System.out.println("6) Scissors 11.00");
        System.out.println("7) Screwdriver 18.45");
    }
//----------------------------------------------------------------------------------------------------------------------
    // Gets the client's desired product and amount, returns it as an array
    public static int[] getProductAndAmount(){
        int[] info = new int[2];
        Scanner scan = new Scanner(System.in);
        System.out.println("Product number: ");
        info[0] = scan.nextInt();
        while(info[0] > 7 || info[0] <=0){
            System.out.println("Number is not valid!\nPlease choose again:");
            info[0] = scan.nextInt();
        }
        System.out.println("Product amount: ");
        info[1] = scan.nextInt();
        while (info[1] <= 0){
            System.out.println("Amount must be more than 0\nPlease choose amount again:");
            info[1] = scan.nextInt();
        }
        return info;
    }
//----------------------------------------------------------------------------------------------------------------------
}
