import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PickDatePanel extends JPanel{

    /*
    This class represent the panel that holds the years,days and months buttons all together
     */


    private JComboBox JCdays;
    private JComboBox JCmonths;
    private JComboBox JCyears;

    private final int PICK_WIDTH = 650;
    private final int PICK_HEIGHT = 150;
    private final int MAX_DAYS = 31;

    private Color BG_PICK_COLOR = new Color(35,35,35);
//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public PickDatePanel( ActionListener lisDay, ActionListener lisMonth, ActionListener lisYear){
        setBackground(BG_PICK_COLOR);
        setPreferredSize(new Dimension(PICK_WIDTH,PICK_HEIGHT));

        initializeJComboArrays(lisDay, lisMonth, lisYear);

        add(JCdays, BorderLayout.WEST);
        add(JCmonths, BorderLayout.CENTER);
        add(JCyears, BorderLayout.EAST);
    }

//----------------------------------------------------------------------------------------------------------------------
    //Initialize JComboBox Objects to pick the desired date from

    private void initializeJComboArrays(ActionListener lisDay, ActionListener lisMonth, ActionListener lisYear){
        int day = 0 ;
        String[] daysForJC = new String[MAX_DAYS];
        String[] yearsForJC = new String[]{"2019", "2020"};
        String[] monthsForJC = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};


        while (day < MAX_DAYS){
            daysForJC[day] = String.valueOf(day+1);
            day++;
        }
        JCdays = new JComboBox(daysForJC);
        JCmonths = new JComboBox(monthsForJC);
        JCyears = new JComboBox(yearsForJC);

        JCdays.addActionListener(lisDay);
        JCmonths.addActionListener(lisMonth);
        JCyears.addActionListener(lisYear);


    }
//----------------------------------------------------------------------------------------------------------------------
}