//21ce041 Sneha Jadeja
// Write a program to increment the value of one variable by one and display it after one second using thread using sleep() method.

class Mythread extends Thread {
    public static int counter = 0;

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }

    static void increment() {
        counter++;
    }
}

class pra_3 {
    public static void main(String[] args) {
        Mythread t1 = new Mythread();
        t1.start();
        System.out.println("Before increment is called the value of counter is : " + t1.counter);
        System.out.println("\nThread t1 sleep method called");
        try {
            t1.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        t1.increment();
        System.out.println("After increment is called the value of counter is : " + t1.counter);
    }
}


