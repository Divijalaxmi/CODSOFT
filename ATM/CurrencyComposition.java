public class CurrencyComposition {
    private int fiveHundredNotes;
    private int twoHundredNotes;
    private int oneHundredNotes;
    private int fiftyNotes;
    private int tenNotes;

    CurrencyComposition(int fiveHundred, int twoHundred, int oneHundred, int fifty, int ten){
        this.fiveHundredNotes = fiveHundred;
        this.twoHundredNotes = twoHundred;
        this.oneHundredNotes = oneHundred;
        this.fiftyNotes = fifty;
        this.tenNotes = ten;
    }

    public int getFiveHundredNotes(){
        return this.fiveHundredNotes;
    }

    public int getTwoHundredNotes(){
        return this.twoHundredNotes;
    }

    public void setOneHundredNotes(int notes){
        this.oneHundredNotes = this.oneHundredNotes-notes;
    }

    public void setFiftyNotes(int notes){
        this.fiftyNotes = this.fiftyNotes-notes;
    }

    public void setTenNotes(int notes){
        this.tenNotes = this.tenNotes-notes;
    }

    public void setFiveHundredNotes(int notes){
        this.fiveHundredNotes = this.fiveHundredNotes-notes;
    }

    public void setTwoHundredNotes(int notes){
        this.twoHundredNotes = this.twoHundredNotes-notes;
    }

    public int getOneHundredNotes(){
        return this.oneHundredNotes;
    }

    public int getFiftyNotes(){
        return this.fiftyNotes;
    }

    public int getTenNotes(){
        return this.tenNotes;
    }
}
