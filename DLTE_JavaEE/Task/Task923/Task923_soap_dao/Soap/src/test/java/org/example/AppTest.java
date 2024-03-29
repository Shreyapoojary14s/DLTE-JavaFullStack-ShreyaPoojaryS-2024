package org.example;



import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import app.mybank.entity.Transaction;
import app.mybank.services.TransactionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import web.GroupOfTransactions;
import web.TransactionsSoap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


    public class AppTest
    {
        @Mock
        private TransactionService transactionService;
        private TransactionsSoap transactionsSoap;
        List<Transaction> transactions = new ArrayList<>();
        @Before
        public void settingUp(){
            MockitoAnnotations.initMocks(this);
            transactionsSoap=new TransactionsSoap();
            transactionsSoap.service=transactionService;
            transactions.add(new Transaction("shreya", "deposit", 852340.0, new Date("01/13/2024")));
            transactions.add(new Transaction("anusha", "withdrawal", 8540.0, new Date("02/02/2024")));
            transactions.add(new Transaction("sweedal", "transfer", 7418520.0, new Date("03/03/2024")));
            transactions.add(new Transaction("Asha", "withdraw", 100120.0, new Date("03/03/2024")));
        }
//find all
        @Test
        public void testFindAll(){
            when(transactionService.callViewAllTransaction()).thenReturn(transactions);
            GroupOfTransactions transactions=transactionsSoap.readAllTransaction();
            System.out.println(transactions.toString());
            assertNotNull(transactions);
        }
//by username
        @Test
        public void testFindAllByUsername(){
            Transaction transaction1=new Transaction("shreya", "deposit", 852340.0, new Date("01/13/2024"));
            Transaction transaction2=new Transaction("anusha", "withdrawal", 8540.0, new Date("02/02/2024"));
            Transaction transaction3=new Transaction("sweedal", "transfer", 7418520.0, new Date("03/03/2024"));

            List<Transaction> transactionList1= Stream.of(transaction1,transaction2).collect(Collectors.toList());
            List<Transaction> transactionList2= Stream.of(transaction1).collect(Collectors.toList());
            when(transactionService.callViewTransaction("shreya")).thenReturn(transactionList2);
            GroupOfTransactions groupOfTransactions=transactionsSoap.readAllByUser("shreya");
            assertNotNull(groupOfTransactions);
            assertEquals("shreya",groupOfTransactions.getTransactions().get(0).getUserName());
        }
        //adding transaction
        @Test
        public void testAddTransaction(){
            Transaction transaction = new Transaction("testUser", "testTransaction", 200.0, new Date("02/03/2024"));
            doNothing().when(transactionService).callSaveTransaction(transaction);
            transactionsSoap.createTransaction(transaction);
            verify(transactionService, times(1)).callSaveTransaction(transaction);

        }


}
