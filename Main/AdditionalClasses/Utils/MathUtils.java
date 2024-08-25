package Main.AdditionalClasses.Utils;

import javax.lang.model.type.ErrorType;

public class MathUtils {

    //this calculates a division and rounds it up. Is used in the stringConverter function to find the row of a \n
    public static int roundUpDivision(int num, int divisor) {
        return (num + divisor - 1) / divisor;
    }

    //this method transforms a pair of coordinates to the index of the array
    public static int coordsToLinear(int x, int y, int columns){
        return x + columns * y;
    }

    //inverted function of the previous
    public static int linearToCoords(int linear, int columns, char coordinate) throws Exception {

        if(coordinate == 'x') {
            return linear % columns;
        }if(coordinate == 'y'){
            return linear / columns;
        }else{
            System.err.println("ERROR");
            throw new java.lang.Error("coordinate accepts only x or y values");
        }
    }
}
