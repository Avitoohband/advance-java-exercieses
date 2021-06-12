import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PickMonthPanel extends JPanel{

    /*
    This class represent the picked month panel
     */

    private final int ROWS = 1;
    private final int COLS = 3;
//----------------------------------------------------------------------------------------------------------------------

    private JButton btnLeftArrow;
    private JButton btnRightArrow;
    private JLabel lblMonth;
//----------------------------------------------------------------------------------------------------------------------

    private Color BG_COLOR = new Color(50,50,50);
    private Color TEXT_COLOR = new Color(0,125,0);
//----------------------------------------------------------------------------------------------------------------------

    private final int BUTTON_WIDTH = 50;
    private final int BUTTON_HEIGHT = 30;
    private final int LBL_MONTH_WIDHTH = 80;
    private final int LBL_MONTH_HEIGHT = 25;
    private final int MONTH_OFFSET = 1;
//----------------------------------------------------------------------------------------------------------------------

    private final int FIRST_MONTH = 0 ;
    private final int LAST_MONTH = 11 ;
//----------------------------------------------------------------------------------------------------------------------

    private GridLayout panelLayout;
//----------------------------------------------------------------------------------------------------------------------

    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private int currentMonth = FIRST_MONTH;

//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public PickMonthPanel(ActionListener lisNextMonth, ActionListener lisPrevMonth){
        initializeButtons(lisNextMonth, lisPrevMonth) ;
        initializeMonthLabel();

        setBackground(BG_COLOR);
        panelLayout = new GridLayout(ROWS,COLS);
        panelLayout.setVgap(10);

        add(btnLeftArrow);
        add(lblMonth);
        add(btnRightArrow);

    }

//----------------------------------------------------------------------------------------------------------------------
    // Initialize the next and previous  months buttons, adds ActionListeners

    private void initializeButtons(ActionListener lisNextMonth, ActionListener lisPrevMonth){

       btnLeftArrow = new JButton();
       btnRightArrow = new JButton();

       btnLeftArrow.setFont(new Font("MV Boli", Font.BOLD, 15));
       btnLeftArrow.setBorder(BorderFactory.createBevelBorder(1));
       btnLeftArrow.setText("<<");
       btnLeftArrow.setBackground(BG_COLOR);
       btnLeftArrow.setForeground(TEXT_COLOR);
       btnLeftArrow.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
       btnLeftArrow.setFocusable(false);
       btnLeftArrow.addActionListener(lisPrevMonth);

       btnRightArrow.setFont(new Font("MV Boli", Font.BOLD, 15));
       btnRightArrow.setBorder(BorderFactory.createBevelBorder(1));
       btnRightArrow.setText(">>");
       btnRightArrow.setBackground(BG_COLOR);
       btnRightArrow.setForeground(TEXT_COLOR);
       btnRightArrow.setPreferredSize(new Dimension(BUTTON_WIDTH,BUTTON_HEIGHT));
       btnRightArrow.setFocusable(false);
       btnRightArrow.addActionListener(lisNextMonth);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Initialize the label that shows the current picked month

    private void initializeMonthLabel(){
        lblMonth = new JLabel();
        lblMonth.setFont(new Font("MV Boli", Font.BOLD, 15));
        lblMonth.setForeground(Color.WHITE);
        lblMonth.setMinimumSize(new Dimension(LBL_MONTH_WIDHTH,LBL_MONTH_HEIGHT));
        lblMonth.setPreferredSize(new Dimension(LBL_MONTH_WIDHTH,LBL_MONTH_HEIGHT));
        lblMonth.setMaximumSize(new Dimension(LBL_MONTH_WIDHTH,LBL_MONTH_HEIGHT));
        lblMonth.setText(months[FIRST_MONTH]);

    }
//----------------------------------------------------------------------------------------------------------------------
    // Changes to the next month in order

    public void nextMonth(){
        currentMonth++;

        if (currentMonth > LAST_MONTH) {
            currentMonth = FIRST_MONTH;
        }
        lblMonth.setText(months[currentMonth]);
        lblMonth.setText(months[currentMonth]);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Changes to the previous month in order


    public void prevMonth(){
        currentMonth--;

        if (currentMonth < FIRST_MONTH) {
            currentMonth = LAST_MONTH;
        }
        lblMonth.setText(months[currentMonth]);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the number of the current picked month

    public int getPickedMonthh(){
        return currentMonth+MONTH_OFFSET;
    }
}
