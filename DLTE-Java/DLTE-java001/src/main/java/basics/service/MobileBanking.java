package basics.service;

import java.util.Scanner;

public class MobileBanking {
    public static void main(String[] args){
        String UserPin="", DeinationName="" ;
        Long OTP=0L, Amount=0L,UPI=0L ,DestinationAccountNo=0L,DestPhoneNo=0L;
        Scanner sc =new Scanner(System.in);
        System.out.println("------Welcome to MY MOBILE BANKING------");
        System.out.println("Enter PIN");
        UserPin=sc.nextLine();
        System.out.println("---Enter Recipient Details---");
        System.out.println("Enter name");
        DeinationName=sc.nextLine();

        System.out.println("Account number");
        DestinationAccountNo=sc.nextLong();
        System.out.println("Phone number");
        DestPhoneNo=sc.nextLong();
        System.out.println("Enter the amount");
        Amount=sc.nextLong();
        System.out.println("Enter the UPI");
        UPI=sc.nextLong();
        System.out.println("The Amount of"+Amount+" is transferred to account no."+DestinationAccountNo+" is successfull");


    }
}
