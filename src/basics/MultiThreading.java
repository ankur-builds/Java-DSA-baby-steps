/*
 * Copyright (c) 2021.
 * File : MultiThreading.java
 * Author : Ankur
 * Last modified : 6/7/2021
 * Problem Statement at the end of the code
 *
 * All code is for practice purpose only and strictly non-commercial.
 * All rights reserved.
 * Please refer to apache license terms in the project.
 */

package basics;

/**
 * Two ways to implement multi-threading -
 *      By extending Thread class
 *      By implementing Runnable interface and passing runnable object to Thread class constructor
 *
 * Note that here parent thread is main. But it will depend on which thread, new thread is 'started'
 *
 * You can also set Thread name using setName and get Thread name using getName
 *
 * join is really handy to execute independent logic in a method parallelly. Much better than using Thread.sleep to wait
 * for thread to complete execution.
 *
 * synchronized method ensures that only one thread can execute logic in method. This is what is used for Thread safety
 */
public class MultiThreading {
    public static void main(String[] args) throws Exception{
        MyThreadI t1 = new MyThreadI();
        MyThreadII t2 = new MyThreadII();
        Runnable run = new MyThreadIII();
        Thread t3 = new Thread(run); // You need thread object to use runnable object

        // You can also use lambda expression to avoid creating Runnable object
        Thread t4 = new Thread(()->{
            for(int i = 1; i<=3; ++i){
                System.out.println("(4) " + Thread.currentThread() + " of 4th Thread !!!");
                try{ Thread.sleep(100);}
                catch(Exception e) {
                    System.out.println(e);
                }
            }
        });

        System.out.println(Thread.currentThread());
        System.out.println(t1.getPriority() + " " + t2.getPriority());
        System.out.println("------------------------");
        // This will start a new thread different from thread "main"
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Important : If you want to wait for threads to complete execution before proceeding forward, use join
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        // So here main thread will wait for all the threads that are mentioned in join before moving forward.
        System.out.println("------------------------");

        // You can also check if thread is alive by using isAlive() method
        System.out.println("Is t1 alive : " + t1.isAlive());
        System.out.println("Bye");
    }
}

class MyThreadI extends Thread{
    public void run(){
        for(int i = 1; i<=3; ++i) {
            System.out.println("(1) "+Thread.currentThread() + " of MyThreadI class ***");
            try { Thread.sleep(500);}
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyThreadII extends Thread{
    public void run(){
        for(int i = 1; i<=3; ++i) {
            System.out.println("(2) " + Thread.currentThread() + " of MyThreadII class ###");
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class MyThreadIII implements Runnable{
    @Override
    public void run(){
        for(int i = 1; i<=3; ++i) {
            System.out.println("(3) " + Thread.currentThread() + " of MyThreadIII class $$$");
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}