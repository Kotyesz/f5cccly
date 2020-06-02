import java.awt.*;
import java.awt.event.KeyEvent;

public class Robot {
    private Loop loop;

    Robot(){
        loop = new Loop(this);
    }

    java.awt.Robot robot;{
        try {
            robot = new java.awt.Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }}

    public void loop(int sec) {
        loop.loop(sec);
    }
}
