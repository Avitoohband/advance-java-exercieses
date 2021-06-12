
public class Answer  {
    /*
    This class represent an answer
    and if its the right answer
     */

    private boolean isCorrect;
    private String answer;
//----------------------------------------------------------------------------------------------------------------------
    //Ctor

    public Answer(String _answer, boolean _isCorrect){
        this.isCorrect = _isCorrect;
        this.answer = _answer;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns if its the right answer

    public boolean isRightAnswer(){
        return this.isCorrect;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns this answer

    public String getAnswer(){
        return this.answer;
    }
//----------------------------------------------------------------------------------------------------------------------
}
