package block.service;
import sun.awt.windows.WPrinterJob;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CarLoanValidation {
    public static void main(String[] args){
        String borrowerName="", borrowerPan="",borrowerAdress="",borrowerEmail="",borrowerIncomeType="";
        Long aadhaar=0L,mobile=0L;
        Scanner scanner=new Scanner(System.in);
        System.out.println("*******Welcome to My Bank*********");


        while(true){
            Scanne scanner=new Scanner(System.in);
            System.out.println("*******Welcome to My Bank*********");

            System.out.println("Please fill the required details to apply for a car loan");
            System.out.println("Enter your name provided with initial name");
            borrowerName=scanner.next();
        Pattern pattern=Pattern.compile("^[a-zA-Z]+\\s[A-Za-z]+$");
        Matcher matcher =pattern.matcher(borrowerName);
        if(matcher.matches()){

            System.out.println("sername\t]"+borrowerName+"tis invalid");
            break;
        }}

        System.out.println("Enter your mobile number");
        mobile = scanner.nextLong();
        Pattern pattern5=Pattern.compile("^\\d{10}$");
        String value1=String.valueOf(mobile);
        Matcher matcher5 =pattern5.matcher(value1);
        if(matcher5.matches()){
            System.out.println("username"+mobile+"\tis valid");
        }
        else{
            System.out.println("username"+mobile+"\tis invalid");
        }




        System.out.println("Enter the email ID");
        borrowerEmail=scanner.next();
        System.out.println("Enter the PAN Number");
        borrowerPan=scanner.next();
        Pattern pattern3=Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]$");
        Matcher matcher3 =pattern3.matcher(borrowerPan);
        if(matcher3.matches()){
            System.out.println("username"+borrowerPan+"\tis valid");
        }
        else{
            System.out.println("username"+borrowerPan+"\tis invalid");
        }




        System.out.println("Enter your Income Type");
        borrowerIncomeType=scanner.next();
        System.out.println("Please provide the detailed address");
        borrowerAdress=scanner.next();


        System.out.println("Enter your Aadhaar number");
        aadhaar=scanner.nextLong();
        Pattern pattern1= Pattern.compile("^\\d{12}");
        String value=String.valueOf(aadhaar);
        Matcher matcher1 =pattern1.matcher(value);
        if(matcher1.matches()){
            System.out.println("username"+aadhaar+"\tis valid");
        }
        else{
            System.out.println("username"+aadhaar+"\tis invalid");
        }



        
    }
}
