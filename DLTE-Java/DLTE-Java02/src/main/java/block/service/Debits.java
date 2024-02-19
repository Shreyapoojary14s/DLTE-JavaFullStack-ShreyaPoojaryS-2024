package block.service;
import java.util.Scanner;

public class Debits {
    public static void main(String[] args){
        Integer Transaction=0,new_transaction=0,debits=0;
        Scanner sc= new Scanner(System.in);
        for(int i=0;i<10;i++){
            System.out.println("Enter the transaction");
            new_transaction=sc.nextInt();
            if(new_transaction<Transaction){
                debits+=1;
            }
            Transaction= new_transaction;
        }
        System.out.println(debits+" ,times debits have taken place1");



    }

}
