package blocks.service;


import java.util.Scanner;

public class EmployeeDetails {
    public static void main(String[] args){
    EmployeeDetails employeeDetails=new EmployeeDetails();
    employeeDetails.collectDetails();
    }
    public Employee collectDetails(){
        //employee details
        String firstName,lastName,middleName,email,employeeId,current,permanent;
        //Employee employee=new Employee();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the details");
        System.out.println("First name");
        firstName=scanner.next();
        System.out.println("middle name");
        middleName=scanner.next();
        System.out.println("last name");
        lastName=scanner.next();
        System.out.println("email id");
        email=scanner.next();
        /*System.out.println("house name");
        System.out.println("street name");

        System.out.println("");*/


        System.out.println("employee id");
        employeeId=scanner.next();
        System.out.println("current address");
        current=address();
        System.out.println("permanent address");
        permanent=address();

        return new Employee( firstName,middleName, lastName, email, employeeId, current,permanent);
    }

    public String address(){
        //Address details
        String houseName,city,pinCode,street,combine;
        Scanner scanner=new Scanner(System.in);
        System.out.println("house name");
        houseName=scanner.next();
        System.out.println("street name");
        street=scanner.next();
        System.out.println("city");
        city=scanner.next();
        System.out.println("pincode");
        pinCode=scanner.next();
       return combine=houseName+street+city+pinCode;
    }
/*public String display(){
    System.out.println("Name:"+);
}*/


   /* private String empFirstName;
    private String empLastName;
    private String empMiddleName*/
   //public String Employee display{



}






