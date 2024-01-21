package main.java.task1;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Times  {

    public static void main(String[] args) {
        Time time=new Time();
        ExecutorService executor= Executors.newFixedThreadPool(2);
        executor.execute(() -> {
            try {
                time.clockDisplaysTheTime();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            try {
                time.fiveSecondsHavePassed();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
      executor.shutdown();
        }
    }

