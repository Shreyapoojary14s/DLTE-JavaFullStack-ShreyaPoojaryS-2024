package blocks.service;

import java.util.Scanner;

public class EmpDetails {
    public static void main(String[] args){
        String empFirstName,empLastName,empMiddleName,permanentAddress,tempHouseName,tempstreet,tempCity,tempLandMark;
        Long employeeMobile=0L,temppin=0L;

    }
    public voiclass EmpInput{

        Scanner scanner=new Scanner(System.in);
        System.out.println("------welcome ------");
        System.out.println("Enter First Name");
        empFirstName=scanner.nextLine();
        System.out.println("Enter Middle Name");
        empMiddleName=scanner.nextLine();
        System.out.println("Enter Last Name");
        empLastName=scanner.nextLine();
        System.out.println("Enter your mobile number");
        employeeMobile=scanner.nextLong();
        System.out.println("Enter House Name");
        tempHouseName=scanner.next();
        System.out.println("Enter landmark");
        tempLandMark=scanner.next();
        System.out.println("Enter Street");
        tempstreet=scanner.next();
        System.out.println("Enter City");
        tempCity=scanner.next();
        System.out.println("Pin code");
        temppin=scanner.nextLong();

    }
}
