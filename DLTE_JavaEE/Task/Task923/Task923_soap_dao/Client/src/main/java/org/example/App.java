package org.example;

import web.Account;
import web.Transaction;
import web.TransactionsSoap;
import web.TransactionsSoapService;

import java.text.SimpleDateFormat;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        TransactionsSoapService transactionsSoapService=new TransactionsSoapService();
        TransactionsSoap soap=transactionsSoapService.getTransactionsSoapPort();

        Account account=new Account();
        account.setUserName("shreya");
        account.setPassword("1234");
        account.setEmail("siri@gmail.com");
        account.setPhoneNumber(128555532L);
        soap.createAccount(account);



    }
}
