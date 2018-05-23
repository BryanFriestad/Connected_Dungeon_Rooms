package engine;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

    private GameContainer gc;

    private final int NUM_OF_KEYS = 256;
    private boolean[] keys = new boolean[NUM_OF_KEYS];
    /**
     * the status of the keys on the previous frame
     */
    private boolean[] keys_previous = new boolean[NUM_OF_KEYS];

    private final int NUM_OF_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUM_OF_BUTTONS];
    /**
     * the status of the mouse buttons on the previous frame
     */
    private boolean[] buttons_previous = new boolean[NUM_OF_BUTTONS];

    private int mouseX, mouseY;
    /**
     * 0 if wheel is not being scrolled, -1 if scrolling up, +1 if scrolling down
     */
    private int scroll;

    public Input(GameContainer gc){
        this.gc = gc;
        mouseX = 0;
        mouseY = 0;
        scroll = 0;

        gc.getWindow().getCanvas().addKeyListener(this);
        gc.getWindow().getCanvas().addMouseListener(this);
        gc.getWindow().getCanvas().addMouseMotionListener(this);
        gc.getWindow().getCanvas().addMouseWheelListener(this);
    }

    public void update(){
        scroll = 0; //reset scroll to 0

        for(int i = 0; i < NUM_OF_KEYS; i++){
            keys_previous[i] = keys[i];
        }
        for(int i = 0; i < NUM_OF_BUTTONS; i++){
            buttons_previous[i] = buttons[i];
        }
    }

    public boolean isKeyDown(int key_code){
        return keys[key_code];
    }

    public boolean isKeyPressed(int key_code){
        return keys[key_code] && !keys_previous[key_code];
    }

    public boolean isKeyReleased(int key_code){
        return !keys[key_code] && keys_previous[key_code];
    }

    public boolean isButtonDown(int button_code){
        return buttons[button_code];
    }

    public boolean isButtonPressed(int button_code){
        return buttons[button_code] && !buttons_previous[button_code];
    }

    public boolean isButtonReleased(int button_code){
        return !buttons[button_code] && buttons_previous[button_code];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = (int) (e.getX()/gc.getScale());
        mouseY = (int) (e.getY()/gc.getScale());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = (int) (e.getX()/gc.getScale());
        mouseY = (int) (e.getY()/gc.getScale());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        scroll = e.getWheelRotation();
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public int getScroll() {
        return scroll;
    }
}
