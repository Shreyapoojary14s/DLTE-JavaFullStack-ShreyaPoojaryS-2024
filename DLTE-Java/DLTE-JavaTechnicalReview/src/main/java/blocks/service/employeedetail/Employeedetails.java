package blocks.service.employeedetail;

import blocks.service.Employee;
import blocks.service.EmployeeAddress;
import blocks.service.EmployeeRepository;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmployeeDetails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int option;
        EmployeeRepository employeeRepository=new EmployeeRepository();
      //  EmployeeDetails employeeDetails= new EmployeeDetails();

        ArrayList<Employee> arrayemp=new ArrayList<>();
        System.out.println("*************** Wel Come ******************");
        System.out.println("Enter number of Employees");
        int numberOfEmployees = scanner.nextInt();
        Employee[] employees = new Employee[numberOfEmployees];
        System.out.println("Enter your choice:\n1.Enter employee details\n2.Display employee details\n3.Exit");
        option=scanner.nextInt();

        switch (option){
            case 1 :
                    for (int index=0;index<numberOfEmployees;index++) {
                        employees[index]=readEmployee();
                        arrayemp.add(employees[index]);
                }
                employeeRepository.writeIntoFile(arrayemp);
                    break;



            case 2:
                // System.exit(0);
//                System.out.println("Enter number of Employees");
//                int numberOfEmployees = scanner.nextInt();
//                Employee[] empk = new Employee[numberOfEmployees];
             //   ArrayList<Employee>=new ArrayList<>();

                   try{
                      // employeeDetails.displayDetails(employees);
                     // employeeRepository.writeIntoFile(arrayemp);
                      ArrayList<Objects>emp;
                      emp=employeeRepository.readFromFile();
                       System.out.println(emp.size());
                       System.out.println(emp);
                   }
                   catch(Exception e ){
                System.out.println("No Employee details to display");
            }

            case 3:
                System.exit(0);
            default:
                System.out.println("Invalid choice");

        }

    }


    public static Employee readEmployee() {
        Employee employee = new Employee();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the employee ID");
        employee.setEmployeeID(scanner.nextLong());
        System.out.println("Enter the name of the employee");
        employee.setEmployeeName(employeeName());
        System.out.println("Enter the mobile number");
        employee.setEmployeeMobile(scanner.nextLong());
        System.out.println("Enter the email ID");
        employee.setEmployeeEmail(scanner.next());
        while (!isValidEmail(employee.getEmployeeEmail())) {
            System.out.println("Invalid Email! Enter valid email");
            employee.setEmployeeEmail(scanner.next());
        }
        System.out.println("Enter the temporary address");
        employee.setEmployeeTemporaryAddress(employeeAddress());
        System.out.println("Enter the permanent address");
        employee.setEmployeePermanentAddress(employeeAddress());
        return employee;
    }

    public static String employeeName() {
        String employeeFirstName, employeeMiddleName, employeeLastName;
        String name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("First Name : ");
        employeeFirstName = scanner.nextLine();
        System.out.print("Middle Name : ");
        employeeMiddleName = scanner.nextLine();
        System.out.print("Last Name : ");
        employeeLastName = scanner.nextLine();
        name = employeeFirstName+" "+employeeMiddleName+" "+employeeLastName;
        return name;
    }

    public static EmployeeAddress employeeAddress() {
        EmployeeAddress employeeAddress = new EmployeeAddress();
        Scanner scanner = new Scanner(System.in);
        System.out.print("House no./name: ");
       employeeAddress.setHomeAddress(scanner.nextLine());
        System.out.print("Area : ");
        employeeAddress.setArea(scanner.nextLine());
        System.out.print("City : ");
        employeeAddress.setCity(scanner.nextLine());
        System.out.print("State : ");
        employeeAddress.setState(scanner.nextLine());
        System.out.print("PinCode : ");
        employeeAddress.setPincode(scanner.nextLong());
        return employeeAddress;
    }
    public static void displayDetails(Employee[] employees) {
        for (int employee=0;employee<employees.length;employee++) {
            Employee check = employees[employee];
            System.out.println("Employee Details of employee "+(employee+1));
            System.out.println("Employee ID: "+ check.getEmployeeID());
            System.out.println("Employee Name: "+check.getEmployeeName());
            System.out.println("Employee Email: "+check.getEmployeeEmail());
            System.out.println("Employee Mobile No.: "+check.getEmployeeMobile());
            System.out.println("Employee Temporary Address: "+check.getEmployeeTemporaryAddress());
            System.out.println("Employee Permanent Address: "+check.getEmployeePermanentAddress());
        }
    }
    public static Boolean isValidEmail(String borrowerEmail) {
        String emailExpression = "^[A-Za-z0-9+_.-]+@[a-zA-Z]{3,}+\\.[a-z]{2,}";
        Pattern pattern = Pattern.compile(emailExpression);
        Matcher matcher = pattern.matcher(borrowerEmail);
        return matcher.matches();

    }




}
