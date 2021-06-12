public class IllegalBalance extends Exception {
    // Exception for case of illegal balance(e.g going under 0$ or under a minimal amount to withdraw)
    public IllegalBalance(String msg){
        super(msg);
    }
//----------------------------------------------------------------------------------------------------------------------

}
