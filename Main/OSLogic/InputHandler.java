package Main.OSLogic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

    KeyEvent keyEvent;
    Boolean readKey = true;

    @Override
    public void keyTyped(KeyEvent e) {
        keyEvent = e;
        readKey = false;

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //lastKeyEvent = null;
    }

    public KeyEvent getKeyEvent(){
        if(!readKey){
            readKey = true;
            return keyEvent;
        }else{
            return null;
        }

    }
}
