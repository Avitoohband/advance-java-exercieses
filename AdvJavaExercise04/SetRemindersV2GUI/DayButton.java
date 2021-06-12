import javax.swing.*;
import java.awt.*;

public class DayButton extends JButton {

    /*
    This class represent the day button
     */


    private Color BG_COLOR = new Color(50,50,50);
    private Color TEXT_COLOR = new Color(0,125,0);

    private int dayNumber;

//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public DayButton(int number){

        setFont(new Font("MV Boli", Font.BOLD, 15));
        setText(String.valueOf(number));
        setBorder(BorderFactory.createBevelBorder(1));
        setBackground(BG_COLOR);
        setForeground(TEXT_COLOR);
        setFocusable(false);
        dayNumber = number;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Returns the button text (day or year)

    public int getDayNumber() {
        return dayNumber;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Mark the button as pressed

    public void markedAsPressed(){
        setBackground(Color.white);
        setForeground(Color.red);
    }
//----------------------------------------------------------------------------------------------------------------------
    // De-mark the button

    public void setDefaultColors(){
        setBackground(BG_COLOR);
        setForeground(TEXT_COLOR);
    }
//----------------------------------------------------------------------------------------------------------------------
}
