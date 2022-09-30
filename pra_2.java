  //21ce041 Sneha Jadeja
// Generate 15 random numbers from 1 to 100 and store it in an int array. Write a program to display the numbers stored at odd indexes by thread1 and display numbers stored at even indexes by thread2.

import java.util.Scanner;

class DistributedSummation extends Thread {
    public static int sum = 0;
    public static int assignedNumbers;
    public int startNumber;
    public int endNumber;

    public void setValue(int a, int b) {
        startNumber = a;
        endNumber = b;
    }

    synchronized public void sum() {
        for (int i = startNumber; i < endNumber; i++) {
            sum += i;
        }
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running");
    }

}

public class pra_2 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number upto you wanna find sum: ");
        int n = scan.nextInt();
        System.out.println("Enter the no. of threads you want to sum " + n + " nos. :");
        int numberOfThreads = scan.nextInt();
        scan.close();
        int numberTracker = 1;

        DistributedSummation[] t = new DistributedSummation[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            t[i] = new DistributedSummation();
        }

        DistributedSummation.assignedNumbers = n / numberOfThreads;
        int remainingNumbers = n % numberOfThreads;
        for (int i = 0; i < numberOfThreads; i++) {
            t[i].start();
            t[i].setValue(numberTracker, DistributedSummation.assignedNumbers * (i + 1));
            numberTracker = DistributedSummation.assignedNumbers * (i + 1);
        }
        for (int i = 0; i < numberOfThreads; i++) {
            t[i].sum();
        }
        if (remainingNumbers != 0) {
            t[0].setValue(numberTracker + 1, n + 1);
            t[0].sum();
        }
        if (remainingNumbers != 0)
            System.out.println("The sum of the " + n + " numbers using " + numberOfThreads + " is "
                    + (DistributedSummation.sum + n - remainingNumbers));
        else
            System.out.println("The sum of the " + n + " numbers using " + numberOfThreads + " is "
                    + (DistributedSummation.sum + n));
    }
}


