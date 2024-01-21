package main.java.task2;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Завдання 2
Напишіть програму, що виводить в консоль рядок, що складається з чисел від 1 до n, але з заміною деяких значень:

якщо число ділиться на 3 - вивести fizz
якщо число ділиться на 5 - вивести buzz
якщо число ділиться на 3 і на 5 одночасно - вивести fizzbuzz
Наприклад, для n = 15, очікується такий результат: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.

Програма повинна бути багатопотоковою, і працювати з 4 потоками:

Потік A викликає fizz(), щоб перевірити, чи ділиться число на 3,
і якщо так - додати в чергу на виведення для потоку D рядок fizz.
Потік B викликає buzz(), щоб перевірити, чи ділиться число на 5,
і якщо так - додати в чергу на виведення для потоку D рядок buzz.
Потік C викликає fizzbuzz(), щоб перевірити, чи ділиться число на 3 та 5 одночасно,
 і якщо так - додати в чергу на виведення для потоку D рядок fizzbuzz.
Потік D викликає метод number(), щоб вивести наступне число з черги, якщо є таке число для виведення.
 */
public class NumbersToConsole {

    private final Lock lock = new ReentrantLock();
    private final int n;
    private int counter = 1;

    public NumbersToConsole(int n) {
        this.n = n;
    }

    public void number() throws InterruptedException {
        while (counter < n) {
            lock.lock();
            if (counter % 3 != 0 && counter % 5 != 0) {
                System.out.print(counter + ",  ");
                counter++;
            }
            lock.unlock();
        }
    }

    public void fizz() throws InterruptedException {
        while (counter < n) {
            lock.lock();
            if (counter % 3 == 0 && counter % 5 != 0) {
                System.out.print("fizz" + ",  ");
                counter++;
            }
            lock.unlock();
        }
    }

    public void buzz() throws InterruptedException {
        while (counter < n) {
            lock.lock();
            if (counter % 5 == 0 && counter % 3 != 0) {
                System.out.print("buzz" + ",  ");
                counter++;
            }
            lock.unlock();

        }
    }

    public void fizzbuzz() throws InterruptedException {
        while (counter <= n) {
            lock.lock();
            if (counter % 3 == 0 && counter % 5 == 0) {
                System.out.print("fizzbuzz" + " .");
                counter++;
            }
            lock.unlock();

        }
    }
}



