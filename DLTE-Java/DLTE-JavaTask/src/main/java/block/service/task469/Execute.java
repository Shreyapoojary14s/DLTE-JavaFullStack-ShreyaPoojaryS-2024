package block.service.task469;

import java.util.Date;

public class Execute {public static void main(String[] args) {
    MyBankDatabase<CreditCard> creditCardMyBankDatabase = new MyBankDatabase<>();
    MyBankDatabase<Transaction> transactionMyBankDatabase = new MyBankDatabase<>();

    creditCardMyBankDatabase.myObjects=new CreditCard[4];
    transactionMyBankDatabase.myObjects=new Transaction[3];

    //CreditCard executions
    CreditCard creditCardOne = new CreditCard(6785649876564L,"Shreya  ",new Date(2024,4,14),717,15000,new Date(2021,12,15),new Date(2023,12,28),1213);
    CreditCard creditCardTwo = new CreditCard(8765678765678L,"Sinchana",new Date(2024,2,25),666,20000,new Date(2021,6,11),new Date(2024,04,30),1236);
    CreditCard creditCardThree = new CreditCard(7654556987656L,"Amrutha",new Date(2015,6,15),901,56000,new Date(2021,3,9),new Date(2024,10,06),5652);
    CreditCard creditCardFour = new CreditCard(8756312542453L,"Gopal",new Date(2045,12,19),962,968500,new Date(2021,9,24),new Date(2024,7,14),9632);

    System.out.println(creditCardMyBankDatabase.insertNewRecord(creditCardOne));
    System.out.println(creditCardMyBankDatabase.insertNewRecord(creditCardTwo));
    System.out.println(creditCardMyBankDatabase.insertNewRecord(creditCardThree));
    System.out.println(creditCardMyBankDatabase.insertNewRecord(creditCardFour));

    creditCardMyBankDatabase.viewAll();

    System.out.println(creditCardMyBankDatabase.read(2));

    System.out.println(creditCardMyBankDatabase.delete(1));

    creditCardMyBankDatabase.update(0, new CreditCard(6785649876564L,"Gopal",new Date(2036,9,23),345,50000,new Date(2024,5,25),new Date(2024,7,18),1223));
    creditCardMyBankDatabase.viewAll();

    //Transaction Executions
    Transaction transaction1 = new Transaction(new Date(2024, 02, 20),1000.0, "Kumar", "party");
    Transaction transaction2 = new Transaction(new Date(2024, 03, 15),5500.0, "Soorkie", "Friend");
    Transaction transaction3 = new Transaction(new Date(2024, 01, 25),35000.0,"Vikky","Hospital");

    System.out.println(transactionMyBankDatabase.insertNewRecord(transaction1));
    System.out.println(transactionMyBankDatabase.insertNewRecord(transaction2));
    System.out.println(transactionMyBankDatabase.insertNewRecord(transaction3));

    transactionMyBankDatabase.viewAll();

    System.out.println(transactionMyBankDatabase.read(1));
    System.out.println(transactionMyBankDatabase.delete(2));
    transactionMyBankDatabase.update(0, new Transaction(new Date(2024, 02, 20),1000.0, "John", "Family"));
    transactionMyBankDatabase.viewAll();

}
}
