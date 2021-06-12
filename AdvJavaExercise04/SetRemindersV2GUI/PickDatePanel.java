import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PickDatePanel extends JPanel{

    /*
    This class represent the panel that holds the years,days and months buttons all together
     */

    private  DaysPanel pnlDays;
    private  PickMonthPanel pnlMonth;
    private JButton ref;

    private final int PICK_WIDTH = 650;
    private final int PICK_HEIGHT = 350;
    private Color BTN_COLOR = new Color(60,0,150);
    private Color BTN_TEXT_COLOR = new Color(150,0,0);

    private int currentDay = 0 ;
    private int currentMonth = 0 ;
    private int currentYear = 0 ;

    private Color BG_PICK_COLOR = new Color(35,35,35);
//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public PickDatePanel( ActionListener lisDay, ActionListener lisYear, ActionListener lisNextMonth, ActionListener lisPrevMonth){
        setBackground(BG_PICK_COLOR);
        setPreferredSize(new Dimension(PICK_WIDTH,PICK_HEIGHT));

        pnlMonth = new PickMonthPanel(lisNextMonth,lisPrevMonth);
        pnlDays = new DaysPanel(lisDay, lisYear);

        add(pnlMonth, BorderLayout.NORTH);
        add(pnlDays, BorderLayout.CENTER);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Forwards to next month method

    public void nextMonth(){
        pnlMonth.nextMonth();
    }

    // Forwards to previous month method

    public void prevMonth(){
        pnlMonth.prevMonth();
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the picked month

    public int getPickedMonth(){
        return pnlMonth.getPickedMonthh();
    }
//----------------------------------------------------------------------------------------------------------------------
    //  Forwards to re mark as pressed days buttons method

    public void reColorDaysBtns(){
        pnlDays.reColorDaysBtns();
    }
//----------------------------------------------------------------------------------------------------------------------
    //  Forwards to re mark as pressed years buttons method

    public void reColorYearsButtons(){
        pnlDays.reColorYearsBtns();
    }
//----------------------------------------------------------------------------------------------------------------------
}