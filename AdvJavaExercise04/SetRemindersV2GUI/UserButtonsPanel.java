import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UserButtonsPanel extends JPanel {

    /*
    This class represent the the user buttons panel
     */


    private final int ROWS = 1;
    private final int COLS = 3;



    private GridLayout userBtnssLayout;

    private final Color BG_COLOR = new Color(25,25,25);
    private Color BTN_COLOR = new Color(60,0,150);
    private Color BTN_TEXT_COLOR = new Color(150,0,0);



//----------------------------------------------------------------------------------------------------------------------
    // C-tor

    public UserButtonsPanel(ActionListener lisUpdate, ActionListener lisExport , ActionListener lisImport){

        userBtnssLayout = new GridLayout(ROWS,COLS);
        setLayout(userBtnssLayout);
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setLayout(userBtnssLayout);
        setBackground(BG_COLOR);

        addButtons(lisUpdate, lisExport, lisImport);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Initialize and adds the user buttons to the panel
    // adds the ActionListeners to the buttons as well

    public void addButtons(ActionListener lisUpdate, ActionListener lisExport ,ActionListener lisImport){

        JButton imp = new JButton();
        JButton exp = new JButton();
        JButton upt = new JButton();

        imp.setFont(new Font("MV Boli", Font.BOLD, 15));
        imp.setBackground(BTN_COLOR);
        imp.setForeground(BTN_TEXT_COLOR);
        imp.setText("Import");
        imp.setFocusable(false);
        imp.addActionListener(lisImport);

        exp.setFont(new Font("MV Boli", Font.BOLD, 15));
        exp.setBackground(BTN_COLOR);
        exp.setForeground(BTN_TEXT_COLOR);
        exp.setText("Export");
        exp.setFocusable(false);
        exp.addActionListener(lisExport);

        upt.setFont(new Font("MV Boli", Font.BOLD, 15));
        upt.setBackground(BTN_COLOR);
        upt.setForeground(BTN_TEXT_COLOR);
        upt.setText("Update");
        upt.setFocusable(false);
        upt.addActionListener(lisUpdate);

        this.add(imp);
        this.add(exp);
        this.add(upt);
    }
//----------------------------------------------------------------------------------------------------------------------

}
