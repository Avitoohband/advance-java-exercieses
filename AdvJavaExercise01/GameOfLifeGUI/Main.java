// John Conway's Gae Of Life
import javax.swing.*;
import java.awt.*;


public class Main {

    public static void main(String[] args) {
        MyPannel panel = new MyPannel();
        JFrame frame = new JFrame();


        frame.add(panel);

        frame.setTitle("Game Of Life");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        while(true)
        {
            if(JOptionPane.showConfirmDialog(null, "Go Next Generation?") == 0)
            {
                panel.resetPanel();
            }
            else{
                break;
            }
        }
    }
}