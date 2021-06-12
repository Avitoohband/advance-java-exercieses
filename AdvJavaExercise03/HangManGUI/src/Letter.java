import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/*
this class represent a letter tile
for the user to guess
 */

public class Letter extends JLabel {

    BufferedImage letterImage;

    private final int IMAGE_WIDTH = 50;
    private final int IMAGE_HEIGHT = 50;


    private char imageLetter ;
    private final String IMAGE_SUFFIX = ".png";
    private final String EMPTY_IMAGE= "Empty";
    private MouseListener letterTileListener;


//----------------------------------------------------------------------------------------------------------------------
    //Ctor

    public Letter(char choosenLetter){

        setPreferredSize(new Dimension(IMAGE_WIDTH, IMAGE_HEIGHT));
        this.loadImage(choosenLetter);
    }
//----------------------------------------------------------------------------------------------------------------------
    // Overriding paint component
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(this.letterImage, 0,0,IMAGE_WIDTH,IMAGE_HEIGHT,null);
    }

//----------------------------------------------------------------------------------------------------------------------
    // Loads the desired char image

    private void  loadImage(char choosenLetter){

        this.imageLetter = choosenLetter;
        String path = this.imageLetter + this.IMAGE_SUFFIX;

        this.updateLetterTileImage(path);

    }
//----------------------------------------------------------------------------------------------------------------------
    // to replace the choosen letter with empty one

    private void loadEmptyImage(){

        String path = this.EMPTY_IMAGE + this.IMAGE_SUFFIX;
        this.updateLetterTileImage(path);

    }
//----------------------------------------------------------------------------------------------------------------------
    // updates the image of the letter tile with the given path
    private void updateLetterTileImage(String path){
        BufferedImage img = null;

        try{
            img = ImageIO.read(new File(path));
        }
        catch(IOException e){
            System.out.println("Exception: Image Could Not Be Found!");
        }
        this.letterImage = img;
        repaint();
    }
//----------------------------------------------------------------------------------------------------------------------
    // return the letters that the user guessed

    public char guessLetter(){

        this.loadEmptyImage();
        this.removeLetterTileListener(); // to make sure this isn't clickable anymore
        return this.imageLetter;
    }
//----------------------------------------------------------------------------------------------------------------------
    // Adds a MouseListener to the letter tile

    public void addLetterTileListener(MouseListener lis){

        this.letterTileListener = lis;
        this.addMouseListener(this.letterTileListener);

    }
//----------------------------------------------------------------------------------------------------------------------
    // removes the MouseListener from the letter tile

    public void removeLetterTileListener() {
        removeMouseListener(this.letterTileListener);
    }
//----------------------------------------------------------------------------------------------------------------------
}
