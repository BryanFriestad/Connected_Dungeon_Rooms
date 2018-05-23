package engine.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Image {

    private static final String PATH = "Connected_Dungeon_Rooms/res/";

    private int width, height;
    private int[] pixel_data;

    public Image(String filename, String filetype){
        if(!filetype.equalsIgnoreCase("png")){
            throw new IllegalArgumentException("Unacceptable filetype");
        }
        BufferedImage image = null;

        try {
            FileInputStream fis = new FileInputStream(PATH + filename + "." + filetype);
            image = ImageIO.read(fis);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        width = image.getWidth();
        height = image.getHeight();
        pixel_data = image.getRGB(0, 0, width, height, null, 0, width);

        image.flush();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[] getPixel_data() {
        return pixel_data;
    }

    public void setPixel_data(int[] pixel_data) {
        this.pixel_data = pixel_data;
    }
}
