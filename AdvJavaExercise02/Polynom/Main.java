import java.util.Scanner;

// address the exception issue
public class Main {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Polynom pol1 = null;
        Polynom pol2 = null;
        System.out.println("Welcome to the Polynomional Calculator!");
        int menuOption = Menu.getFirstOption(); // temp value only to the enter the while loop

        while(menuOption >= Menu.getFirstOption() && menuOption <= Menu.getLastOption())
        {
            Menu.printMenu();
            menuOption = scan.nextInt();


            switch (menuOption){
                case 1: { // Create two polynoms
                    double[] factors1 = Menu.buildFactorsArray(Menu.getArrayOrder1());
                    int[] exponents1 = Menu.buildExponentsArray(Menu.getArrayOrder1());

                    double[] factors2 = Menu.buildFactorsArray(Menu.getArrayOrder2());
                    int[] exponents2 = Menu.buildExponentsArray(Menu.getArrayOrder2());

                    Menu.getArraysinput(factors1, factors2 , exponents1 , exponents2);
                    pol1 = Polynom.buildPolynom(factors1,exponents1);
                    pol2 = Polynom.buildPolynom(factors2,exponents2);
                    continue;

                }
                case 2:{ // prints the Polynom
                    if(!Menu.checksIfNulls(pol1,pol2)){
                        System.out.println("Please choose which Polynom to print(1 or 2)");
                        Polynom tempPol = Menu.choosePolNumber(pol1,pol2);
                        System.out.println(tempPol);
                    }
                        continue;
                 }
                case 3: { // Sum Polynoms
                    if(!Menu.checksIfNulls(pol1,pol2)){
                        Menu.chooseArithmeticOrder(pol1,pol2,Menu.getOpPlus());
                    }
                    continue;
                }
                case 4: { // Sub Polynoms
                    if(!Menu.checksIfNulls(pol1,pol2)){
                        Menu.chooseArithmeticOrder(pol1,pol2,Menu.getOpMinus());
                    }
                    continue;
                }
                case 5: { // Derivate Polynoms
                    if(!Menu.checksIfNulls(pol1,pol2)){
                        System.out.println("Please choose which Polynom to devirate (1 or 2)");
                        Polynom tempPol = Menu.choosePolNumber(pol1,pol2);
                        System.out.println("(" + tempPol + ")` = " + tempPol.derivate());

                    }
                    continue;
                }
                case 6: { // Check if Polynoms are equals
                    if(!Menu.checksIfNulls(pol1,pol2)){
                        String res = (pol1.equals(pol2)) ? " are equals!" : " are not equals!";
                        System.out.println(pol1 + " and " + pol2 + res);
                    }
                    continue;
                }
                default: {
                    System.out.println("Have a good day!");
                    return;
                }

             }
            }
        }
}


