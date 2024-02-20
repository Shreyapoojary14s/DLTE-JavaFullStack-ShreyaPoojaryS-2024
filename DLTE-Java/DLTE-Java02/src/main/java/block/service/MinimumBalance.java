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
            // fine
            balance=balance/1.3;
            System.out.println("You have not maintained min balance");

            System.out.println(" In addition to fine ,Your current bal is " +balance);
        }
        else if(balance>=1000 && balance<25000){
            // fine
            balance=balance/1.1;
            System.out.println("You have not maintained min balance");

            System.out.println(" In addition to fine ,Your current bal is " +balance);
        }
        else{

            System.out.println("Thank you for maintaining account in MYBANK ");
            System.out.println(("Your current balance is "+ balance));

        }

    }
}
