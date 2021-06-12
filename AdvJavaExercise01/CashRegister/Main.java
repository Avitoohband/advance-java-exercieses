// Simulate Cash Register Interaction
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayList<Product> productsList = new ArrayList<Product>();
        int option = 0;
        CashRegister reg;

        System.out.println("Start with initial amount of cash?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        option = scan.nextInt();
        if(option == 1){
            System.out.println("Please declare initial amount of cash in the Register");
            reg = new CashRegister(scan.nextDouble());
        }
        else // no
        {
            reg = new CashRegister();
        }

        Product Pen = new Product("Pen" , 8.45);
        Product Eraser = new Product("Eraser" , 6.70);
        Product Bucket = new Product("Bucket" , 9.90);
        Product Pickaxe = new Product("Pickaxe" , 15.50);
        Product Iron = new Product("Hammer" , 20.00);
        Product Scissors = new Product("Scissors" , 11.00);
        Product Screwdriver = new Product("Screwdriver" , 18.45);
        productsList.add(Pen);
        productsList.add(Eraser);
        productsList.add(Bucket);
        productsList.add(Pickaxe);
        productsList.add(Iron);
        productsList.add(Scissors);
        productsList.add(Screwdriver);
//----------------------------------------------------------------------------------------------------------------------
        Menu.helloMessage();
        Menu.printMenu();
        // Repeating the Cash Register menu
        while (option != 10){
            option = scan.nextInt();

            switch (option){
                case 1:{
                    Menu.showProductsList();
                    continue;
                }
                case 2:{
                    // add product to the cart
                    int[] info = Menu.getProductAndAmount();
                    reg.addNewProduct(productsList.get(info[0] - 1), info[1]);
                    System.out.println("You've been added " + info[1] + " " + productsList.get(info[0] - 1).getName() + "s to the list");
                    continue;
                }
                case 3:{
                    int[] info = Menu.getProductAndAmount();
                    reg.removeProduct(productsList.get(info[0] - 1).getName(), info[1]);
                    continue;
                }
                case 4:{
                    //show my list
                    reg.printClientList();
                    continue;
                }
                case 5:{
                    //show the bill
                    System.out.println(reg.getBill());
                    continue;
                }
                case 6:{
                    //checkout
                    System.out.println("Client amount of cash: ");
                    reg.checkout(scan.nextDouble());
                    continue;
                }
                case 7:{
                    //show menu
                    Menu.printMenu();
                    continue;
                }
                case 8:{
                    //Total Sells
                    System.out.format("Total Sells for the day: %.2f\n", reg.getTotalSells());
                    continue;
                }
                case 9:{
                    //show current amount of cash in the register
                    System.out.format("Current amount of Cash in the Register: %.2f\n" ,reg.getCash());
                    continue;
                }
                case 10:{
                    System.out.println("Good Night!");
                }
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
}

