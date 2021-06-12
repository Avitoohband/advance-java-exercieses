import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
This class represent a Question object
holds the question it self it's optional answers
 */

public class Question {

    private String question;
    private ArrayList<Answer> answers;


//----------------------------------------------------------------------------------------------------------------------
    //Ctor

    public Question(String q){

        this.answers = new ArrayList<Answer>();
        this.question = q;

    }
//----------------------------------------------------------------------------------------------------------------------
    // Adds an answer to the answers array

    public void addAnswer(String ans, boolean isCorrect){

        this.answers.add(new Answer(ans, isCorrect));

    }
//----------------------------------------------------------------------------------------------------------------------
    // Randomizes the order of the answers

      public void randomizeAnswers(){
        ArrayList<Answer> tempAnswersArray  = new ArrayList<Answer>(this.answers);
          Random rand = new Random();

        Collections.copy(tempAnswersArray, this.answers);

        this.answers.clear();

        while (tempAnswersArray.size() >= 0){
            int index = rand.nextInt(tempAnswersArray.size());
            this.answers.add(tempAnswersArray.get(index));
            tempAnswersArray.remove(index);

            if(tempAnswersArray.size() == 0 ){
                break;
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the question

    public String getQuestion(){
        return this.question;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the desired answers, given by number
    public Answer getAnswer(int answerIndex){

        try{
            return this.answers.get(answerIndex);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println(" EXCEPTION! Index out of bounds! could not add answer");
        }
        return new Answer("Empty Answer", false);
    }

//----------------------------------------------------------------------------------------------------------------------
}
