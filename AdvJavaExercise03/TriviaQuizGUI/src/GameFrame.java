import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    //Question(with answers) array
    private QuestionsHolder questions = new QuestionsHolder();

//----------------------------------------------------------------------------------------------------------------------
    // Frame sizes
    private final int WIDTH = 650;
    private final int HEIGHT = 650;

//----------------------------------------------------------------------------------------------------------------------
    //finals for answers numbers
    private final int ANSWER_NUMBER_ONE = 0;
    private final int ANSWER_NUMBER_TWO = 1;
    private final int ANSWER_NUMBER_THREE = 2;
    private final int ANSWER_NUMBER_FOUR = 3;
//----------------------------------------------------------------------------------------------------------------------
    // finals for answers chars
    private final char ANSWER_CHAR_ONE = 'A';
    private final char ANSWER_CHAR_TWO = 'B';
    private final char ANSWER_CHAR_THREE = 'C';
    private final char ANSWER_CHAR_FOUR = 'D';
//----------------------------------------------------------------------------------------------------------------------

    private final int ZERO = 0;
    private final int SECOND = 1000;
    private final int TWO_SECONDS = 2000;
//----------------------------------------------------------------------------------------------------------------------
    //data values
    private char answer;
    private int index;
    private int correctAnswers = 0;
    private int totalQuestions = this.questions.getsize();
    private int result;
    private int seconds = 10;
//----------------------------------------------------------------------------------------------------------------------

    // finals for colors

    private Color BACKGROUND_LIGHT_BLACK;
    private Color BACKGROUND_BLACK ;
    private Color TEXT_COLOR_GREEN;
    private Color TEXT_COLOR_RED;
    private Color TEXT_COLOR_PURPLE;

//----------------------------------------------------------------------------------------------------------------------

    // holds the right answer for every question
    private char[] answers = new char[totalQuestions];
//----------------------------------------------------------------------------------------------------------------------
    // main texts
    private JTextField textField = new JTextField();
    private JTextArea textArea = new JTextArea();
//----------------------------------------------------------------------------------------------------------------------
    // end game texts
    private JTextField jtextNumberCorrect = new JTextField();
    private JTextField jtextScore = new JTextField();
//----------------------------------------------------------------------------------------------------------------------
    // answer buttons
    private JButton buttonA = new JButton();
    private JButton buttonB = new JButton();
    private JButton buttonC = new JButton();
    private JButton buttonD = new JButton();
    private JButton buttonRestartGame = new JButton();
    private JButton buttonQuit = new JButton();

    // theme buttons

    JButton buttonThemeDark = new JButton();
    JButton buttonThemeOrange = new JButton();
    JButton buttonThemeIndigo = new JButton();
    JButton buttonThemeSilver = new JButton();
//----------------------------------------------------------------------------------------------------------------------
    // answer labels
    private JLabel lblAnswerA = new JLabel();
    private JLabel lblAnswerB = new JLabel();
    private JLabel lblAnswerC = new JLabel();
    private JLabel lblAnswerD = new JLabel();
//----------------------------------------------------------------------------------------------------------------------
    // time labels
    private JLabel lblTime = new JLabel();
    private JLabel lblSeconds = new JLabel();
//----------------------------------------------------------------------------------------------------------------------
    // timer
    private Timer timer;
//----------------------------------------------------------------------------------------------------------------------

    // Ctor
    public GameFrame() {

        this.setTitle("Trivia Quiz!");
        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.chooseTheme();
        this.setVisible(true);
        this.setResizable(false);
    }

//----------------------------------------------------------------------------------------------------------------------
    // Adds all visual objects to the frame

    private void addToFrame() {
        this.add(textField);
        this.add(textArea);
        this.add(buttonA);
        this.add(buttonB);
        this.add(buttonC);
        this.add(buttonD);
        this.add(buttonRestartGame);
        this.add(buttonQuit);
        this.add(lblAnswerA);
        this.add(lblAnswerB);
        this.add(lblAnswerC);
        this.add(lblAnswerD);
        this.add(lblSeconds);
        this.add(lblTime);
    }
