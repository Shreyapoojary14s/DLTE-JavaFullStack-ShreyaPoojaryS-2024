package com.jdbctemplates.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
    @SpringBootTest
    class JdbctemplatesApplicationTests {
        @Mock
        private JdbcTemplate jdbcTemplate;
        @InjectMocks
        private Services transactionService;
        private List<Entitys> getSampleTransactionEntities() {
            List<Entitys> testList=new ArrayList<>();
            Entitys transaction1 = new Entitys(123L, new Date("01/02/2024"), "Shreya", "Vinay", 20000.0,"Education");
            Entitys transaction2 = new Entitys(123L, new Date("03/23/2024"),"anusha", "Gopal" + "", 40000.0,"Hostel");
            testList.add(transaction1);
            testList.add(transaction2);
            return testList;
        }
        //adding test
        @Test
        void testAddTransaction() {
            Entitys transaction1 = new  Entitys(123L, new Date("01/02/2024"), "Shreya", "vinay", 20000.0,"Education");
            Entitys transaction2 = new Entitys(123L, new Date("03/23/2024"),"anusha", "Gopal", 40000.0,"Hostel");

            when(jdbcTemplate.update(anyString(), anyLong(), anyDouble(), anyString(), anyString(), anyString(), any(Date.class))).thenReturn(1);
            Entitys result = transactionService.newTransaction(transaction1);
            assertEquals(transaction1, result);
        }
        //by sender
        @Test
        void testFilterSender() {
           Entitys transaction1 = new  Entitys(123L, new Date("01/02/2024"), "Shreya", "vinay", 20000.0,"Education");
            Entitys transaction2 = new  Entitys(123L, new Date("03/23/2024"),"anusha", "Gopal", 40000.0,"hostel");
            List< Entitys> expectedList =  Stream.of(transaction1, transaction2).collect(Collectors.toList());
            when(jdbcTemplate.query(anyString(), any(Object[].class), any(Services.TransactionMapper.class)))
                    .thenReturn(getSampleTransactionEntities());


            List< Entitys> result = Services.findBySender("Shreya");
            assertNotNull(result);
            assertNotEquals(expectedList, result);
        }
    //by receiver
        @Test
        void testFilterReceiver() {
            when(jdbcTemplate.query(anyString(), any(Object[].class), any(Services.TransactionMapper.class)))
                    .thenReturn(getSampleTransactionEntities());
            List< Entitys> result = Services.findByReceiver("Gopal");
            assertNotNull(result);
            assertEquals(2,result.size());
        }
//by amount
    @Test
    void testFilterAmount() {
        when(jdbcTemplate.query(anyString(), any(Object[].class), any(Services.TransactionMapper.class))).thenReturn(getSampleTransactionEntities());

        List<Entitys> result = Services.findByAmount(2000.0);
        assertNotNull(result);
        assertEquals(2, result.size());
    }


    @Test
    void contextLoads() {
    }

}
