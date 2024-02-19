package basics.service;
import java.util.Scanner;
// command line interactions : for car loan
/*
personal details: name aadhaar, pan ,address,mobile, email
Income :salarised, self employment :ITR
 */
public class Interactions {
    public static void main(String[] args){
        String borrowerName="" , borrowerPan="", borrowerAddress="", borrowerEmail ="", borrowerIncomeType="";
        Long mobileNumber=0L ,aadhaar=0L;
        Scanner scanner=new Scanner(System.in);
        System.out.println("----------Wecome to MyBank---------");

        System.out.println("Fill your name");
        borrowerName=scanner.nextLine();
        System.out.println("Fill your aadhaar number");
        aadhaar=scanner.nextLong();
        System.out.println("enter the pan");
        borrowerPan=scanner.next();
        System.out.println("let us know income type");
        borrowerIncomeType=scanner.next();
        System.out.println("Mobile number");
        mobileNumber=scanner.nextLong();
        System.out.println("Email address");
        borrowerEmail=scanner.next();

        System.out.println(" Dear "+borrowerName+"Thanks for showing intrest on taking car loan in  My bank Your app is submitted and futher info will be emailed"+borrowerEmail+"to mobile number"+mobileNumber);
    }
}
