package com.rahj;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.atomic.AtomicBoolean;

public class RobotThread implements Runnable
{
    private AtomicBoolean atomicBoolean = new AtomicBoolean();
    private Thread myThread;
    private Robot hal;

    public RobotThread()
    {
        try {
            this.hal = new Robot();
        } catch (AWTException awtEx) {
            System.out.println(awtEx.getMessage());
        }
    }

    @Override
    public void run()
    {
        while(this.atomicBoolean.get()) {
            this.hal.delay(1000 * 10);

            this.hal.keyPress(KeyEvent.VK_F5);
            this.hal.keyRelease(KeyEvent.VK_F5);
        }
        System.out.println("Thread Stopped");
    }

    public void start()
    {
        this.atomicBoolean.set(true);

        this.myThread = new Thread(this);
        this.myThread.start();
    }

    public void stop()
    {
        this.atomicBoolean.set(false);
        //Thread.currentThread().interrupt();
    }


}
