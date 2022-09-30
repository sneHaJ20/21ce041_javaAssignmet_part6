//21ce041 Sneha Jadeja
// Write a program to create thread which display “Hello World” message. A. by extending Thread class B. by using Runnable interface

class ThreadDemo extends Thread {
    public void run() {
        System.out.println("Hello World from Thread class");
    }
}

class RunnableDemo implements Runnable {

    public void run() {
        System.out.println("Hello World from Runnable Interface");
    }
}

public class pra_1 {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        Thread rd = new Thread(new RunnableDemo());
        td.start();
        rd.start();
    }
}
