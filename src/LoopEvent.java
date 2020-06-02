import java.awt.event.KeyEvent;

public class LoopEvent implements Runnable{
    private int time;
    private Robot robot;
    private Boolean isPlaying=false;
    LoopEvent(Robot robot, int time){
        this.robot = robot;
        this.time = time;
    }

    public void relp(int time){
        isPlaying = false;
        this.time = time;
        isPlaying = true;
    }

    @Override
    public void run() {
        System.out.printf("asd\n");
        while (true) {
            if (isPlaying) {
                try {
                    Thread.sleep(time * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                robot.robot.keyPress(KeyEvent.VK_F5);
                robot.robot.keyRelease(KeyEvent.VK_F5);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
