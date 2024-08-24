package Main.Data;

import org.json.JSONObject;
import org.json.JSONTokener;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class Data {

    public static JSONObject loadFontJSON(){
        JSONObject fontJson;
        try {
            fontJson = new JSONObject(new JSONTokener(new FileInputStream(System.getProperty("user.dir") + "/Main/Data/Fixedsys.json")));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return fontJson;
    }

    public static BufferedImage loadFontImage(){
        BufferedImage fontImage;

        try {
            fontImage = ImageIO.read(Objects.requireNonNull(Data.class.getResource("Fixedsys.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return fontImage;
    }
}
