package Main.Renderer.Font;

import Main.Data.Data;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Objects;

import java.io.FileInputStream;


public class CharExtractor {


    //They represent the dimension and offset of the char grid of the font.
    int widthOffset;
    public int width;
    int heightOffset;
    public int height;

    //Here are stored the JSON file and the font file
    JSONObject fontJson;
    //settings of the font
    JSONObject settings;
    //map of the chars
    JSONObject charMap;
    //actual font file
    BufferedImage fontImage;

    public CharExtractor(){


        //Loads in the image

        fontImage = Data.loadFontImage();

        //loads in the json file

        fontJson = Data.loadFontJSON();

        //loads in the settings and the map
        loadData();
    }


    public BufferedImage charToImage (char character){

        JSONObject symbol;

        //if the symbol exists is then searched in the json file, is it does not exists is substitute with a blank one

        if(charMap.has(String.valueOf(character))){
            symbol = charMap.getJSONObject(String.valueOf(character));
        }else{
            symbol = charMap.getJSONObject("�");
        }

        //get the line a column of the symbol

        int rowChar = (int) symbol.get("row");
        int columnChar = (int) symbol.get("column");

        int xChar = columnChar*width + widthOffset;
        int yChar = rowChar*height + heightOffset;

        // returns the cropped image to be used by the code
        return fontImage.getSubimage(xChar,yChar,width,height);
    }

    public void loadData(){
        try{
            settings = fontJson.getJSONObject("settings");
            charMap = fontJson.getJSONObject("charMap");

            widthOffset = (int) settings.get("widthOffset");
            width = (int) settings.get("width");
            heightOffset = (int) settings.get("heightOffset");
            height = (int) settings.get("height");
        }catch (JSONException e){
            System.out.println("Error while loading the font.JSON, either missing or wrongly formatted, more info below:");
            e.printStackTrace();
            System.exit(0);
        }
    }

}
