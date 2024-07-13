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

    int xOffSet = 1;
    int width  = 8;
    int yOffSet = 1;
    int height = 15;

    JSONObject charCords;

    BufferedImage font;

    public CharExtractor(){

        try {
            font = ImageIO.read(Objects.requireNonNull(getClass().getResource("Fixedsys.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            charCords = new JSONObject(new JSONTokener(new FileInputStream(System.getProperty("user.dir")+"/Main/Font/charCords.json")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public BufferedImage charToImage (char character){

        JSONObject symbol;

        if(charCords.has(String.valueOf(character))){
            symbol = charCords.getJSONObject(String.valueOf(character));
        }else{
            symbol = charCords.getJSONObject(" ");
        }

        int lineChar = (int) symbol.get("line");
        int columnChar = (int) symbol.get("column");

        int xChar = columnChar*width + xOffSet;
        int yChar = lineChar*height + yOffSet;

        return font.getSubimage(xChar,yChar,width,height);
    }

}
