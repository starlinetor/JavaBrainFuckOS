package Main.Renderer;

import Main.Font.CharExtractor;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PanelRenderer extends JPanel {

    char[] text = new char[Main.screenLength];

    CharExtractor charExtractor;

    PanelRenderer(int width, int height){
        this.setPreferredSize(new Dimension(width,height));
        this.charExtractor = new CharExtractor();
    }

    public void paint(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        for (int y = 0; y < Main.YPixelCount; y++){
            for(int x = 0; x < Main.XPixelCount ; x++){
                if(text[cordsToLinear(x,y)] == 'ù'){
                    break;
                }
                BufferedImage image = charExtractor.charToImage(text[cordsToLinear(x,y)]);
                g2D.drawImage(image, x * 8, y * 15, null);
            }
        }


    }

    public static int cordsToLinear(int x, int y){
        return x + Main.XPixelCount*y;
    }
}
