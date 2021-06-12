import javax.swing.*;
import java.awt.*;

public class MyPannel extends JPanel {

    private final int REC_SIZE = 40;
    private final int OFFSETX = 40;
    private final int OFFSETY = 10;
    private MyMatrix mat = new MyMatrix();



//----------------------------------------------------------------------------------------------------------------------
//    @Override
    // Ctor
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);


        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < mat.getMatSize(); i++)
        {
            for (int j = 0; j < mat.getMatSize() ; j++)
            {
                if (mat.isAlive(i,j) == true){

                    g.setColor(Color.red);
                    g.fillRect(i*REC_SIZE + OFFSETX, j*REC_SIZE +OFFSETY, REC_SIZE, REC_SIZE);
                    g.setColor(Color.black);
                    g.drawRect(i*REC_SIZE + OFFSETX, j*REC_SIZE +OFFSETY, REC_SIZE, REC_SIZE);
                }
                else{
                    g.setColor(Color.black);
                    g.drawRect(i*REC_SIZE + OFFSETX, j*REC_SIZE +OFFSETY, REC_SIZE, REC_SIZE);
                }
            }
        }
    }
//----------------------------------------------------------------------------------------------------------------------
    // Call for a function to change the matrix to be "it's next generation"
    // Repaint the panel after it has been changed
    public void resetPanel(){
        this.mat.goNextGeneration();
        this.repaint();

    }
//----------------------------------------------------------------------------------------------------------------------
}

