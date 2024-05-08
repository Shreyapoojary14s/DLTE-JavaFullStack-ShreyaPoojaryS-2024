package project.dao.accountmodel;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.exception.AccountNotFoundException;
import project.dao.accountmodel.services.AccountServices;


import java.rmi.ServerException;
import java.sql.SQLSyntaxErrorException;
import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class Soap {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AccountServices accountsServices;

    List<Account> accountList;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        accountList= new ArrayList<>();
        accountList.add(new Account(105L, 111111111111L, 1L, "savings", "Inactive", 20000D));
        accountList.add(new Account(106L, 111111111112L, 1L, "salary", "Active", 25000D));
        accountList.add(new Account(107L, 222222222222L, 2L, "salary", "Inactive", 4500D));
        accountList.add(new Account(108L, 222222222223L, 2L, "savings", "Active", 400D));

    }
//
//    @Test
//    void testFilterByCustomerStatus() throws ServerException, SQLSyntaxErrorException {
//        when(jdbcTemplate.query(anyString(), any(Object[].class), any(AccountServices.AccountMapper.class)))
//                .thenAnswer(invocation -> {
////                    Object[] args = invocation.getArguments();
//                    Long customerId = 1L;//Long.parseLong(args[0].toString()); // Convert the argument to Long
//                    return accountList.stream()
//                            .filter(account -> account.getCustomerId().equals(customerId) && "active".equals(account.getAccountStatus()))
//                            .collect(Collectors.toList());
//                });
//
//        // Call the method to be tested
//        List<Account> result = accountsServices.filterByStatus(1L);
//
//        System.out.println(result);
//        // Assertions
//        assertEquals(1, result.size());
//        assertNotEquals("salary", result.get(0).getAccountType());
//        assertNotEquals("active", result.get(0).getAccountStatus());
//    }


    @Test
    void testFilterByCustomerStatus_NoActiveAccounts()  {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(105L, 111111111111L, 1L, "savings", "Inactive", 20000D));
        accountList.add(new Account(107L, 222222222222L, 2L, "salary", "Inactive", 4500D));
        accountList.add(new Account(108L, 222222222223L, 2L, "savings", "Inactive", 400D));


        when(jdbcTemplate.query(anyString(), any(Object[].class), any(AccountServices.AccountMapper.class)))
                .thenAnswer(invocation -> {
                    Long customerId = 1L;//(Long) invocation.getArguments()[0]; // Extract customer ID from arguments
                    return accountList.stream()
                            .filter(account -> account.getCustomerId().equals(customerId) && "Active".equals(account.getAccountStatus()))
                            .collect(Collectors.toList());
                });


        assertThrows(AccountNotFoundException.class, () -> accountsServices.filterByStatus(1L));
    }



//    @Test
//    void testFilterByCustomerStatusNoActiveAccounts() {
//        List<Account> inactiveAccounts = new ArrayList<>();
//        inactiveAccounts.add(new Account(105L, 111111111111L, 1L, "savings", "Inactive", 20000D));
//        inactiveAccounts.add(new Account(107L, 222222222222L, 2L, "salary", "Inactive", 4500D));
//        when(jdbcTemplate.query(anyString(), any(Object[].class), any(AccountServices.AccountMapper.class)))
//                .thenReturn(inactiveAccounts);
//
//        //System.out.println(accountsServices.filterByCustomerStatus(1L));
//        assertThrows(AccountNotFoundException.class, () -> accountsServices.filterByStatus(1L));
//    }


    @Test
    void testFilterByCustomerStatus_CustomerWithNoAccounts() throws AccountNotFoundException {
        // Arrange
        Long customerId = 3L; // Assuming customer ID 3 has no accounts
        List<Account> emptyAccountList = Collections.emptyList();

        when(jdbcTemplate.query(anyString(), any(Object[].class), any(AccountServices.AccountMapper.class)))
                .thenReturn(emptyAccountList);

        // Act and Assert
        assertThrows(AccountNotFoundException.class, () -> accountsServices.filterByStatus(customerId));
    }

    @Test
    void testFilterByCustomerStatus_InvalidCustomerId() throws AccountNotFoundException {
        // Arrange
        Long invalidCustomerId = 9999L; // Assuming this customer ID doesn't exist
        List<Account> emptyAccountList = Collections.emptyList();

        when(jdbcTemplate.query(anyString(), any(Object[].class), any(AccountServices.AccountMapper.class)))
                .thenReturn(emptyAccountList);

        // Act and Assert
        assertThrows(AccountNotFoundException.class, () -> accountsServices.filterByStatus(invalidCustomerId));
    }

    @Test
    void testFilterByCustomerStatus_MultipleActiveAccounts() throws AccountNotFoundException, SQLSyntaxErrorException {
        // Arrange
        Long customerId = 1L;
        List<Account> multipleActiveAccounts = Arrays.asList(
                new Account(101L, 111111111111L, 1L, "savings", "active", 20000D),
                new Account(102L, 111111111112L, 1L, "salary", "active", 25000D)
        );

        when(jdbcTemplate.query(anyString(), any(Object[].class), any(AccountServices.AccountMapper.class)))
                .thenReturn(multipleActiveAccounts);

        // Act
        List<Account> result = accountsServices.filterByStatus(customerId);

        // Assert
        assertEquals(2, result.size());
        assertEquals("active", result.get(0).getAccountStatus());
        assertEquals("active", result.get(1).getAccountStatus());
    }








}

