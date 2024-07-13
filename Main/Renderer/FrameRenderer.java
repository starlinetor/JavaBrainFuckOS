package Main.Renderer;
import javax.swing.*;

public class FrameRenderer extends JFrame {
    //This class handles rendering
    PanelRenderer panelRenderer;

    //these are the dimension of each letter
    //TODO : this is the third time i find these stupid numbers in a random place, make them unique
    public static final int pixelWidth = 8;
    public static final int pixelHeight = 15;

    public FrameRenderer(int width, int height){
        //Instantiate the frame renderer and setups the window
        //Creates new panel with precise dimensions
        this.panelRenderer = new PanelRenderer(width,height);
        //When you close the windows the application turns off
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adds the panel to the window
        this.add(panelRenderer);
        //The windows is not resizable this is because i want to a fixed screen dimension
        this.setResizable(false);
        //No clue what this does exactly
        this.pack();
        //Same
        this.setLocationRelativeTo(null);
        //The window is visible
        this.setVisible(true);
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
