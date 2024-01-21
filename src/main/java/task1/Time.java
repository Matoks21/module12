package main.java.task1;

import java.time.LocalDateTime;

public class Time {

    private int counter = 1;

    public synchronized void clockDisplaysTheTime() throws InterruptedException {

        while (true) {
            System.out.println(Thread.currentThread().getName() + "  " + LocalDateTime.now());
            Thread.sleep(1000);
            counter++;

            if (counter % 5 == 0) {
                System.out.println(Thread.currentThread().getName() + "  " + LocalDateTime.now());
                notifyAll();
                wait(1000);
            }
        }
    }

    public synchronized void fiveSecondsHavePassed() throws InterruptedException {

        while (true) {
            System.out.println(Thread.currentThread().getName() + "  " + "5 second have passed");
            counter++;

            if (counter % 5 == 1) {
                wait();
            }
        }
    }
}

