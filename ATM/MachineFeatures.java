import java.time.LocalDateTime;

public class MachineFeatures {
    public Atm createAtm(Location location, CurrencyComposition currencyComposition){
        return new Atm("",location, currencyComposition);
    }

    public void updateATMLocation(Atm atm, Location location){
        atm.setLocation(location);
    }

    public void updateATMComposition(Atm atm, CurrencyComposition currencyComposition){
        atm.setCurrencyComposition(currencyComposition);
    }

    public void seeComposition(CurrencyComposition currencyComposition){
        System.out.println("ATM Composition is: ");
        System.out.println("________________________________________");
        System.out.println("1. 500 notes: " + currencyComposition.getFiveHundredNotes());
        System.out.println("2. 200 notes: " + currencyComposition.getTwoHundredNotes());
        System.out.println("3. 100 notes: " + currencyComposition.getOneHundredNotes());
        System.out.println("4. 50 notes: " + currencyComposition.getFiftyNotes());
        System.out.println("5. 10 notes: " + currencyComposition.getTenNotes());
        System.out.println("_________________________________________");
    }

    public void checkUserBalance(User user){
        System.out.println("Your balance is: " + user.getBalance());
    }

    public void withdraw(Atm atm, User user, int amount){
        if(user.getBalance() < amount){
            Transaction transaction = new Transaction(12334L, LocalDateTime.now(), TransactionType.FAILED, amount, Verdict.FAILURE, atm.getLocation());
            atm.getTransactions().add(transaction);
            System.out.println("Insufficient Balance");
            return;
        }
        
        if(atm.getBalance() < amount){
            Transaction transaction = new Transaction(12335L, LocalDateTime.now(), TransactionType.FAILED, amount, Verdict.OUT_OF_MONEY, atm.getLocation());
            atm.getTransactions().add(transaction);
            System.out.println("Sorry! we are out of Funds");
            return;
        }

        Transaction transaction = new Transaction(12336L, LocalDateTime.now(), TransactionType.DEBIT, amount, Verdict.SUCCESS, atm.getLocation());
        atm.getTransactions().add(transaction);

        updateCompositionNotes(atm, amount);
        System.out.println("Account is debited with " + amount);

        user.setBalance(user.getBalance()-amount);
        checkUserBalance(user);
        //atm.setBalance(atm.getBalance()-amount);

    } 
    public void deposit(Atm atm, User user, int amount){
        user.setBalance(user.getBalance()+amount);
        System.out.println("Balance after deposit:"+ user.getBalance());
    }

    private void updateCompositionNotes(Atm atm, int amount){
        CurrencyComposition composition = atm.getCurrencyComposition();
        int fiveHundredNotes = amount/500;
        if(composition.getFiveHundredNotes() >= fiveHundredNotes){
            amount = amount-fiveHundredNotes*500;
            composition.setFiveHundredNotes(fiveHundredNotes);
        }

        int twoHundredNotes = amount/200;
        if(composition.getTwoHundredNotes() >= twoHundredNotes){
            amount = amount-twoHundredNotes*200;
            composition.setTwoHundredNotes(twoHundredNotes);
        }

        int oneHundredNotes = amount/100;
        if(composition.getOneHundredNotes() >= oneHundredNotes){
            amount = amount-oneHundredNotes*100;
            composition.setOneHundredNotes(oneHundredNotes);
        }

        int fiftyNotes = amount/50;
        if(composition.getFiftyNotes() >= fiftyNotes){
            amount = amount-fiftyNotes*50;
            composition.setFiftyNotes(fiftyNotes);
        }

        int tenNotes = amount/10;
        if(composition.getTenNotes() >= tenNotes){
            amount = amount-tenNotes*10;
            composition.setTenNotes(tenNotes);
        }

        updateATMComposition(atm, composition);
        seeComposition(composition);
    }




}
