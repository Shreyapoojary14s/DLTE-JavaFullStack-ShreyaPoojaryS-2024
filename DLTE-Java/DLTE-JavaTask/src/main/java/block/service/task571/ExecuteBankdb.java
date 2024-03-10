package block.service.task571;

import java.util.Date;

    public class ExecuteBankdb {
        public static void main(String[] args) {
            MyBankDatabase<CreditCard> storeCardData= new MyBankDatabase<>();
            storeCardData.bankDataBase=new CreditCard[25];
            CreditCard creditCardOne=new CreditCard(1111251411L,"Shreya S Poojary",new Date(2022,9,05),117,45200,2255);
            CreditCard creditCardTwo=new CreditCard(4522163366L,"Arun Kumar",new Date(2022,5,19),964,96300,8964);

            System.out.println(storeCardData.createNewData(creditCardOne));
            storeCardData.createNewData(creditCardTwo);

            storeCardData.deleteData(2);
            MyBankDatabase<Transactions> transactionData=new MyBankDatabase<>();
            Transactions transactionsOne=new Transactions(new Date(2022,9,05),5000,"Shobhit","FRIEND");



        }


}
