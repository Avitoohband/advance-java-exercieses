import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/*
this class represent an array of questions
 */

public class QuestionsHolder {


    private ArrayList<Question>  questionArray;

    private final int NUM_OF_ANSWERS = 4;



//----------------------------------------------------------------------------------------------------------------------
    //Ctor

    public QuestionsHolder(){
        this.questionArray = new ArrayList<Question>();
        this.updateQuestions();

    }
//----------------------------------------------------------------------------------------------------------------------
    // Reads questions and answers from a file
    // adds the question to a question object and it's four answers to it's answer array
    private void updateQuestions(){

        try{
            Scanner scan  = new Scanner(new File("trivia.txt"));
            String line;


            while(scan.hasNextLine()){

                line = scan.nextLine();
                Question q = new Question((line));
                this.questionArray.add(q);
                
                int i = 0 ;
                boolean rightAnswer = true;
                
                while (i < this.NUM_OF_ANSWERS){
                    line = scan.nextLine();
                    q.addAnswer(line , rightAnswer);

                    if(rightAnswer){
                        rightAnswer = false;
                    }

                    i++;
                }
                q.randomizeAnswers();
            }
            scan.close();
        }
        catch (IOException e){
            System.out.println("EXCEPTION! file could not be found!");

        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns a question , by a given number

    public Question getQuestion(int questionINdex){
        try {
            return this.questionArray.get(questionINdex);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("EXCEPTION! Index out of bounds! could not add question");
        }
        return new Question("Empty Question");
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the size of the array(or the number of questions)
    public int getsize(){
        return this.questionArray.size();
    }
//----------------------------------------------------------------------------------------------------------------------
}
