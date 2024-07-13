package Main;

import Main.Renderer.FrameRenderer;
import Main.Renderer.PanelRenderer;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.TimeUnit;

public class Main {



    public static final int XPixelCount = 100;
    public static final int YPixelCount = 30;

    public static final int screenLength = XPixelCount * YPixelCount;

    public static void main(String[] args) throws InterruptedException {

        char[] screen = new char[screenLength];


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

        char[] textChar = stringConverter(text);

        System.arraycopy(textChar, 0, screen, 0, textChar.length);


        FrameRenderer frameRenderer = new FrameRenderer(XPixelCount*FrameRenderer.pixelWidth,YPixelCount*FrameRenderer.pixelHeight);

        frameRenderer.newFrame(screen);

        String str = "Loading Dick Size";

        System.arraycopy(str.toCharArray(), 0, screen,PanelRenderer.cordsToLinear(0,14), str.length());


        screen[PanelRenderer.cordsToLinear(0,15)] = '8';
        screen[PanelRenderer.cordsToLinear(1,15)] = '=';
        screen[PanelRenderer.cordsToLinear(2,15)] = ')';


        frameRenderer.newFrame(screen);

        int k = 2;

        while (true){
            Thread.sleep(500);
            screen[PanelRenderer.cordsToLinear(k,15)] = '=';
            screen[PanelRenderer.cordsToLinear(k+1,15)] = ')';
            k ++;
            frameRenderer.newFrame(screen);
        }


    }

    public static char[] stringConverter(String text){

        StringBuilder string = new StringBuilder(text);

        for(int i = 0 ; i < string.length() ; i++){

            //first we find the /n

            if(string.charAt(i) == '\n'){
                //we find then in witch row we are in
                int row = findRow(i, Main.XPixelCount);

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

    public static int findRow(int num, int divisor) {
        return (num + divisor - 1) / divisor;
    }

}
