import java.util.*;
public class NumberGame {

    public static void main(String args[]){
        System.out.println("Welcome to the Number Game!");
        System.out.println("The system will generate a random number between 1 and 100");
        System.out.println("Your goal is to guess the number");
        System.out.println("Enter the number of rounds you want to play(1-5):");
        
        Scanner sc = new Scanner(System.in);
        int rounds = sc.nextInt();
        
        Random rand = new Random();
        
        for(int i=0; i<rounds; i++){
            System.out.println("Round "+ (i+1) + " begins...");
            int random = rand.nextInt(100)+1;
            int attempts=0;
            int guess;
            System.out.println("Difficulty level: Easy(no limit on attempts)");
            
            do{
                System.out.print("Enter your guess number: ");
                guess = sc.nextInt();
                attempts++;
                if(guess < random){
                    System.out.println("Your guess is too low. Try again.");
                } 
                else if(guess > random){
                    System.out.println("Your guess is too high. Try again.");
                } 
                else{
                    System.out.println("Congratulations! You guessed the number in "+ attempts + " attempts.");
                }
            } while(guess!=random);

            attempts = 0;
            System.out.println("Difficulty level: Hard(There is a limit of 5 attempts)");
            
            do{
                System.out.print("Enter your guess number: ");
                guess = sc.nextInt();
                attempts++;
                if(guess < random){
                    System.out.println("Your guess is too low. Try again");
                } else if(guess > random){
                    System.out.println("Your guess is too high. try again.");
                } else{
                    System.out.println("Congratulations! You guessed the number in "+attempts+" attempts");
                    if(attempts == 1){
                        System.out.println("Your score : "+ 100);
                    }
                    else if(attempts == 2){
                        System.out.println("Your score : "+80);
                    }
                    else if(attempts == 3){
                        System.out.println("Your score : "+60);
                    }
                    else if(attempts == 4){
                        System.out.println("Your score : "+40);
                    }
                    else{
                        System.out.println("Your score : " + 20);
                    }
                    break;
                }
            } while(attempts < 5);

            if(attempts == 5 && guess != random){
                System.out.println("Sorry, you didn't guess the number in 5 attempts. The number was " + random + ".");
                System.out.println("Your score : 0");
            }

        }
        System.out.println("Thank you for playing the Number Game!");
        sc.close();
    }
}
