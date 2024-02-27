package block.service;
import java.util.Scanner;

public class Debits {
    public static void main(String[] args){
        Integer Transaction=0,newTransaction=0,debits=0;
        Scanner sc= new Scanner(System.in);
        for(int i=0;i<10;i++){
            System.out.println("Enter the transaction");
            newTransaction=sc.nextInt();
            if(newTransaction<Transaction){
                debits+=1;
            }
            Transaction= newTransaction;
        }
        System.out.println(debits+" ,times debits have taken place1");



    }

}
