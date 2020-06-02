public class Loop extends Thread {
    private Robot robot;
    private int time = 5;
    private Thread th;
    private boolean isPlaying = false;
    public void setSec(int time){this.time = time*1000;}
    private LoopEvent event;
    public void loop(int time){
        this.time = time;
        event.relp(time);
    }
    Loop(Robot robot){
        this.robot = robot;
        event = new LoopEvent(robot,time);
        th = new Thread(event);
        th.start();
    }

}
