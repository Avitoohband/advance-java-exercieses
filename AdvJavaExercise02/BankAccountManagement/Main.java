import java.util.Scanner;

// This is the operator of the Bank Management Program
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int placeboOption = 0;

        // These are the account, two of each type, one with default props, one with declared props

        ServiceChargeChecking service1 = new ServiceChargeChecking("Tatiana Steadman","yh5Sg6LAew","151205760",0);
        ServiceChargeChecking service2 = new ServiceChargeChecking("Shayla Mansell","YPun4-hdCv","358515985",0,2.5);

        NoServiceChargeChecking noService1 = new NoServiceChargeChecking("Persephone Brady","H-e1poIqsK","188182677",0);
        NoServiceChargeChecking noService2 = new NoServiceChargeChecking("Ayaan Rudd","NdNHuZebk6","970636986",0,100);

        InterestChecking interest1 = new InterestChecking("Kwabena Hopkins","4TZna5VQNh","491606102",0);
        InterestChecking interest2 = new InterestChecking("Ava-Grace Osborne","sAJNMVU0Sj","909306586",0,1.5);

        SavingsAccount saving1 = new SavingsAccount("Kie Reeves","knXrW8uf8m","264852237",0);
        SavingsAccount saving2 = new SavingsAccount("Maciej Mccabe","4aBt_twPks","682466383",0,2.25);

        HighInterestSavings highInterest1 = new HighInterestSavings("Habib Thorpe","13RXwOgOpt","661117173",0);
        HighInterestSavings highInterest2 = new HighInterestSavings("Savannah Baker","UjIrJllKA_","018018179",0,4,150);

        // for equals
        NoServiceChargeChecking noService3 = new NoServiceChargeChecking("Ayaan Rudd","NdNHuZebk6","970636986",0,100);
        InterestChecking interest3 = new InterestChecking("Ava-Grace Osborne","sAJNMVU0Sj","909306586",0,1.5);






        System.out.println("Hello, to the Bank Account Management Program!");
        System.out.println("type any number and enter to continue");
        placeboOption = scan.nextInt();

         while (5>4){

             System.out.println("These are the Accounts with the default properties:\n");
             System.out.println(service1);
             System.out.println();
             System.out.println(noService1);
             System.out.println();
             System.out.println(interest1);
             System.out.println();
             System.out.println(saving1);
             System.out.println();
             System.out.println(highInterest1);
             System.out.println();
             System.out.print("------------------------------------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");

             System.out.println("type any number and enter to continue");
             placeboOption = scan.nextInt();

             System.out.println("These are the Accounts with the declared properties:\n");
             System.out.println(service2);
             System.out.println();
             System.out.println(noService2);
             System.out.println();
             System.out.println(interest2);
             System.out.println();
             System.out.println(saving2);
             System.out.println();
             System.out.println(highInterest2);
             System.out.println();
             System.out.print("------------------------------------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");


             System.out.println("type any number and enter to continue");
             placeboOption = scan.nextInt();
             System.out.print("--------------------DEPOSITS!-------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");


             System.out.println("These are random deposits from some of the accounts\n");

             service1.deposit(250);
             System.out.println(service1);
             System.out.println();
             noService1.deposit(250);
             System.out.println(noService1);
             System.out.println();
             interest1.deposit(250);
             System.out.println(interest1);
             System.out.println();
             System.out.print("--------------------WITHDRAWS!------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");
             System.out.println("These are random withdraws from some of the accounts\n");




             try{
                 service1.withdraw(150);
                 System.out.println(service1);
                 System.out.println();
                 noService1.withdraw(150);
                 System.out.println(noService1);
                 System.out.println();
                 interest1.withdraw(150);
                 System.out.println(interest1);
                 System.out.println();

             }
             catch(IllegalBalance e){
                 System.out.println(e.getMessage());
             }
             System.out.print("------------------------------------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");


             System.out.println("type any number and enter to continue");
             placeboOption = scan.nextInt();
             System.out.print("--------------------WRITE CHECKS!---------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");

             System.out.println("These are random checks for account which are available to use checks\n");

             try{
                 service1.writeCheck(50);
                 System.out.println(service1);
                 System.out.println();
                 noService1.writeCheck(50);
                 System.out.println(noService1);

                 System.out.println();

                 interest1.writeCheck(50);
                 System.out.println(interest1);
             }
             catch(IllegalBalance e){
                 System.out.println(e.getMessage());
             }
             System.out.print("------------------------------------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");

             System.out.println("type any number and enter to continue");
             placeboOption = scan.nextInt();
             System.out.print("--------------------MONTHLY MANAGEMENT!---------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");

             System.out.println("These are the monthly management function for some accounts!\n");


             service1.monthlyManagement();
             System.out.println(service1);
             System.out.println();
             noService1.monthlyManagement();
             System.out.println(noService1);
             System.out.println();
             interest1.monthlyManagement();
             System.out.println(interest1);
             System.out.print("------------------------------------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");

             System.out.println("type any number and enter to continue");
             placeboOption = scan.nextInt();
             System.out.print("--------------------EQUALS----------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");
             System.out.println("This is some equals usage between some accounts\n");


             System.out.println("equals ---> \n"+ noService2 + "\n to other accounts:\n ");
             System.out.println("equals with:\n" + service1);
             System.out.println(noService2.equals(service1));

             System.out.println("equals with:\n" + interest2);
             System.out.println(noService2.equals(interest2));


             System.out.println("equals with\n" + noService3);
             System.out.println(noService2.equals(noService3));

             System.out.print("------------------------------------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");
             System.out.println("type any number and enter to continue");
             placeboOption = scan.nextInt();

             System.out.println("These are some more equals usage between some accounts\n");

             System.out.println("equals ---> \n"+ interest2 + "\n to other accounts:\n ");
             System.out.println("equals with:\n" + service2);
             System.out.println(interest2.equals(service2));

             System.out.println("equals with:\n" + highInterest2);
             System.out.println(interest2.equals(highInterest2));


             System.out.println("equals with\n" + interest3);
             System.out.println(interest2.equals(interest3));
             System.out.print("------------------------------------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");

             System.out.println("type any number and enter to continue");
             placeboOption = scan.nextInt();

             System.out.print("--------------------EXCEPTIONS!-----------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");

              try{
                  System.out.println("Withdraw attempt from this account ----->");
                  System.out.println(service1);
                  System.out.println("Withdrawing 150$");
                  service1.withdraw(150);

              }

              catch(IllegalBalance e){

                  System.out.println((e.getMessage()));
             }
             System.out.print("------------------------------------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");

             try{
                 System.out.println("Writecheck attempt from this account ----->");
                 System.out.println(noService1);
                 noService1.writeCheck(250);

             }

             catch(IllegalBalance e){

                 System.out.println((e.getMessage()));
             }
             System.out.print("------------------------------------------------------------------------------------------");
             System.out.println("------------------------------------------------------------------------------------------");
             System.out.println("Thanks and have a nice day!");
             break;

         }















    }
}
