package lab2a;

public class Lab2a implements Runnable{
    public void run(){
        System.out.println("Thread is running...");
    }

    public static void main(String[] args) {
        
        Lab2a t1=new Lab2a();
        Thread T=new Thread(t1);
        T.start();  
        Lab2a t2=new Lab2a();
        Thread T1=new Thread(t2);
        T1.start();
        Lab2a t3=new Lab2a();
        Thread T2=new Thread(t3);
        T2.start();
    }
}
