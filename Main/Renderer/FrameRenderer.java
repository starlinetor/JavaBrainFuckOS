package Main.Renderer;
import javax.swing.*;

public class FrameRenderer extends JFrame {
    //This class handles rendering
    PanelRenderer panelRenderer;

    public static final int pixelWidth = 8;
    public static final int pixelHeight = 15;

    public FrameRenderer(int width, int height){

        this.panelRenderer = new PanelRenderer(width,height);
        //create panel
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panelRenderer);

        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
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
        panelRenderer.text = text;
        panelRenderer.repaint();
    }

}
