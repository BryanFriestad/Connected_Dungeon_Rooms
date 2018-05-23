package game;

import engine.AbstractGame;
import engine.GameContainer;
import engine.Renderer;
import engine.gfx.Image;

import java.awt.event.KeyEvent;

public class Main extends AbstractGame {

    private Image image;

    public Main(){
        super();
        image = new Image("wall2", "png");
    }

    public static void main(String[] args){
        GameContainer gc = new GameContainer(new Main());
        gc.start();
        Dungeon d = new Dungeon(10, 1);
        new Main();
    }

    @Override
    public void update(GameContainer gc, float dt) {
        if(gc.getInput().isKeyPressed(KeyEvent.VK_A)){
            System.out.println("A was pressed down");
        }
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        renderer.drawImage(image, gc.getInput().getMouseX(), gc.getInput().getMouseY());
    }
}
