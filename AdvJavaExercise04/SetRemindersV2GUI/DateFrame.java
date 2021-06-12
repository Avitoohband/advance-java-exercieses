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
    private ActionListener lisMonthPrev;
    private ActionListener lisMonthNext;
    private ActionListener lisUpdate;
    private ActionListener lisExport;
    private ActionListener lisImport;
//----------------------------------------------------------------------------------------------------------------------

    private DayButton currentYearButton = null;
    private DayButton currentDayButton = null;
//----------------------------------------------------------------------------------------------------------------------

    private int pickedDay = 0;
    private int pickedYear = 0;
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
        pnlPickDate = new PickDatePanel(lisDay, lisYear, lisMonthNext , lisMonthPrev);
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
    //initialize the Actions Listeners for days, months and years buttons

    private void initializePickListeners(){

        lisDay = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                DayButton tempDayButton = (DayButton) e.getSource();
                pickedDay = tempDayButton.getDayNumber(); // updates current day picked
                currentDayButton = tempDayButton;
                pnlPickDate.reColorDaysBtns(); // de-mark all other days buttons
                tempDayButton.markedAsPressed(); // mark current day as pressed
                showTextReminder(); // update the reminder area to show the current date's reminder
            }
        };

        lisYear = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                DayButton tempYearButton = (DayButton) e.getSource();
                pickedYear = tempYearButton.getDayNumber(); // updates current year picked
                currentYearButton = tempYearButton;
                pnlPickDate.reColorYearsButtons(); // de-mark all other year buttons
                tempYearButton.markedAsPressed(); // mark current year as pressed
                showTextReminder(); // updates the reminder text area to show the current date's reminder
            }
        };
        lisMonthNext = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlPickDate.nextMonth();
                pickedMonth = pnlPickDate.getPickedMonth(); // updates current month picked
                showTextReminder(); // updates the reminder text area to show the current date's reminder

            }
        };

        lisMonthPrev = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlPickDate.prevMonth();
                pickedMonth = pnlPickDate.getPickedMonth(); // updates current month picked
                showTextReminder(); // updates the reminder text area to show the current date's reminder
            }
        };
    }
//----------------------------------------------------------------------------------------------------------------------
    // initialize user buttons ActionListeners

    private void initializeUserListeners(){
        lisUpdate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pickedDay == 0 || pickedYear == 0) { // if user didn't picked any date yet
                    Object[] options = {"OK!"};
                    JOptionPane.showOptionDialog(null,
                            "Please choose a valid Date (Day, Month, Year)","Date is not valid",
                            JOptionPane.PLAIN_MESSAGE,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]);
                }
                else{
                    updateReminder();
                }
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
