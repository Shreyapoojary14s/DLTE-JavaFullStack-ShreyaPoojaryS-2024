package blocks.service;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

    public class EmployeeDetails extends CollectCheckData {
        Address temporaryAddress;
        Address permanentAddress;
        static Scanner scanner=new Scanner(System.in);
        public static void main(String[] args) {
            EmployeeDetails employeeDetails=new EmployeeDetails();
            ArrayList<Object> arrayEmployee=new ArrayList<>();
            ReadWriteEmployee readWriteEmployee=new ReadWriteEmployee();
            //int choice;
            while(true){
                int option;
                System.out.println("Enter choice\n1 : Adding new employee\n2 : Displaying employee details\n3 : Exit");
                option=scanner.nextInt();
                switch (option){
                    case 1:
                        Employee employee1=new Employee();
                        System.out.println("Employee details:");
                        arrayEmployee=readWriteEmployee.readFromFile();
                        employeeDetails.collectPersonalData(employee1);
                        arrayEmployee.add(employee1);
                        System.out.println(arrayEmployee.size());
                        readWriteEmployee.writeIntoFile(arrayEmployee);
                        break;
                    case 2:employeeDetails.displayData();
                        break;
                    case 3: System.exit(0);
                    default :
                        System.out.println("Invalid choice ,Exiting..!");
                        System.exit(0);
                }
            }
        }

        @Override
        public void collectPersonalData(Employee employee1) {
            try {
                EmployeeDetails employeeDetails = new EmployeeDetails();
                //name
                System.out.println("-------Employee Details-------");
                System.out.println("Enter the First name of employee");
                employee1.setFirstName(scanner.next());
                System.out.println("Enter the middle name of employee");
                employee1.setMiddeName(scanner.next());
                System.out.println("Enter the last name of employee");
                employee1.setLastName(scanner.next());

                System.out.println("Enter the employee email");
                employeeDetails.email = scanner.next();
                if (employeeDetails.validateEmail()) {
                    employee1.setEmail(employeeDetails.email);
                } else {
                    System.out.println("Enter valid employee email");
                    employeeDetails.email = scanner.next();
                }
                System.out.println("Enter the employee phone");
                employeeDetails.phone = scanner.nextLong();
                if (employeeDetails.validatePhone()) {
                    employee1.setEmployeePhone(employeeDetails.phone);
                } else {
                    System.out.println("Enter valid phone");
                    employeeDetails.phone = scanner.nextLong();
                }
                System.out.println("Enter the employee id");
                employee1.setEmployeeId(scanner.nextInt());
            }
            catch (InputMismatchException expection){
                System.out.println("You have entered wrong input" +expection);
            }

        }


        @Override
        public void displayData() {
            ReadWriteEmployee readWriteEmployee=new ReadWriteEmployee();
            ArrayList<Object> arEmp;
            arEmp= readWriteEmployee.readFromFile();
            int size=arEmp.size();
            for(int index=0;index<size;index++){
                System.out.println(arEmp.get(index));
            }


        }

        @Override
        public Address collectAddress(int empId) {
            try {
                String houseName, streetName, cityName, stateName;
                int pincode;
                System.out.println("house name");
                houseName = scanner.next();
                scanner.nextLine();
                System.out.println("Enter street ");
                streetName = scanner.nextLine();
                System.out.println("Enter city");
                cityName = scanner.nextLine();
                System.out.println("Ente state");
                stateName = scanner.nextLine();
                System.out.println("Enter pincode");
                pincode = scanner.nextInt();

                return new Address(houseName, streetName, cityName, stateName, pincode);
            }
            catch (InputMismatchException expection){
                System.out.println("You have entered wrong input"+ expection);
                return null;
            }

        }

}
