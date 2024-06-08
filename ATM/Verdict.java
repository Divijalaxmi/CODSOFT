public enum Verdict {
    SUCCESS("Success"),
    FAILURE("Failure"),
    OUT_OF_MONEY("Out of Money"),
    SOFTWARE_ERROR("Software Error"),
    HARDWARE_ERROR("Hardware Error"),
    MAX_LIMIT("Exceed maximum withdrawal limit");

    private String val;

    Verdict(String val){
        this.val = val;
    }

    public String getVal(){
        return this.val;
    }
}
