package Main.AdditionalClasses.Demos;

import Main.AdditionalClasses.Utils.MathUtils;
import Main.Main;
import Main.OSLogic.InputHandler;

import java.awt.event.KeyEvent;

public class demoWriting {

    InputHandler inputHandler;
    char[] screen;
    long lastTime;
    long currentTime;
    boolean blink;
    int counter;

    public demoWriting(char[] screen, InputHandler inputHandler){
        this.screen = screen;
        lastTime = System.nanoTime();
        blink = false;
        counter = MathUtils.coordsToLinear(0,1, Main.XPixelCount);
        this.inputHandler = inputHandler;
    }


    public void runDemo() throws InterruptedException {
        lastTime = currentTime;
        currentTime = System.nanoTime();

        //Thread.sleep(1);

        if(blink){
            screen[counter] = '|';
            blink = false;
        }else{
            screen[counter] = ' ';
            blink = true;
        }

        demoFPSTest.currentFPS(screen,currentTime,lastTime);

        //demo.runDemo();

        KeyEvent keyEvent = inputHandler.getKeyEvent();

        if(keyEvent != null){

            if(keyEvent.getKeyChar() == '\b'){

                if(!blink){
                    screen[counter] = ' ';
                    blink = true;
                }

                screen[counter-1] = ' ';
                counter--;
            }else{
                char key = keyEvent.getKeyChar();
                screen[counter] = key;
                counter++;
            }
        }
    }
}
