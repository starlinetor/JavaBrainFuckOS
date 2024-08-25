package Main.Renderer;
import Main.Data.Data;
import Main.OSLogic.InputHandler;

import javax.swing.*;

public class FrameRenderer extends JFrame {
    //This class handles rendering
    PanelRenderer panelRenderer;

    //these are the dimension of each letter

    public static final int pixelWidth = (int) Data.loadFontJSON().getJSONObject("settings").get("width");
    public static final int pixelHeight = (int) Data.loadFontJSON().getJSONObject("settings").get("height");

    public FrameRenderer(int width, int height, InputHandler inputHandler){
        //Instantiate the frame renderer and setups the window
        //Creates new panel with precise dimensions
        this.panelRenderer = new PanelRenderer(width,height);
        //When you close the windows the application turns off
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adds the panel to the window
        this.add(panelRenderer);
        //The window is not resizable this is because i want to a fixed screen dimension
        this.setResizable(false);
        //No clue what this does exactly
        this.pack();
        //Same
        this.setLocationRelativeTo(null);
        //The window is visible
        this.setVisible(true);
        //Adding keyListener
        this.addKeyListener(inputHandler);
    }

    //get functions
    public int getPanelWidth(){
        return panelRenderer.getWidth();
    }

    public int getPanelHeight(){
        return panelRenderer.getHeight();
    }
    public PanelRenderer getPanelRenderer() {
        return panelRenderer;
    }
    //calls the function to render the next frame
    public void newFrame(char[] text){
        //updates the text to be printed
        panelRenderer.text = text;
        //repaints the panel
        panelRenderer.repaint();
    }

}
