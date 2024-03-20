package review.console;

import java.util.ResourceBundle;
import java.util.Scanner;

public class ConsoleApp {

   private static ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println(resourceBundle.getString("greetings"));
        System.out.println(resourceBundle.getString("menu.display"));
        System.out.println(resourceBundle.getString("enter.choice"));
switch (scanner.nextInt()){
    case 1:
        scanner.nextLine();
        System.out.println(resourceBundle.getString("enter.employeeDetails"));
        System.out.print(resourceBundle.getString("enter.name"));
     //  scanner.nextInt();
        String name = scanner.nextLine();
        System.out.print(resourceBundle.getString("enter.id"));
        String id = scanner.nextLine();

        System.out.print(resourceBundle.getString("enter.emailId"));
        String email = scanner.nextLine();
        System.out.print(resourceBundle.getString("enter.phone"));
        long phoneNumber = Long.parseLong(scanner.nextLine());
        System.out.println(resourceBundle.getString("enter.permanentAddress"));
        System.out.print(resourceBundle.getString("enter.address"));
        String permanentAddress = scanner.nextLine();

        System.out.print(resourceBundle.getString("enter.HouseNumber"));
        String permanentHouseNumber = scanner.nextLine();

        System.out.print(resourceBundle.getString("enter.city"));
        String permanentCity = scanner.nextLine();

        System.out.print(resourceBundle.getString("enter.state"));
        String permanentState = scanner.nextLine();

        System.out.print(resourceBundle.getString("enter.pincode"));
        int permanentPinCode = Integer.parseInt(scanner.nextLine());
        System.out.println(resourceBundle.getString("enter.temporaryaddress"));
        System.out.print(resourceBundle.getString("enter.address"));
        String permanentAddress = scanner.nextLine();

        System.out.print(resourceBundle.getString("enter.HouseNumber"));
        String permanentHouseNumber = scanner.nextLine();

        System.out.print(resourceBundle.getString("enter.city"));
        String permanentCity = scanner.nextLine();

        System.out.print(resourceBundle.getString("enter.state"));
        String permanentState = scanner.nextLine();

        System.out.print(resourceBundle.getString("enter.pincode"));
        int permanentPinCode = Integer.parseInt(scanner.nextLine());
}

    }
}
