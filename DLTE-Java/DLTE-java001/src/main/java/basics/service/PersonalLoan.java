package basics.service;
import java.util.Scanner;

public class PersonalLoan {
    public static void main(String[] args){
        //initialize
        Long lenderMobileNo=0L, aahdaar=0L;
        String lenderName="",lenderAddress="",lenderEmail="",lenderPan="",incomeType="",needOfLoan="";
        Scanner scanner=new Scanner(System.in);

        System.out.println("******Welcome to MYBANK******");
        System.out.println("Please provide the deatails required for personal loan application");
        //user deatils
        System.out.println("Enter your name");
        lenderName=scanner.nextLine();
        System.out.println("Enter your mobile number");
        lenderMobileNo=scanner.nextLong();
        System.out.println("Enter your email ID");
        lenderEmail=scanner.next();
        System.out.println("Enter your current address");
        lenderAddress=scanner.next();
        System.out.println("Enter your Aadhaar number");
        aahdaar=scanner.nextLong();
        System.out.println("Enter the Pan Number");
        lenderPan=scanner.next();
        System.out.println("Enter your income type");
        incomeType=scanner.next();
        System.out.println("Reason behind the loan");
        needOfLoan=scanner.next();

        System.out.println("Thanks for your patience");
        System.out.println("Your application status will be informed soon");



    }
}
