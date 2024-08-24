package Main.AdditionalClasses.Utils;

import Main.Main;

public class StringUtils {



    //This function finds the first \n it then adds empty spaces until the end of the line it then removes the \n from the file.
    //This allows the brainFUCKOS to render correctly the ashii art

    public static char[] stringConverter(String text){

        StringBuilder string = new StringBuilder(text);

        for(int i = 0 ; i < string.length() ; i++){

            //first we find the /n

            if(string.charAt(i) == '\n'){
                //we find then in witch row we are in
                int row = MathUtils.roundUpDivision(i, Main.XPixelCount);

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
}
