import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DaysPanel extends JPanel {
    /*
    This class represent the panel to hold the days and years
     */

    private ArrayList<DayButton> lstDays= new ArrayList<DayButton>();
//----------------------------------------------------------------------------------------------------------------------

    private final int WIDTH = 650;
    private final int HEIGHT = 250;
//----------------------------------------------------------------------------------------------------------------------

    private final int ROWS = 3;
    private final int COLS = 11;
    private final int MAX_DAYS = 31;
//----------------------------------------------------------------------------------------------------------------------

    private static DayButton currentDayButton = null;
    private static DayButton currentYearButton = null;
//----------------------------------------------------------------------------------------------------------------------

    private GridLayout daysLayout;
//----------------------------------------------------------------------------------------------------------------------

    private final Color BG_COLOR = new Color(25,25,25);
//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public DaysPanel(ActionListener lisDay, ActionListener lisYear){

        daysLayout = new GridLayout(ROWS,COLS);
        setLayout(daysLayout);
        setBorder(BorderFactory.createBevelBorder(1));
        setLayout(daysLayout);
        setBackground(BG_COLOR);
        setPreferredSize(new Dimension(WIDTH,HEIGHT));

        addDaysButtons(lisDay, lisYear);
    }
//----------------------------------------------------------------------------------------------------------------------
    // For each day, Calls for the de-mark function

    public void reColorDaysBtns(){
        if (lstDays.size() == 0){
            System.out.println("Days Buttons List Is Empty!");
            return;
        }
        int i = 0;
        while ( i <MAX_DAYS){
            lstDays.get(i++).setDefaultColors();
        }

    }
//----------------------------------------------------------------------------------------------------------------------
    // For each year, Calls for the de-mark function


    public void reColorYearsBtns(){
    if (lstDays.size() == 0){
        System.out.println("Days Buttons List Is Empty!");
        return;
    }
    int i = MAX_DAYS;
    while ( i <lstDays.size()){
        lstDays.get(i++).setDefaultColors();
    }

}
//----------------------------------------------------------------------------------------------------------------------
    // Sets the text for the Days buttons and Year buttons, also set the ActionListeners
    // Adds them to the panel

    public void addDaysButtons(ActionListener lisDay, ActionListener lisYear) {

        int btnNumber = 1;

        while (btnNumber <= MAX_DAYS) {

            DayButton btnDay = new DayButton(btnNumber++);
            btnDay.addActionListener(lisDay);
            lstDays.add(btnDay);
            this.add(btnDay);
        }

        DayButton  yearButton2019 = new DayButton(2019);
        DayButton  yearButton2020 = new DayButton(2020);
        yearButton2019.addActionListener(lisYear);
        yearButton2020.addActionListener(lisYear);

        lstDays.add(yearButton2019);
        lstDays.add(yearButton2020);
        this.add(yearButton2019);
        this.add(yearButton2020);

    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the picked Day Buttons

    public static DayButton getCurrentDayBtn(){
        if (currentDayButton == null){
            return null;
        }
        return currentDayButton;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the picked Year Buttons

    public static DayButton getCurrentYearBtn() {
         if (currentYearButton == null) {
             return null;
         }
         return currentYearButton;
     }
//----------------------------------------------------------------------------------------------------------------------
}
