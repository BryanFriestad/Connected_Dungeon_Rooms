package engine;

import engine.gfx.Image;

import java.awt.image.DataBufferInt;

public class Renderer {

    private int pW, pH;
    private int[] p;

    public Renderer(GameContainer gc){
        pW = gc.getWidth();
        pH = gc.getHeight();
        p = ((DataBufferInt) gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }

    public void setPixel(int x, int y, int value){
        if((x < 0 || x >= pW || y < 0 || y >= pH || value == 0xFFFF00FF)){
            return;
        }

        p[x + y * pW] = value;
    }

    public void drawImage(Image i, int drawX, int drawY){
        for(int y = 0; y < i.getHeight(); y++){
            for(int x = 0; x < i.getWidth(); x++){
                setPixel(x + drawX, y + drawY, i.getPixel_data()[x + y * i.getWidth()]);
            }
        }

    }

    public void clear(){
        for(int i = 0; i < p.length; i++){
            p[i] = 0xFF000000; //black with 100% alpha
        }
    }
}
