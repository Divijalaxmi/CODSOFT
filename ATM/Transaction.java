import java.time.LocalDateTime;

public class Transaction {
    private long transactionId;
    private LocalDateTime dateOfTransaction;
    private TransactionType transactionType;
    private int transactionAmount;
    private Verdict verdict;
    private Location location;

    public Transaction(long transactionId, LocalDateTime dateOfTransaction, TransactionType transactionType, int transactionAmount, Verdict verdict, Location location){
        this.transactionId = transactionId;
        this.dateOfTransaction = dateOfTransaction;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.verdict = verdict;
        this.location = location;
    }

    public long getTransactionId(){
        return this.transactionId;
    }

    public LocalDateTime getDateOfTransaction(){
        return this.dateOfTransaction;
    }

    public TransactionType getTransactionType(){
        return this.transactionType;
    }

    public int getTransactionAmount(){
        return this.transactionAmount;
    }

    public Verdict getVerdict(){
        return this.verdict;
    }

    public Location getLocation(){
        return this.location;
    }
}
