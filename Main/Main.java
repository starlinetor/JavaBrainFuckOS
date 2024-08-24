package Main;

import Main.AdditionalClasses.Demos.demoOsStartup;
import Main.AdditionalClasses.Utils.StringUtils;
import Main.Renderer.FrameRenderer;
import java.util.Arrays;
import Main.AdditionalClasses.Utils.MathUtils;
import Main.AdditionalClasses.Demos.demoFPSTest;

public class Main {


    //These variables describe the number of "pixel" that are on the screen. I am counting a char as a pixel
    //TODO: probably is better to move this somewhere else in a config file somewhere.
    //Not sure how to handle this
    public static final int XPixelCount = 100;
    public static final int YPixelCount = 30;
    //calculates the number of total char to make a char array of the corrent lenght
    public static final int screenLength = XPixelCount * YPixelCount;

    public static void main(String[] args) throws InterruptedException {

        //declares the screen char, meaning what is printed to the screen
        char[] screen = new char[screenLength];
        Arrays.fill(screen, ' ');

        //instantiating the frameRenderer
        FrameRenderer frameRenderer = new FrameRenderer(XPixelCount*FrameRenderer.pixelWidth,YPixelCount*FrameRenderer.pixelHeight);
        frameRenderer.newFrame(screen);

        demoFPSTest demo = new demoFPSTest(screen,100);

        while (true){


            demo.runDemo();

            frameRenderer.newFrame(screen);

        }

    }
}
