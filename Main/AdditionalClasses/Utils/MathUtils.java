package Main.AdditionalClasses.Utils;

import Main.Main;

public class MathUtils {

    //this calculates a division and rounds it up. Is used in the stringConverter function to find the row of a \n
    public static int roundUpDivision(int num, int divisor) {
        return (num + divisor - 1) / divisor;
    }

    //this method transforms a pair of coordinates to the index of the array
    public static int cordsToLinear(int x, int y,int rows){
        return x + rows * y;
    }

}
