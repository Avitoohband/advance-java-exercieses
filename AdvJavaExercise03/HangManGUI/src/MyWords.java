import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/*
this class read a bunch of words from a text file,
add to an array and gives one random word evey time
 */
public class MyWords {

    private ArrayList<String> myLIst = new ArrayList<String>();;

//----------------------------------------------------------------------------------------------------------------------

    // Ctor

    public MyWords(){

        File file = new File ("words.txt");

        try{
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()){
               myLIst.add(scan.nextLine());
            }

        }
        catch (FileNotFoundException e){
            System.out.println("Excetion: File not found!");

        }

    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns one random word, then removes it from the array

    public String getRandomWord(){
        Random rand = new Random();

        String word = "";

            if (this.myLIst.size() == 0)
            {
                System.out.println("List is empty!");
            }
            else
            {

                int wordIndex = rand.nextInt(this.myLIst.size());
                word = myLIst.get(wordIndex);
                this.myLIst.remove(wordIndex);

            }
        return word;
    }

//----------------------------------------------------------------------------------------------------------------------
}
