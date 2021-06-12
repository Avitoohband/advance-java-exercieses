import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

/*
this class represent the letters holder, which hold letters 'Buttons'
for the user to guess up letters from.

 */

public class LettersContainer  extends JPanel {


    private ArrayList<Letter> letters = new ArrayList<Letter>();

    private GridLayout containerLayout;

    private final int CONTAINER_COLS = 10;
    private final int CONTAINER_ROWS = 2;
    private final Character LETTERS_OFFSET = 'a';
    private final int NUMBERS_OF_LETTERS = 26;
    private final int CONTAINER_CAPACITY = 20;




    private String guessTheWord ;
//----------------------------------------------------------------------------------------------------------------------
    //Ctor

    public LettersContainer(String wordToGuess) {

        this.containerLayout = new GridLayout(this.CONTAINER_ROWS, this.CONTAINER_COLS);
        this.containerLayout.setVgap(10);
        this.guessTheWord= wordToGuess;



        this.setLayout(new GridLayout(this.CONTAINER_ROWS, this.CONTAINER_COLS));
        this.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 10));
        this.setLayout(this.containerLayout);



        this.loadContainer();
    }
//----------------------------------------------------------------------------------------------------------------------
    // Adds the letters to the container

    private void loadContainer() {

        this.buildContainer();

        for(Letter item :  letters){
            add(item);
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Builds the letters container

    private void buildContainer() {

        StringBuilder wordBuidler = new StringBuilder(this.guessTheWord.toLowerCase()); //
        ArrayList<Character> tiles = new ArrayList<Character>(); // to hold the chars from the given word to guess

        Random rand = new Random();
        int choosenWordLength = 0, randomLetterNumber = 0;

        // add the word to the letters container
        while (wordBuidler.length() > 0) {
            if (!tiles.contains(wordBuidler.charAt(0))) {  // make sure to get rid of duplicates

                tiles.add(wordBuidler.charAt(0));
                choosenWordLength++;
            }
            wordBuidler.deleteCharAt(0);
        }

        // add random characters to fill the rest tof the letter container
        for (/*using choosenWordLength*/ ; choosenWordLength < this.CONTAINER_CAPACITY; choosenWordLength++) {

            Character randomChar = this.LETTERS_OFFSET;

            do {
                randomChar = (char) (rand.nextInt(this.NUMBERS_OF_LETTERS) + this.LETTERS_OFFSET);
            }
            while (tiles.contains(randomChar));  // do nothing and random again
            tiles.add(randomChar); // add the random letter to the tiles array}
        }

        for (int i = 0; i < this.CONTAINER_CAPACITY; i++) {
            // grabs random letter from tiles and put it into the container

            randomLetterNumber = rand.nextInt(tiles.size());
            letters.add(new Letter(tiles.get(randomLetterNumber)));
            tiles.remove(randomLetterNumber);
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Add listener to all of the letters tiles
    public void addListeners(MouseListener lis){

        for (Letter item : letters){
            item.addLetterTileListener(lis);
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    // Removes all listeners from the letters
    public void removeListeners()
    {
        for(Letter item : letters){
            item.removeLetterTileListener();
        }
    }
//----------------------------------------------------------------------------------------------------------------------
}

