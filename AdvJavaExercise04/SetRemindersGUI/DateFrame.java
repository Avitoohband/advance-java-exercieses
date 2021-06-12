import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class DateFrame extends JFrame {

    /*
    this class represent the main frame and holds most of the the functionality of the program
     */

    private final int WIDTH = 650;
    private final int HEIGHT = 650;
//----------------------------------------------------------------------------------------------------------------------

    private HashMap<Date, String> hmDateReminders= new HashMap<Date,String>();
//----------------------------------------------------------------------------------------------------------------------

    private PickDatePanel pnlPickDate;
    private UserButtonsPanel pnlUser;
    private JTextArea jTextAreaRemider;
//----------------------------------------------------------------------------------------------------------------------

    private ActionListener lisDay;
    private ActionListener lisYear;
    private ActionListener lisMonth;
    private ActionListener lisUpdate;
    private ActionListener lisExport;
    private ActionListener lisImport;

//----------------------------------------------------------------------------------------------------------------------

    private int pickedDay = 1;
    private int pickedYear = 2019;
    private int pickedMonth = 1;

//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public DateFrame (){

        setTitle("Date set Reminders");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);

        initializePickListeners();
        initializeUserListeners();
        pnlPickDate = new PickDatePanel(lisDay, lisMonth, lisYear);
        pnlUser = new UserButtonsPanel(lisUpdate, lisExport, lisImport);
        initializeReminderText();

        add(pnlPickDate, BorderLayout.NORTH);


        add(pnlUser , BorderLayout.SOUTH);
        add(jTextAreaRemider , BorderLayout.CENTER);
        setVisible(true);
    }


//----------------------------------------------------------------------------------------------------------------------
    //Initialize the text reminder area

    private void initializeReminderText() {
        jTextAreaRemider = new JTextArea();
        jTextAreaRemider.setLineWrap(true);
        jTextAreaRemider.setWrapStyleWord(true);
        jTextAreaRemider.setBackground(Color.GRAY);
        jTextAreaRemider.setForeground(Color.WHITE);
        jTextAreaRemider.setFont(new Font("MV Boli", Font.BOLD, 20));
        jTextAreaRemider.setBorder(BorderFactory.createBevelBorder(1));
    }
//----------------------------------------------------------------------------------------------------------------------
    //initialize the Actions Listeners for days, months and years JComboBoxes

    private void initializePickListeners(){

        lisDay = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() instanceof JComboBox){
                    JComboBox tempJC = (JComboBox) e.getSource();
                    pickedDay = Integer.valueOf(String.valueOf(tempJC.getSelectedItem()));  // updates current day picked
                    showTextReminder(); // updates the reminder text area to show the current date's reminder
                }
            }
        };

        lisYear = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {


                if(e.getSource() instanceof JComboBox){
                    JComboBox tempJC = (JComboBox) e.getSource();
                    pickedYear = tempJC.getSelectedIndex() + 2019;  // updates current year picked
                    showTextReminder(); // updates the reminder text area to show the current date's reminder
                }
            }
        };

        lisMonth = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                if(e.getSource() instanceof JComboBox){
                    JComboBox tempJC = (JComboBox) e.getSource();
                    pickedMonth = tempJC.getSelectedIndex() + 1;  // updates current month picked
                    showTextReminder(); // updates the reminder text area to show the current date's reminder
                }
            }
        };
    }
//----------------------------------------------------------------------------------------------------------------------
    // initialize user buttons ActionListeners

    private void initializeUserListeners(){
        lisUpdate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    updateReminder();

            }
        };

        lisExport = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exportToFIle();
            }
        };

        lisImport = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                importFromAFile();
            }
        };
    }
//----------------------------------------------------------------------------------------------------------------------
    // update the reminder of the current date from the text area

    private void updateReminder(){
        try{
            Date tempDate = getCurrentDayObject();

            if(hmDateReminders.containsKey(tempDate)){ // updates a date if alreay exist
                hmDateReminders.replace(tempDate, jTextAreaRemider.getText());

            }
            else{
                hmDateReminders.put( tempDate, jTextAreaRemider.getText()); // adding new date with the reminder
            }
        }
        catch (NullPointerException e){
            System.out.println("EXCEPTION! Date is not valid");
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Makes arrays list of the dates and reminders and call for a function to export to a file

    private void exportToFIle(){
        if(FileOperator.createExportFile()){
            ArrayList<Date> tempDateList = new ArrayList<Date> (hmDateReminders.keySet());
            ArrayList<String> rems = new ArrayList<String>();
            int i = 0;
            while(i < tempDateList.size()){
                rems.add(hmDateReminders.get(tempDateList.get(i++)));
            }
            FileOperator.insertRemindersToFile(tempDateList,rems);
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Calls a function to import data from a file

    private void importFromAFile(){
        HashMap<Date, String>tempHmDateReminders = FileOperator.importFromAFile();
        if (tempHmDateReminders == null) {
            return;
        }
        hmDateReminders = tempHmDateReminders;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Pulls from the HashMap the current date's reminder, if there is one

    private void showTextReminder(){

        try{
            Date tempDate = getCurrentDayObject();

            if(hmDateReminders.containsKey(tempDate)){
                jTextAreaRemider.setText(hmDateReminders.get(tempDate));

            }
            else{
                jTextAreaRemider.setText("");
            }
        }
        catch (NullPointerException e){
            System.out.println("EXCEPTION! Date is not valid");
        }

    }
//----------------------------------------------------------------------------------------------------------------------
    // Copy C-tor

    private Date getCurrentDayObject(){
        return new Date(pickedDay, pickedMonth, pickedYear);
    }
//----------------------------------------------------------------------------------------------------------------------
}
