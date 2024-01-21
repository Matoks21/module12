package main.java.task2;


public class NumberToConsoles {
    public static void main(String[] args) {
        NumbersToConsole t = new NumbersToConsole(15);


        Thread thread1 = new Thread(() -> {
            try {
                t.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread thread2 = new Thread(() -> {
            try {
                t.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread thread3 = new Thread(() -> {
            try {

                t.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread thread4 = new Thread(() -> {
            try {
                t.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


    }
}

