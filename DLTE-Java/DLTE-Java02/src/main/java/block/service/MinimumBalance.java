package block.service;

import java.util.Scanner;

public class MinimumBalance {
    public static void main(String[] args){
        //check who has min balance
        Scanner sc=new Scanner(System.in);
        double balance=0, fine=0;

        System.out.println("Enter your balance");
        balance= sc.nextDouble();
        
        //lets have condition to maintain min bal. of 10k
        if(balance>0 && balance<1000){
            // fine of 5%
            balance=balance/0.05;
            System.out.println("Your current bal is"+balance);
        }

    }
}
