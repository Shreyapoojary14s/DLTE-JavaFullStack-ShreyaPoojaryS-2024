package blocks.service;

import java.util.Scanner;

public class MyBank {
    public static void main(String[] args) {

        Account account = new Account(508960021450L, 5075000.0, "Robur");
        DebitCard debitCard = new DebitCard(963250045007L, 5656);

        Double withdrawAmount, billAmount,balance;

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the amount required");

        withdrawAmount = scanner.nextDouble();
        balance=10000-withdrawAmount;
//withdraw
            debitCard.withdraw(withdrawAmount, account);
            System.out.println("your balance is:" + balance);

//Gpay
        Gpay gpay = new Gpay(5656,"robu123");
        billAmount = scanner.nextDouble();
        gpay.payBill("DSF", 3000.0, "Rent");


}
}



