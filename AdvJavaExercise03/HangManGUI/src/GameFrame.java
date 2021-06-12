import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/*
    this class represent game logic
    extends frame to connect all visuals
 */
public class GameFrame extends JFrame {

    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private final int MAX_INCORRECT = 6;


    private Hangman lblHangman;
    private LettersContainer letters;

    private MyWords words;

    private JLabel lblwordToShow;
    private JLabel lblIncorrect;

    private String wordToGuess;
    private StringBuilder wordToShow ;

    private int currentIncorrect;

//----------------------------------------------------------------------------------------------------------------------
    // Ctor
    public GameFrame(){


        this.setSize(this. WIDTH, this.HEIGHT );
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("Hang-man!");
        this.setResizable(false);
        this.words = new MyWords();
        this.startNewGame();
    }


//----------------------------------------------------------------------------------------------------------------------
    // Stars a new game
    private void startNewGame(){

        this.currentIncorrect = 0 ;
        this.lblwordToShow = new JLabel("Word is: ");
        this.lblIncorrect = new JLabel("Incorrect: " + this.currentIncorrect +"\\" + this.MAX_INCORRECT);

        this.wordToGuess = new String();
        this.wordToShow = new StringBuilder();

        this.updateWordToGuess();
        this.addTexts();
        this.addLetters();
        this.addHangman();

        setVisible(true);



    }
//----------------------------------------------------------------------------------------------------------------------
    // Adds the hangman panel to the frame

    private void addHangman() {
        JPanel hmPanel = new JPanel();

        this.lblHangman = new Hangman();
        hmPanel.add(this.lblHangman);
        this.add(hmPanel , BorderLayout.CENTER);

    }
//----------------------------------------------------------------------------------------------------------------------
    // Adds the letter container to the frame

    private void addLetters() {
        this.letters = new LettersContainer(this.wordToGuess);
        this.letters.addListeners(new TileListener());
        this.add(this.letters, BorderLayout.SOUTH);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Adds text panel to the frame, which holds the words and incorrect number presentation

    private void addTexts() {

        JPanel texts = new JPanel();
        texts.setLayout(new GridLayout(1,2));

        this.initiatlizeWordToShow();

        texts.add(this.lblwordToShow);
        texts.add(this.lblIncorrect);

        this.add(texts, BorderLayout.NORTH);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Gets a new word from the data

    private void updateWordToGuess(){

        this.wordToGuess = this.words.getRandomWord();

        if(this.wordToGuess.equals("")){
            System.out.println("There are no more words in the list!");
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    // Initialize the label that shows the word to be underscores at the same length

    private void initiatlizeWordToShow(){

        this.wordToShow.append(this.wordToGuess.replaceAll(".", "_"));
        this.lblwordToShow.setText(this.lblwordToShow.getText() + this.wordToShow.toString() +
                "(Length is: " + this.wordToGuess.length()+")");


    }

//----------------------------------------------------------------------------------------------------------------------
    // Pops up a new game dialog
private void newGameDialog()
{
    int option  = JOptionPane.showConfirmDialog(null,
            "Word was :" + this.wordToGuess
             + "\nDo you want to start another one?",
            "Start a new game?" ,
            JOptionPane.YES_NO_OPTION);

    if(option == JOptionPane.YES_OPTION) {
        this.startNewGame();
    }
    else{
        System.exit(0);
    }




}
//----------------------------------------------------------------------------------------------------------------------
    // restart game method, remove all listeners and ask to start a new game

    private void winOrLose(){
        letters.removeListeners();
        newGameDialog();
    }
//----------------------------------------------------------------------------------------------------------------------
    /*
     * a class to add option for the user to click on the letters tiles
     * to pick a desired letter
     * */

    private class TileListener implements MouseListener {

//----------------------------------------------------------------------------------------------------------------------

        // Checks the source type, if it matches - checks if the letters exist in the word
        // if it does, updates word to show a checks if the word completed.
        // if so, the user wins
        // if it doesn't match - updates incorrect checks fo a lose situation (if user has reached max incorrect)

        @Override
        public void mousePressed(MouseEvent e) {

            Object letterSourse = e.getSource();

            if (letterSourse instanceof Letter){

                Letter choosenLetter = (Letter) letterSourse;
                char c = choosenLetter.guessLetter();
                boolean correctLetter = false;

                int i = 0 ;

                while ((i = wordToGuess.toLowerCase().indexOf(c, i)) != -1 ){
                    wordToShow.setCharAt(i, wordToGuess.charAt(i));
                    correctLetter = true;
                    i++;
                }

                if(correctLetter){
                    lblwordToShow.setText("Word is: " + wordToShow.toString()+ "(Length is: " + wordToGuess.length()+")");
//                    System.out.println(wordToShow);

                    if(wordToShow.toString().equals(wordToGuess)){
                        lblHangman.win();
                        winOrLose();
                    }
                }

                else{
                    currentIncorrect++;
                    lblIncorrect.setText("Incorrect: " + currentIncorrect +"\\" + MAX_INCORRECT);

                    if(currentIncorrect >= MAX_INCORRECT ){
                        lblHangman.lose();
                        winOrLose();
                    }

                    else{
                        lblHangman.nextImage(currentIncorrect);
                    }
                }
            }
        }
//----------------------------------------------------------------------------------------------------------------------

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
//----------------------------------------------------------------------------------------------------------------------

}
