// This Class represent the menu, the operator of the Polynom class
import java.util.Scanner;

public class  Menu {


    private static final int firstOption = 1;
    private static final int lastOption = 6;

    private static final  String arrayOrder1 = "first Polynom";
    private static final String arrayOrder2 =  "second Polynom";

    private static final String opPlus = "+";
    private static final String opMinus = "-";

    private static final int endOfArrayOffset = -1;

    // Prints the menu
    public static void printMenu(){
        System.out.println("\n1.Create Two Polynoms");
        System.out.println("2.Print Polynom");
        System.out.println("3.Sum Polynoms");
        System.out.println("4.Sub Polynoms");
        System.out.println("5.Derivate Polynom");
        System.out.println("6.Check if Polynoms are equals");
        System.out.println("Type any other number to quit");
    }
//----------------------------------------------------------------------------------------------------------------------
    // Gets input from the user to declare the size of the exponents array
    public static int[] buildExponentsArray(String order){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please type how many exponents for the " + order);
        int size = scan.nextInt();

        return new int[size];
    }
//----------------------------------------------------------------------------------------------------------------------
    // Gets input from the user to declare the size of the factors array
    public static double[] buildFactorsArray(String order){
    Scanner scan = new Scanner(System.in);

    System.out.println("Please type how many factors for the " + order);
    int size = scan.nextInt();

    return new double[size];
}
//----------------------------------------------------------------------------------------------------------------------
    // Gets input to fill both of the factors and exponents arrays
    public static void getArraysinput(double[] fac1, double[] fac2, int[] exp1, int[] exp2){
        Scanner scan = new Scanner(System.in);

        System.out.println("What are the factors for the " + getArrayOrder1());
        for (int i = 0 ; i < fac1.length ; i++){
            fac1[i] = scan.nextDouble();
        }
        System.out.println("What are the exponents for the " + getArrayOrder1());
        for (int i = 0 ; i < exp1.length ; i++){
            exp1[i] = scan.nextInt();
        }
        System.out.println("What are the factors for the " + getArrayOrder2());
        for (int i = 0 ; i < fac2.length ; i++){
            fac2[i] = scan.nextDouble();
        }
        System.out.println("What are the exponents for the " + getArrayOrder2());
        for (int i = 0 ; i < exp2.length ; i++){
            exp2[i] = scan.nextInt();
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    // Checks if one of the polynoms is null
    public static boolean checksIfNulls(Polynom pol1, Polynom pol2){

        if(pol1 == null || pol2 == null){
            System.out.println("Create Polynoms first!");
            return true;
        }
        return false;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Let the user choose which polynom he wants to use
    public static Polynom choosePolNumber(Polynom pol1, Polynom pol2){
        Scanner scan = new Scanner(System.in);

        int polNumber = scan.nextInt();

        while(polNumber < 1 || polNumber > 2){
            System.out.println("Polynom numbers must be 1 or 2 ! Type again");
            polNumber = scan.nextInt();
        }
        if( polNumber == 1){
            return pol1;
        }
        return pol2;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Let the user choose in which order he wants the Plynom mathematical operation to happen
    public static void chooseArithmeticOrder(Polynom pol1, Polynom pol2, String operator){
        Scanner scan = new Scanner(System.in);
        int option;
        String order1 = "("+pol1+")" + " "+operator+ " " + "("+pol2+")" + " = ";
        String order2 = "("+pol2+")" + " "+operator+ " " + "("+pol1+")" + " = ";
        System.out.println("What is the desired order:");
        System.out.println("1)" + order1);
        System.out.println("2)" + order2);
        option = scan.nextInt();
        while(option < 1 || option > 2) {
            System.out.println("option must be 1 or 2!");
            option = scan.nextInt();
        }
        if(operator.equals(opPlus)){ // the desired function is plus
            if(option == 1){
                System.out.println(order1 + pol1.plus(pol2));
            }
            else{ // option 2
                System.out.print(order2 + pol2.plus(pol1));
            }
        }
        else{ // the desired function is minus
            if(option == 1){
                System.out.println(order1 + pol1.minus(pol2));
            }
            else{ // option 2
                System.out.println(order2 + pol2.minus(pol1));

            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------

    public static int getFirstOption() {
        return firstOption;
    }
//----------------------------------------------------------------------------------------------------------------------

    public static int getLastOption() {
        return lastOption;
    }
//----------------------------------------------------------------------------------------------------------------------

    public static String getArrayOrder1() {
        return arrayOrder1;
    }
//----------------------------------------------------------------------------------------------------------------------

    public static String getArrayOrder2() {
        return arrayOrder2;
    }
//----------------------------------------------------------------------------------------------------------------------

    public static String getOpPlus() {
        return opPlus;
    }
//----------------------------------------------------------------------------------------------------------------------

    public static String getOpMinus() {
        return opMinus;
    }
//----------------------------------------------------------------------------------------------------------------------
    public static int getEndOfArrayOffset(){
        return endOfArrayOffset;
    }
//----------------------------------------------------------------------------------------------------------------------
}
