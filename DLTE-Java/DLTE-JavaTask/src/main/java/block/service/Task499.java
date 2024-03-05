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
        Thread thread5=new Thread(transactionananlysis,"Lala");
        thread5.start();
        Thread thread7=new Thread(transactionananlysis,"Soorkie");
        thread7.start();
        Thread thread8=new Thread(transactionananlysis::displayAllRemarks,"Alisha");
        thread8.start();
        Thread thread9=new Thread(transactionananlysis::displayTransactionToWhom,"shraddha");
        thread9.start();
        Thread thread10=new Thread(transactionananlysis::displayAllAmount,"Kumar");
        thread10.start();

    }
}
