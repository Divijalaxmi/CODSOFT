import java.util.*;

public class Atm {
    private String atmId;
    private Location location;
    private CurrencyComposition currencyComposition;
    private long balance;
    private Condition condition;
    private List<Transaction> transactionList = new ArrayList<>();

    public Atm(String atmId, Location location, CurrencyComposition currencyComposition){
        this.atmId = atmId;
        this.location = location;
        this.currencyComposition = currencyComposition;
        condition = Condition.WORKING;
        this.balance = getBalance(currencyComposition);
    }

    private long getBalance(CurrencyComposition currencyComposition){
        return currencyComposition.getFiveHundredNotes()*500 + currencyComposition.getTwoHundredNotes()*200 + 
        currencyComposition.getOneHundredNotes()*100 + currencyComposition.getFiftyNotes()*50 + currencyComposition.getTenNotes()*10;
    }

    public String getAtmId(){
        return this.atmId;
    }

    public Location getLocation(){
        return this.location;
    }

    public long getBalance(){
        return this.balance;
    }

    public Condition getCondition(){
        return this.condition;
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public void setCurrencyComposition(CurrencyComposition currencyComposition){
        this.currencyComposition = currencyComposition;
    }

    public void setBalance(long balance){
        this.balance = balance;
    }

    public List<Transaction> getTransactions(){
        return this.transactionList;
    }

    public CurrencyComposition getCurrencyComposition(){
        return this.currencyComposition;
    }


}
