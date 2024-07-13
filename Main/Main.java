package Main;

import Main.Renderer.FrameRenderer;
import Main.Renderer.PanelRenderer;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.TimeUnit;

public class Main {


    //These variables describe the number of "pixel" that are on the screen. I am counting a char as a pixel
    //TODO: probably is better to move this somewhere else in a config file somewhere.
    public static final int XPixelCount = 100;
    public static final int YPixelCount = 30;
    //calculates the number of total char to make a char array of the corrent lenght
    public static final int screenLength = XPixelCount * YPixelCount;

    public static void main(String[] args) throws InterruptedException {

        //declares the screen char, meaning what is printed to the screen
        char[] screen = new char[screenLength];

        //TODO: all this stuff is nice but it should not be in the main file. Move it to a demo folder. Is good for debugging
        //BrainFUCK OS as ashi art
        String text = (
                "__________               .__       ___________             __    \n" +
                        "\\______   \\____________  |__| ____ \\_   _____/_ __   ____ |  | __\n" +
                        " |    |  _/\\_  __ \\__  \\ |  |/    \\ |    __)|  |  \\_/ ___\\|  |/ /\n" +
                        " |    |   \\ |  | \\// __ \\|  |   |  \\|     \\ |  |  /\\  \\___|    < \n" +
                        " |______  / |__|  (____  /__|___|  /\\___  / |____/  \\___  >__|_ \\\n" +
                        "        \\/             \\/        \\/     \\/              \\/     \\/\n" +
                        "                         ________    _________                   \n" +
                        "                         \\_____  \\  /   _____/                   \n" +
                        "                          /   |   \\ \\_____  \\                    \n" +
                        "                         /    |    \\/        \\                   \n" +
                        "                         \\_______  /_______  /                   \n" +
                        "                                 \\/        \\/                    ");
        //Here the string is converted in to a char array
        //The function stringConverter edits the string in such a way that this program can read it. the code does not understand \n as going to a new line
        //Even if it could just going down a line does not work because it skips everything before the new line
        //For more info about the string converter go check out the function
        char[] textChar = stringConverter(text);
        //We are adding the ashii art to the screen char array
        System.arraycopy(textChar, 0, screen, 0, textChar.length);

        //instantiating the frameRenderer
        FrameRenderer frameRenderer = new FrameRenderer(XPixelCount*FrameRenderer.pixelWidth,YPixelCount*FrameRenderer.pixelHeight);

        //reloading the frame render
        frameRenderer.newFrame(screen);


        //TODO : move it to a demo folder
        //Useless loading animation
        //Description
        String str = "Loading";
        //Adding the description to the screen in 0x 14y, because of how it works it will be added from 0-lenghtStr, if its longer than the Xwidth it will loop over to the other side
        System.arraycopy(str.toCharArray(), 0, screen,PanelRenderer.cordsToLinear(0,14), str.length());
        //adding a dick
        screen[PanelRenderer.cordsToLinear(0,15)] = '\\';
        screen[PanelRenderer.cordsToLinear(1,15)] = '=';
        screen[PanelRenderer.cordsToLinear(2,15)] = '/';
        //renders the frame
        frameRenderer.newFrame(screen);
        int k = 2;
        //makes the bar longer
        while (true){
            Thread.sleep(500);
            screen[PanelRenderer.cordsToLinear(k,15)] = '=';
            screen[PanelRenderer.cordsToLinear(k+1,15)] = '/';
            k ++;
            frameRenderer.newFrame(screen);
        }


    }

    //TODO : move it somewhere else
    //This function finds the first \n it then adds empty spaces until the end of the line it then removes the \n from the file.
    //This allows the brainFUCKOS to render correctly the ashii art

    public static char[] stringConverter(String text){

        StringBuilder string = new StringBuilder(text);

        for(int i = 0 ; i < string.length() ; i++){

            //first we find the /n

            if(string.charAt(i) == '\n'){
                //we find then in witch row we are in
                int row = roundUpDivision(i, Main.XPixelCount);

                //count missing space
                int missingSpace = i-(row)*Main.XPixelCount;

                //add empty spaces till the border
                for(int j = i; j<row*Main.XPixelCount; j++){
                    string.insert(j,' ');
                }
                //move i to the border
                i = row*Main.XPixelCount;

                //delete \n
                string.delete(i,i+1);
                //we move backwards once because we deleted were we are. meaning we would skip the next one.
                i = i-1;
            }

        }

        return string.toString().toCharArray();
    }

    //TODO : move this somewhere else
    //this calculates a division and rounds it up. Is used in the stringConverter function to find the row of a \n
    public static int roundUpDivision(int num, int divisor) {
        return (num + divisor - 1) / divisor;
    }

}
