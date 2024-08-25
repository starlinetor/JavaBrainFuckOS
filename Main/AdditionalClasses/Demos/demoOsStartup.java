package Main.AdditionalClasses.Demos;

import Main.AdditionalClasses.Utils.MathUtils;
import Main.AdditionalClasses.Utils.StringUtils;
import Main.Main;

public class demoOsStartup {

    //BrainFUCK OS as ashi art
    static String logoString = (
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

    static String loading = "Loading";



    public static void runDemo(char[] screen,int i){
        if(i == 0){
            //Here the string is converted in to a char array
            //The function stringConverter edits the string in such a way that this program can read it. the code does not understand \n as going to a new line
            //Even if it could just going down a line does not work because it skips everything before the new line
            //For more info about the string converter go check out the function
            char[] logoChar = StringUtils.stringConverter(logoString);

            //We are adding the ashii art to the screen char array
            System.arraycopy(logoChar, 0, screen, 0, logoChar.length);

            //Loading animation

            //Adding the description to the screen in 0x 14y, because of how it works it will be added from 0-lengthStr
            // if it's longer than the Xwidth it will loop over to the other side

            System.arraycopy(
                    loading.toCharArray(),
                    0, screen,
                    MathUtils.coordsToLinear(0,14, Main.XPixelCount),
                    loading.length());

            //loading bar
            screen[MathUtils.coordsToLinear(0,15,Main.XPixelCount)] = '\\';
            screen[MathUtils.coordsToLinear(1,15,Main.XPixelCount)] = '=';
            screen[MathUtils.coordsToLinear(2,15,Main.XPixelCount)] = '/';
        }else{
            screen[MathUtils.coordsToLinear(i,15,Main.XPixelCount)] = '=';
            screen[MathUtils.coordsToLinear(i+1,15,Main.XPixelCount)] = '/';
        }
    }


}
