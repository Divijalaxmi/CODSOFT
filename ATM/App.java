import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        MachineFeatures machine = new MachineFeatures();
        Location location = new Location("India", "202001", "Andhra Pradesh", "Chirala", "South", "MainRoad Jandrapet");
        CurrencyComposition composition = new CurrencyComposition(500, 500, 1000, 100, 200);
        User user = new User("Ajay", 123456, "534950638109", 673, 20000, 07, 2029);
        Atm atm = new Atm("12349", location, composition);

        
        while(true){
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. update ATM composition");
            System.out.println("5. See ATM composition");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                      System.out.println("Enter amount to deposit");
                      int amount = sc.nextInt();
                      machine.deposit(atm, user, amount);
                      break;
                case 2:
                      System.out.println("Enter amount for withdraw");
                      amount = sc.nextInt();
                      machine.withdraw(atm, user, amount);
                      break;
                case 3:
                     machine.checkUserBalance(user);
                     break;
                case 4:
                     composition = new CurrencyComposition(3, 5, 100, 5, 10);
                     machine.updateATMLocation(atm,location);
                     machine.updateATMComposition(atm, composition);
                     System.out.println("Updated successfully");
                     break;
                case 5:
                     machine.seeComposition(composition);
                     break;
                case 6:
                     System.out.println("Exiting application");
                     System.exit(0);
                     break;
                default:
                     System.out.println("Invalid option. Choose another option.");
            }
        }
    }
}
