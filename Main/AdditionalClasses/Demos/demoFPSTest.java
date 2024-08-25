package Main.AdditionalClasses.Demos;

import Main.AdditionalClasses.Utils.MathUtils;
import Main.AdditionalClasses.Utils.StringUtils;
import Main.Main;

import java.util.Arrays;

public class demoFPSTest {

    //BrainFUCK OS as ashi art
    String logoString = (
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

    char[] screen;
    long lastTime;
    long currentTime;
    int maxFPS;

    public demoFPSTest(char[] screen, int maxFPS){
        this.screen = screen;
        this.maxFPS = maxFPS;
        lastTime = System.nanoTime();
    }

    public void runDemo() throws InterruptedException {

            if(executeFrame()){
                //screen values
                Arrays.fill(screen, ' ');
                logo();
                timePassed();
                currentFPS();

                //random spike lag
                Thread.sleep((long) (Math.random()*20));

                lastTime = currentTime;
            }
    }

    boolean executeFrame(){
        currentTime = System.nanoTime();
        long deltaT = currentTime-lastTime;
        long waitTime = (long) (1E+9 * ((double) 1 /maxFPS));

        return deltaT >= waitTime;
    }

    void logo(){
        char[] logoChar = StringUtils.stringConverter(logoString);
        System.arraycopy(logoChar, 0, screen, 0, logoChar.length);
    }

    void timePassed(){
        String timepassedString = "Time passed : " + currentTime + "             ";
        char[] timePassedChar = timepassedString.toCharArray();
        System.arraycopy(
                timePassedChar,
                0,
                screen,
                MathUtils.coordsToLinear(0, 14, Main.XPixelCount),
                timePassedChar.length);
    }

    void currentFPS(){
        long deltaT = currentTime-lastTime;
        String FPSString = "FPS : " + (int) 1E+9/deltaT + "             ";
        char[] FPSChar = FPSString.toCharArray();
        System.arraycopy(
                FPSChar,
                0,
                screen,
                MathUtils.coordsToLinear(0, 15, Main.XPixelCount),
                FPSChar.length);
    }

    public static void currentFPS(char[] screen, long currentTime, long lastTime){
        long deltaT = currentTime-lastTime;
        String FPSString = "FPS : " + (int) 1E+9/deltaT + "             ";
        char[] FPSChar = FPSString.toCharArray();
        System.arraycopy(
                FPSChar,
                0,
                screen,
                MathUtils.coordsToLinear(0, 0, Main.XPixelCount),
                FPSChar.length);
    }

}
