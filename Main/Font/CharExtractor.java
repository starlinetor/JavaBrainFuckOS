package Main.Font;

import org.json.JSONObject;
import org.json.JSONParserConfiguration;
import org.json.JSONTokener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class CharExtractor {


    //these should never be modified. They represent the dimension and offset of the char grid of the font.
    //TODO : even if these don't need to be edited is better to have a general global variable file somewhere.
    int xOffSet = 1;
    int width  = 8;
    int yOffSet = 1;
    int height = 15;

    //Here are stored the JSON file and the font file
    JSONObject charCords;
    BufferedImage font;

    public CharExtractor(){


        //Loads in the immage

        try {
            font = ImageIO.read(Objects.requireNonNull(getClass().getResource("Fixedsys.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //loads in the json file

        try {
            charCords = new JSONObject(new JSONTokener(new FileInputStream(System.getProperty("user.dir")+"/Main/Font/charCords.json")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public BufferedImage charToImage (char character){

        JSONObject symbol;

        //if the symbol exists is then searched in the json file, is it does not exists is substitute with a blank one
        //TODO : modifiy from blank to not existing symbol

        if(charCords.has(String.valueOf(character))){
            symbol = charCords.getJSONObject(String.valueOf(character));
        }else{
            symbol = charCords.getJSONObject(" ");
        }

        //get the line an column of the symbol
        //TODO : edit everything to use rows and columns instead

        int lineChar = (int) symbol.get("line");
        int columnChar = (int) symbol.get("column");

        int xChar = columnChar*width + xOffSet;
        int yChar = lineChar*height + yOffSet;

        // returns the cropped image to be used by the code
        return font.getSubimage(xChar,yChar,width,height);
    }

}