//----------------------------------------------------------------------------------------------------------------------
    // init all data values, and start a new game

    private void startNewGame(){

        this.remove(jtextNumberCorrect);
        this.remove(jtextScore);

        questions = null;
        questions = new QuestionsHolder();

        answer = ' ';
        index = 0;
        correctAnswers = 0;
        totalQuestions = this.questions.getsize();
        result = 0;
        seconds = 10;

        nextQuestion();
    }
//----------------------------------------------------------------------------------------------------------------------
    // init the timer, when get to zero
    // gives incorrect answer

    private void initTimer(){
        timer = new Timer(SECOND, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                seconds--;
                lblSeconds.setText(String.valueOf(seconds));
                if (seconds <= ZERO) {

                    incorrect();
                    displayAnswer();
                }
            }
        });
    }
//----------------------------------------------------------------------------------------------------------------------
    // init result's texts
    private void initResultsLabels() {
        jtextNumberCorrect.setBounds(225, 225, 200, 100);
        jtextNumberCorrect.setBackground(BACKGROUND_BLACK);
        jtextNumberCorrect.setForeground(TEXT_COLOR_GREEN);
        jtextNumberCorrect.setFont(new Font("MV Boli", Font.BOLD, 50));
        jtextNumberCorrect.setBorder(BorderFactory.createBevelBorder(1));
        jtextNumberCorrect.setHorizontalAlignment(JTextField.CENTER);
        jtextNumberCorrect.setEditable(false);

        jtextScore.setBounds(225, 325, 200, 100);
        jtextScore.setBackground(BACKGROUND_BLACK);
        jtextScore.setForeground(TEXT_COLOR_GREEN);
        jtextScore.setFont(new Font("MV Boli", Font.BOLD, 50));
        jtextScore.setBorder(BorderFactory.createBevelBorder(1));
        jtextScore.setHorizontalAlignment(JTextField.CENTER);
        jtextScore.setEditable(false);
    }
//----------------------------------------------------------------------------------------------------------------------
    // init timer label

    private void initTimeLabel() {
        lblTime.setBounds(535, 457, 100, 25);
        lblTime.setBackground(BACKGROUND_LIGHT_BLACK);
        lblTime.setForeground(TEXT_COLOR_RED);
        lblTime.setFont(new Font("MV Boli", Font.PLAIN, 20));
        lblTime.setHorizontalAlignment(JTextField.CENTER);
        lblTime.setText("Timer");
    }
//----------------------------------------------------------------------------------------------------------------------
    //init the seconds label

    private void initSecondsLabel() {
        lblSeconds.setBounds(535, 510, 100, 100);
        lblSeconds.setBackground(BACKGROUND_BLACK);
        lblSeconds.setForeground(TEXT_COLOR_RED);
        lblSeconds.setFont(new Font("MV Boli", Font.BOLD, 60));
        lblSeconds.setBorder(BorderFactory.createBevelBorder(1));
        lblSeconds.setOpaque(true);
        lblSeconds.setHorizontalAlignment(JTextField.CENTER);
        lblSeconds.setText(String.valueOf(seconds));
    }
//----------------------------------------------------------------------------------------------------------------------
    // init all answers labels

    private void initAnswersLabels() {
        lblAnswerA.setBounds(125, 100, 500, 100);
        lblAnswerA.setBackground(BACKGROUND_LIGHT_BLACK);
        lblAnswerA.setForeground(TEXT_COLOR_GREEN);
        lblAnswerA.setFont(new Font("MV Boli", Font.PLAIN, 35));


        lblAnswerB.setBounds(125, 200, 500, 100);
        lblAnswerB.setBackground(BACKGROUND_LIGHT_BLACK);
        lblAnswerB.setForeground(TEXT_COLOR_GREEN);
        lblAnswerB.setFont(new Font("MV Boli", Font.PLAIN, 35));


        lblAnswerC.setBounds(125, 300, 500, 100);
        lblAnswerC.setBackground(BACKGROUND_LIGHT_BLACK);
        lblAnswerC.setForeground(TEXT_COLOR_GREEN);
        lblAnswerC.setFont(new Font("MV Boli", Font.PLAIN, 35));


        lblAnswerD.setBounds(125, 400, 500, 100);
        lblAnswerD.setBackground(BACKGROUND_LIGHT_BLACK);
        lblAnswerD.setForeground(TEXT_COLOR_GREEN);
        lblAnswerD.setFont(new Font("MV Boli", Font.PLAIN, 35));
    }
