package blocks.service;

import java.util.Scanner;

public class MyBank {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        Double paymentAmount;
        Integer pinsecond,pinCard;
        int choice;
        Gpay gpay=new Gpay();
        while(true){
            System.out.println("Welcome to MYBANK services");
            System.out.println("enter your choice\t:\t1.Withdraw money\t\t\t2.Make payement");
            choice=scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter a valid pin");
                    pinCard=scanner.nextInt();
                    if(gpay.validatePin(pinCard)){
                        System.out.println("Enter amount");
                        Double withdrawAmount = scanner.nextDouble();
                        gpay.makeWithdraw(withdrawAmount);

                    }
                    else{
                        System.out.println("Invalid Pin");
                    }
                    break;
                case 2:
                    System.out.println("Enter a valid pin");
                    pinsecond=scanner.nextInt();
                    if(gpay.validatePin(pinsecond)){
                        System.out.println("Enter the amount");
                        paymentAmount=scanner.nextDouble();
                        gpay.makePayment(paymentAmount);
                    }else{
                        System.out.println("Invalid pin");
                    }
                    break;
                default:break;
            }
        }
    }
}
