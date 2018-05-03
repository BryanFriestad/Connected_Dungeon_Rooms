import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{

    public Main(){
        super();
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args){
        Dungeon d = new Dungeon(10, 1);
        new Main();
    }

    public void paint(Graphics g){
        super.paint(g);
        int x = 10;
        int y = 175;
        g.drawRect(x, y, 50, 50); // FOR SQUARE
        g.drawLine(x + 50, y + 25, x + 100, y + 25);
        x += 100;
        g.drawRect(x, y, 50, 50); // FOR SQUARE
        y -= 100;
        g.drawRect(x, y, 50, 50); // FOR SQUARE
        y += 200;
        g.drawRect(x, y, 50, 50); // FOR SQUARE
        x += 100;
        g.drawRect(x, y, 50, 50); // FOR SQUARE
    }
}
