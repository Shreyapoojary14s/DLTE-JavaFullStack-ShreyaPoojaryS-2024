package blocks.service;

import java.util.Scanner;

public class Gpay{

    private int upiPin;
    private String username;

    public Gpay(int i, String harry123) {
    }




    public void GPay(int upiPin, String username) {
        this.upiPin = upiPin;
        this.username = username;
    }

    public void payBill(String billerName, Double billedAmount, String billerType) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your UPI pin");
        int pin = scanner.nextInt();
        if (pin == 6543) {
            System.out.println("Bill of "+billedAmount+" to "+billerName+" and "+billerType+" successful");
        } else {
            System.out.println("Bill payment not successful");
        }
    }
}


