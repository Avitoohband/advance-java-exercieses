import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGui extends JFrame implements ActionListener{
    /*
    This class represent the Client GUI Interface
     */

    private final Font FONT = new Font("MV Boly" , Font.BOLD, 20);
    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    JComboBox jcomboFrom, jcomboTo;
    JTextField jtfieldCurrentAmount, jtfieldReturningAmount;
    JButton jbConvert;
    JButton jbQuit;


    public ClientGui(){
        setTitle("Online Exchanger!");
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(Color.BLACK);
        setLayout(new GridLayout(3,2));
        initializeTextFields();
        initializeComboBoxes();
        initializeButtons();
        addObjectsToFrame();

        setVisible(true);
    }
    // Adds object to the frame
    private void addObjectsToFrame(){
        add(jcomboFrom);
        add(jcomboTo);
        add(jtfieldCurrentAmount);
        add(jtfieldReturningAmount);
        add(jbConvert);
        add(jbQuit);
    }
    // Initializes the currency types combo boxes
    private void initializeComboBoxes(){

        String[] currenyTypes = {"NIS", "$" ,"EUR"};
        jcomboFrom = new JComboBox(currenyTypes);
        jcomboTo = new JComboBox(currenyTypes);

        jcomboFrom.setBackground(Color.white);
        jcomboFrom.setForeground(Color.black);
        jcomboFrom.setFont(FONT);

        jcomboTo.setBackground(Color.white);
        jcomboTo.setForeground(Color.black);
        jcomboTo.setFont(FONT);
    }
    // Initializes the text field to declare desired amount to exchange and receive amount of exchanges back
    private void initializeTextFields(){
        jtfieldCurrentAmount = new JTextField("Current Amount");
        jtfieldReturningAmount = new JTextField("Return Amount");

        jtfieldCurrentAmount.setSize(150 , 80);
        jtfieldCurrentAmount.setFont(FONT);
        jtfieldCurrentAmount.setBackground(Color.white);
        jtfieldCurrentAmount.setForeground(Color.black);

        jtfieldReturningAmount.setSize(150 , 80);
        jtfieldReturningAmount.setFont(FONT);
        jtfieldReturningAmount.setEditable(false);
        jtfieldReturningAmount.setBackground(Color.white);
        jtfieldReturningAmount.setForeground(Color.black);
    }
    // Setter for the returning amount text field
    public void setReturningAmount(String amount){
        jtfieldReturningAmount.setText(amount);
    }
    // Initializes Exchange and Quit buttons
    private void initializeButtons(){
        jbConvert = new JButton("Exchange");
        jbConvert.setSize(150,80);
        jbConvert.setBackground(Color.GREEN);
        jbConvert.setForeground(Color.RED);
        jbConvert.setFont(FONT);
        jbConvert.addActionListener(this);

        jbQuit = new JButton("QUIT!");
        jbQuit.setSize(150,80);
        jbQuit.setBackground(Color.GREEN);
        jbQuit.setForeground(Color.RED);
        jbQuit.setFont(FONT);
        jbQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    // Gets the amount of cash to exchange and the types of currency and
    // start a new Thread to make connection with the server
    @Override
    public void actionPerformed(ActionEvent e) {
        double amount = Double.parseDouble(jtfieldCurrentAmount.getText());
        int from = jcomboFrom.getSelectedIndex() + 1;
        int to = jcomboTo.getSelectedIndex() + 1;
        Request tempRequest = new Request(amount, from, to);
        new Client(this, "127.0.0.1" ,tempRequest).start();
    }

    public static void main(String[] args){
        new ClientGui();
    }
}
