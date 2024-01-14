package lab2aii;

public class Lab2aii extends Thread {
    public void run(){
        System.out.println("Thread is running .....");
    }
    public static void main(String[] args) {
        Lab2aii t1 = new Lab2aii();
        t1.start();
        Lab2aii t2 = new Lab2aii();
        t2.start();
    }
}
