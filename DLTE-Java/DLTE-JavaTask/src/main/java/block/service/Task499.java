package block.service;

public class Task499 {
    public static void main(String[] args) throws InterruptedException{
        Transactionananlysis transactionananlysis=new Transactionananlysis();
        Thread thread1=new Thread(transactionananlysis,"Harshitha");
        thread1.start();thread1.join();
        Thread thread2=new Thread(transactionananlysis,"Srusti");
        thread2.start();
        Thread thread3=new Thread(transactionananlysis,"Deepika");
        thread3.start();
        Thread thread4=new Thread(transactionananlysis,"Shreya");
        thread4.start();



    }
}
