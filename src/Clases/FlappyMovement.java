package Clases;

import Interfaz.Game;

public class FlappyMovement extends Thread {

    private int deltaTime;
    private final Game parent;
    public static boolean stopThread;
    private double timeInit;
    private int yInit = 0;
    private static final int v0 = -30;
    private static final int ACCELERATION = 9;

    public FlappyMovement(Game parent) {
        this.deltaTime = 10;
        this.parent = parent;
    }

    @Override
    public void run() {
        stopThread = false;
        int x = Game.jFlappy.getLocation().x;
        yInit = Game.jFlappy.getLocation().y;
        timeInit = System.currentTimeMillis();
        while (true) {
            if (stopThread) {
                break;
            }
            double time = (System.currentTimeMillis() - timeInit) / 100.0f;
            int y = (int) (yInit + v0 * time + 0.5*ACCELERATION*time*time);
            Game.jFlappy.setLocation(x, y);
        }
        this.parent.detectColision();
    }

    public void jump() {
        timeInit = System.currentTimeMillis();
        yInit = Game.jFlappy.getLocation().y;
    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }

    public boolean isStopThread() {
        return stopThread;
    }

}
