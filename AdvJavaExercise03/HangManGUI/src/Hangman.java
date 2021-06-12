import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
this class represent the hangman panel, draw accordingly the hangman's part of the body
draws win or lose screen.
 */

public class Hangman extends JLabel {

  private final int PANEL_WIDTH = 800;
  private final int PANEL_HEIGHT = 400;


    private String path;

    private final char FIRST_IMAGE =  '0';
    private final String IMAGE_NAME = "hm";
    private final String IMAGE_SUFFIX = ".png";
    private final String IMAGE_LOSE = "_lose";
    private final String IMAGE_WIN = "_win";




    private BufferedImage image;


//----------------------------------------------------------------------------------------------------------------------
    // Ctor

    public Hangman(){

        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.path = this.IMAGE_NAME + FIRST_IMAGE + this.IMAGE_SUFFIX;
        this.image = this.loadImage(this.path);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Overriding paint component

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.image,0,0,PANEL_WIDTH,PANEL_HEIGHT,null);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Load next image File

    public BufferedImage loadImage(String imgPath){

        BufferedImage img = null;

        try{
            img = ImageIO.read(new File(imgPath));
        }
        catch(IOException e){
            System.out.println("Exception: Image Could Not Be Found!");
        }

        return img;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Calls a method to load next image

    public void nextImage(int imageNumger){
        loadNewImage(String.valueOf(imageNumger));

        }
//----------------------------------------------------------------------------------------------------------------------
    // Loads new image

        private void loadNewImage(String imageNumger){
            this.path = this.IMAGE_NAME + imageNumger + this.IMAGE_SUFFIX;
            this.image = this.loadImage(this.path);
            repaint();
        }
//----------------------------------------------------------------------------------------------------------------------
    // Loads the 'win' screen

    public void win(){
        this.loadNewImage(this.IMAGE_WIN);

    }

//----------------------------------------------------------------------------------------------------------------------
    // Loads the 'lose' screen

    public void lose(){
    this.loadNewImage(this.IMAGE_LOSE);
}
//----------------------------------------------------------------------------------------------------------------------
}