//----------------------------------------------------------------------------------------------------------------------
    // init all buttons

    private void initButtons() {
        buttonA.setBounds(0, 100, 100, 100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonA.setText("A");
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);

        buttonB.setBounds(0, 200, 100, 100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonB.setText("B");
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);

        buttonC.setBounds(0, 300, 100, 100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonC.setText("C");
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);

        buttonD.setBounds(0, 400, 100, 100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonD.setText("D");
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);


        buttonRestartGame.setBounds(125, 550, 200, 50);
        buttonRestartGame.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonRestartGame.setBackground(BACKGROUND_BLACK);
        buttonRestartGame.setForeground(TEXT_COLOR_PURPLE);
        buttonRestartGame.setText("New Game!");
        buttonRestartGame.setFocusable(false);
        buttonRestartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               startNewGame();
            }
        });

        buttonQuit.setBounds(350, 550, 100, 50);
        buttonQuit.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonQuit.setBackground(BACKGROUND_BLACK);
        buttonQuit.setForeground(TEXT_COLOR_RED);
        buttonQuit.setText("Quit!");
        buttonQuit.setFocusable(false);
        buttonQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
//----------------------------------------------------------------------------------------------------------------------
    //  init main text area

    private void initTextArea() {
        textArea.setBounds(0, 50, 650, 50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(BACKGROUND_BLACK);
        textArea.setForeground(TEXT_COLOR_GREEN);
        textArea.setFont(new Font("MV Boli", Font.BOLD, 25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
    }
//----------------------------------------------------------------------------------------------------------------------
    //  init main text field


    private void initTextField() {
        textField.setBounds(0, 0, 650, 50);
        textField.setBackground(BACKGROUND_BLACK);
        textField.setForeground(TEXT_COLOR_GREEN);
        textField.setFont(new Font("MV Boli", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);
    }

//----------------------------------------------------------------------------------------------------------------------
    // load new question on the screen
    // updates question text
    // updates answers texts and it's buttons

    private void nextQuestion() {
        timer.stop();

        if (index >= this.questions.getsize()) {
            this.result();
        } else {
            Question tempQuestion = this.questions.getQuestion(index);
            textField.setText("Question No` : " + (index + 1));
            textArea.setText(tempQuestion.getQuestion());
            lblAnswerA.setText(tempQuestion.getAnswer(ANSWER_NUMBER_ONE).getAnswer());
            lblAnswerB.setText(tempQuestion.getAnswer(ANSWER_NUMBER_TWO).getAnswer());
            lblAnswerC.setText(tempQuestion.getAnswer(ANSWER_NUMBER_THREE).getAnswer());
            lblAnswerD.setText(tempQuestion.getAnswer(ANSWER_NUMBER_FOUR).getAnswer());

            if (tempQuestion.getAnswer(ANSWER_NUMBER_ONE).isRightAnswer()) answers[index] = ANSWER_CHAR_ONE;
            if (tempQuestion.getAnswer(ANSWER_NUMBER_TWO).isRightAnswer()) answers[index] = ANSWER_CHAR_TWO;
            if (tempQuestion.getAnswer(ANSWER_NUMBER_THREE).isRightAnswer()) answers[index] = ANSWER_CHAR_THREE;
            if (tempQuestion.getAnswer(ANSWER_NUMBER_FOUR).isRightAnswer()) answers[index] = ANSWER_CHAR_FOUR;

            buttonA.setEnabled(true);
            buttonB.setEnabled(true);
            buttonC.setEnabled(true);
            buttonD.setEnabled(true);

            lblSeconds.setText(String.valueOf(seconds));

            timer.start();
        }
    }

//----------------------------------------------------------------------------------------------------------------------
    //load the end game screen, shows the results

    private void result() {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        textField.setText("Results!");
        textArea.setText("");

        lblAnswerA.setText("");
        lblAnswerB.setText("");
        lblAnswerC.setText("");
        lblAnswerD.setText("");

        jtextNumberCorrect.setText(correctAnswers + "/" + totalQuestions);
        jtextScore.setText(String.valueOf(result));

        this.add(jtextNumberCorrect);
        this.add(jtextScore);

    }

//----------------------------------------------------------------------------------------------------------------------
    // Highlights the right answer, makes all wrong answer red and the right one green
    // after two seconds calls next question method.

    private void displayAnswer() {

        timer.stop();

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (ANSWER_CHAR_ONE != answers[index]) lblAnswerA.setForeground(TEXT_COLOR_RED);
        if (ANSWER_CHAR_TWO != answers[index]) lblAnswerB.setForeground(TEXT_COLOR_RED);
        if (ANSWER_CHAR_THREE != answers[index]) lblAnswerC.setForeground(TEXT_COLOR_RED);
        if (ANSWER_CHAR_FOUR != answers[index]) lblAnswerD.setForeground(TEXT_COLOR_RED);

        Timer pause = new Timer(TWO_SECONDS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lblAnswerA.setForeground(TEXT_COLOR_GREEN);
                lblAnswerB.setForeground(TEXT_COLOR_GREEN);
                lblAnswerC.setForeground(TEXT_COLOR_GREEN);
                lblAnswerD.setForeground(TEXT_COLOR_GREEN);

                answer = ' ';
                seconds = 10;
                lblSeconds.setText(String.valueOf(seconds));

                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);

                index++;

                nextQuestion();
            }
        });

        pause.setRepeats(false);
        pause.start();

    }
//----------------------------------------------------------------------------------------------------------------------
    // Correct answer situation
    // updates number of right answers so far and the score( + 10 points )

    private void correct(){
        correctAnswers++;
        result += 10;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Wrong answer or time is over situation
    // updates the score ( - 5 points)
    // score cannot go under 0
    private void incorrect(){
        System.out.println(result);
        result -= 5;
        if (result < 0 ){
            result = 0;
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Checks if the picked answer is the right one, if it is
    // calls correct method
    // else calls incorrect method
    // then calls display results


    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = ANSWER_CHAR_ONE;
            if (answer == answers[index]) {

                correct();
            }
            else {
                incorrect();
            }
        }
        else if (e.getSource() == buttonB) {
            answer = ANSWER_CHAR_TWO;
            if (answer == answers[index]) {
                correct();

            }
            else {
                incorrect();
            }
        }
        else if (e.getSource() == buttonC) {
            answer = ANSWER_CHAR_THREE;
            if (answer == answers[index]) {

                correct();

            }
            else {
                incorrect();
            }
        }
       else  if (e.getSource() == buttonD) {
            answer = ANSWER_CHAR_FOUR;
            if (answer == answers[index]) {

                correct();
            }
            else {
                incorrect();
            }
        }
        displayAnswer();
    }
//----------------------------------------------------------------------------------------------------------------------
    // all of this methods are optional and not part of the exercise!
    // so there wont be much of a description
    // general idea, is to let the user to choose a theme for his game.


    private void finishGamePrep(){
        addToFrame();
        this.setVisible(true);
        startNewGame();
    }

//----------------------------------------------------------------------------------------------------------------------
    private void initGameBoard(){
        this.getContentPane().setBackground(BACKGROUND_LIGHT_BLACK);

        initTextField();
        initTextArea();
        initButtons();
        initAnswersLabels();
        initSecondsLabel();
        initTimeLabel();
        initResultsLabels();
        initTimer();

        finishGamePrep();

    }
    private final int BTN_THM_WIDTH = 324;
    private final int BTN_THM_HEIGHT = 324;
//----------------------------------------------------------------------------------------------------------------------
    private void darkTheme(){

        BACKGROUND_LIGHT_BLACK = new Color(50, 50, 50);
        BACKGROUND_BLACK = new Color(25, 25, 25);
        TEXT_COLOR_GREEN = new Color(25, 255, 0);
        TEXT_COLOR_RED = new Color(255, 0, 0);
        TEXT_COLOR_PURPLE = new Color(80,25,255);

        removeThemeButtons();
        initGameBoard();

    }
//----------------------------------------------------------------------------------------------------------------------
    private void orangeTheme(){
        BACKGROUND_LIGHT_BLACK = new Color(255,165,0);
        BACKGROUND_BLACK = new Color(255,140,0);
        TEXT_COLOR_GREEN = new Color(255,255,255);
        TEXT_COLOR_RED = new Color(0,0,0);
        TEXT_COLOR_PURPLE = new Color(255,255,255);

        removeThemeButtons();
        initGameBoard();



    }
//----------------------------------------------------------------------------------------------------------------------
    private void indigoTheme(){

        BACKGROUND_LIGHT_BLACK = new Color(72,61,139);
        BACKGROUND_BLACK = new Color(75,0,130);
        TEXT_COLOR_GREEN = new Color(219,112,147);
        TEXT_COLOR_RED = new Color(128,0,0);
        TEXT_COLOR_PURPLE = new Color(173,255,47);

        removeThemeButtons();
        initGameBoard();



    }
//----------------------------------------------------------------------------------------------------------------------
    private void silverTheme(){

        BACKGROUND_LIGHT_BLACK = new Color(192,192,192);
        BACKGROUND_BLACK = new Color(211,211,211);
        TEXT_COLOR_GREEN = new Color(184,134,11);
        TEXT_COLOR_RED = new Color(0,0,0);
        TEXT_COLOR_PURPLE = new Color	(0,100,0);

        removeThemeButtons();
        initGameBoard();


    }
//----------------------------------------------------------------------------------------------------------------------

    public void chooseTheme(){


        buttonThemeDark.setBounds(0, 0, BTN_THM_WIDTH, BTN_THM_HEIGHT);
        buttonThemeDark.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonThemeDark.setBackground(new Color(0,0,0));
        buttonThemeDark.setForeground(new Color(25, 255, 0));
        buttonThemeDark.setBorder(BorderFactory.createBevelBorder(1));
        buttonThemeDark.setText("Dark Mode");
        buttonThemeDark.setFocusable(false);
        buttonThemeDark.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                darkTheme();

            }
        });

        buttonThemeOrange.setBounds(0, 325, BTN_THM_WIDTH, BTN_THM_HEIGHT);
        buttonThemeOrange.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonThemeOrange.setBackground(new Color(255,140,0));
        buttonThemeOrange.setForeground(new Color(255, 255, 255));
        buttonThemeOrange.setBorder(BorderFactory.createBevelBorder(1));
        buttonThemeOrange.setText("Orange Mode");
        buttonThemeOrange.setFocusable(false);
        buttonThemeOrange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orangeTheme();

            }
        });

        buttonThemeIndigo.setBounds(325, 0,BTN_THM_WIDTH,BTN_THM_HEIGHT );
        buttonThemeIndigo.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonThemeIndigo.setBackground(new Color(75,0,130));
        buttonThemeIndigo.setForeground(new Color(219,112,147));
        buttonThemeIndigo.setBorder(BorderFactory.createBevelBorder(1));
        buttonThemeIndigo.setText("Indigo Mode");
        buttonThemeIndigo.setFocusable(false);
        buttonThemeIndigo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indigoTheme();

            }
        });

        buttonThemeSilver.setBounds(325, 325, BTN_THM_WIDTH, BTN_THM_HEIGHT);
        buttonThemeSilver.setFont(new Font("MV Boli", Font.BOLD, 25));
        buttonThemeSilver.setBackground(new Color(192,192,192));
        buttonThemeSilver.setForeground(new Color(184,134,11));
        buttonThemeSilver.setBorder(BorderFactory.createBevelBorder(1));
        buttonThemeSilver.setText("Silver Mode");
        buttonThemeSilver.setFocusable(false);
        buttonThemeSilver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                silverTheme();
            }


        });

        this.add(buttonThemeDark);
        this.add(buttonThemeOrange);
        this.add(buttonThemeIndigo);
        this.add(buttonThemeSilver);

    }
//----------------------------------------------------------------------------------------------------------------------
    private void removeThemeButtons(){
        this.remove(buttonThemeDark);
        this.remove(buttonThemeOrange);
        this.remove(buttonThemeIndigo);
        this.remove(buttonThemeSilver);

    }
//----------------------------------------------------------------------------------------------------------------------
}
