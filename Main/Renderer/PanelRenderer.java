package Main.Renderer;

import Main.AdditionalClasses.Utils.MathUtils;
import Main.Renderer.Font.CharExtractor;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanelRenderer extends JPanel {

    //here is stored the Char Array to be printed
    char[] text = new char[Main.screenLength];

    //Stores the reference to the char Extractor
    CharExtractor charExtractor;

    PanelRenderer(int width, int height){
        //Instantiates the Panel Renderer, setting a size and creates a new charExtractor to be used. When this is run the char extractor will load the image and the JSON file
        this.setPreferredSize(new Dimension(width,height));
        this.charExtractor = new CharExtractor();
    }

    public void paint(Graphics g){

        //These lines are needed no clue why tho
        super.paintComponent(g);
        //This is instantiating something that is used to draw.
        Graphics2D g2D = (Graphics2D) g;

        //This prints a row at the time from left to right top to bottom.
        for (int y = 0; y < Main.YPixelCount; y++){
            for(int x = 0; x < Main.XPixelCount ; x++){
                //here it uses the charExtractor Library to get the needed letter.
                BufferedImage image = charExtractor.charToImage(text[MathUtils.cordsToLinear(x,y,Main.XPixelCount)]);
                //Prints the letter on the screen.
                g2D.drawImage(image, x * charExtractor.width, y * charExtractor.height, null);
            }
        }


    }
}
