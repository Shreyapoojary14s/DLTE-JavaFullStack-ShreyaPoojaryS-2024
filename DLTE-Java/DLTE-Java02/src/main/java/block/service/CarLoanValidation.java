package block.service;
import com.sun.org.apache.xpath.internal.objects.XBoolean;
import sun.awt.windows.WPrinterJob;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarLoanValidation {
    public static void main(String[] args) {
        String borrowerName = "", borrowerPan = "", borrowerAdress = "", borrowerEmail = "", borrowerIncomeType = "";
        //Long aadhaar = 0L, mobile = 0L;
        String aadhaar = "", mobile = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("*******Welcome to My Bank*********");
        // Pattern pattern=Pattern.compile()

        System.out.println("Please fill the required details to apply for a car loan");
        System.out.println("Enter your name provided with initial name");
        borrowerName = scanner.next();
        Pattern pattern = Pattern.compile("^[a-zA-Z]+[A-Za-z]+$");
        Matcher matcher = pattern.matcher(borrowerName);
        while (!validate(borrowerName, pattern)) {
            System.out.println("Please provide valid name");
            borrowerName = scanner.nextLine();

        }

        System.out.println("Enter your aadhaaar");
        aadhaar = scanner.nextLine();
        pattern = Pattern.compile("^\\d{12}$");
         matcher = pattern.matcher(aadhaar);
        while (!validate(aadhaar, pattern)) {
            System.out.println("Please provide valid aadhaar number");
            aadhaar = scanner.nextLine();

        }

        System.out.println("Enter your Pan");
        borrowerPan = scanner.nextLine();
        pattern = Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]{1}$");
        matcher = pattern.matcher(borrowerPan);
        while (!validate(borrowerPan, pattern)) {
            System.out.println("Please provide valid Pan number");
            borrowerPan = scanner.nextLine();


        }
        System.out.println("Enter your registered Mobile no.");
        mobile = scanner.nextLine();
        pattern = Pattern.compile("^\\d{10}$");
         matcher = pattern.matcher(mobile);
        while (!validate(mobile, pattern)) {
            System.out.println("Please provide valid mobile number");
            mobile = scanner.nextLine();

        }
        System.out.println("Enter your Email ID registered at tietoevry ex:xyz@tietoevry.com");
        borrowerEmail = scanner.nextLine();
        pattern = Pattern.compile("^[0-9A-Za-z]+@tietoevry.com$");
        matcher = pattern.matcher(borrowerEmail);
        while (!validate(borrowerEmail, pattern)) {
            System.out.println("Please provide valid email ID");
            borrowerEmail = scanner.nextLine();

        }

        System.out.println("Thank you");
    }


    //validate
    static boolean validate(String val, Pattern pattern) {
        Matcher matcher = pattern.matcher(val);
        return matcher.matches();
    }
}




       /* while(true){
            Scanne scanner=new Scanner(System.in);
            System.out.println("*******Welcome to My Bank*********");


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
}*/
