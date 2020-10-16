package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passngers extends Thread {


    private int passngerNumber;
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;


    public Passngers(int passngerNumber, Semaphore semaphore,
                     CountDownLatch countDownLatch) {
        this.passngerNumber = passngerNumber;
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(passngerNumber + "подхотит к кассе ");
            Thread.sleep(5000);

            System.out.println(passngerNumber + "покупет билет ");
            semaphore.release();
            Thread.sleep(4000);
            countDownLatch.countDown();

            System.out.println(passngerNumber + "подходит к автобусу и выберает место ");
            Thread.sleep(5000);
            countDownLatch.countDown();
            System.out.println("Автобус двинется когда заполнеться ");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
