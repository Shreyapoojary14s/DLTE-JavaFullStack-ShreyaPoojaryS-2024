package basics.service;

import java.util.Scanner;
//Internet banking:collecting user and to details
public class InternetBanking {
    public static void main(String[] args){
        String userName="",userPassword="",userEmail="";
        Long userOtp=0L,amount=0L,toMobileNo=0L, authOTP=0L, userMobileNo,accountNo=0L;

        Scanner scanner=new Scanner(System.in);
        System.out.println("*********Welcome to internet banking**********");
        System.out.println("Enter your name");
        userName=scanner.nextLine();
        System.out.println("Enter the mobile number");
        userMobileNo=scanner.nextLong();
        System.out.println("Enter the OTP sent to your registered mobile number "+userMobileNo);
        userOtp=scanner.nextLong();
        System.out.println("Enter the Email Id");
        userEmail=scanner.next();
        //authentication
        System.out.println("For the 2-step verification, enter the OTP sent to "+userEmail);
        authOTP=scanner.nextLong();
        System.out.println("Enter the amount to be transferred");
        amount=scanner.nextLong();
        System.out.println("Enter the account number to be transferred");
        accountNo=scanner.nextLong();
        System.out.println("Enter the PIN");
        userPassword=scanner.next();
        System.out.println("Amount of "+amount+" has been successfully transferred to "+accountNo);




    }
}
