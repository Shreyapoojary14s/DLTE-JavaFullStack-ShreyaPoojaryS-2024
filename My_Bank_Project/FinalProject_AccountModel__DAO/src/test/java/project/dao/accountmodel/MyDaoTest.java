package project.dao.accountmodel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.exception.*;
import project.dao.accountmodel.services.AccountServices;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyDaoTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AccountServices accountServices;



    @Test
    void testActive() throws AccountNotFoundException, SQLSyntaxErrorException {
        // Arrange
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(1L, 5673456565661L, 1L, "savings", "active", 600D));
        accountList.add(new Account(2L, 234567L, 2L, "savings", "active", 600D));
        accountList.add(new Account(3L, 3456789L, 3L, "savings", "active", 600D));
        accountList.add(new Account(4L, 23456789L, 4L, "savings", "active", 600D));

        when(jdbcTemplate.query(any(String.class), any(Object[].class), any(AccountServices.AccountMapper.class)))
                .thenReturn(accountList);

        // Act
        List<Account> result = accountServices.filterByStatus(1L);

        // Assert
        assertEquals(4, result.size());
        assertEquals("active", result.get(0).getAccountStatus());
        assertEquals("active", result.get(1).getAccountStatus());
        assertEquals("active", result.get(2).getAccountStatus());
        assertEquals("active", result.get(3).getAccountStatus());
    }



    @Test
    void testInactive() throws AccountNotFoundException, SQLSyntaxErrorException {
        // Arrange
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(1L, 5673456565661L, 1L, "savings", "Inactive", 600D));
        accountList.add(new Account(3L, 3456789L, 3L, "savings", "Inactive", 600D));
        accountList.add(new Account(4L, 23456789L, 4L, "savings", "Inactive", 600D));

        when(jdbcTemplate.query(any(String.class), any(Object[].class), any(AccountServices.AccountMapper.class)))
                .thenReturn(accountList);

        // Act
        List<Account> result = accountServices.filterByStatus(4L);

        // Assert
        assertEquals(3, result.size());
        assertEquals("Inactive", result.get(0).getAccountStatus());
        assertEquals("Inactive", result.get(1).getAccountStatus());
        assertEquals("Inactive", result.get(2).getAccountStatus());
    }

    // Tests from AccountRestTest class
    @Test
    void testAddAccount_Success() throws AccountAlreadyExistException {
        // Mock the JDBC template call to return a map with the expected result
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList()))
                .thenReturn(new HashMap<String, Object>() {{
                    put("p_result", "SQL103"); // Expected result for successful insertion
                }});

        // Create a sample Account object with valid data
        Account account = new Account();
        account.setCustomerId(1L);
        account.setAccountNumber(123456789L);
        account.setAccountType("savings");
        account.setAccountBalance(500.0);

        // Call the addAccount method
        String result = accountServices.addAccount(account);

        // Assert that the method returns the expected message
        assertNotEquals("Customer Not found", result);
    }

    @Test
    void testAddAccountCustomerInactive_Failure() {
        // Mock the JDBC template call to return a map with the expected result
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList()))
                .thenReturn(new HashMap<String, Object>() {{
                    put("p_result", "SQL101"); // Simulate inactive customer
                }});

        // Create a sample Account object with valid data
        Account account = new Account();
        account.setCustomerId(1L);
        account.setAccountNumber(123456789L);
        account.setAccountType("savings");
        account.setAccountBalance(500.0);

        // Call the addAccount method and catch the exception
        Exception exception = assertThrows(CustomerInactiveException.class, () -> {
            accountServices.addAccount(account);
        });

        // Assert that the correct exception is thrown
        assertEquals("Customerv is Inactive", exception.getMessage());
    }





    @Test
    void testAddAccountAccountAlreadyExist_Failure() {
        // Mock the JDBC template call to return a map with the expected result
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList()))
                .thenReturn(new HashMap<String, Object>() {{
                    put("p_result", "SQL102"); // Simulate account already exists
                }});

        // Create a sample Account object with valid data
        Account account = new Account();
        account.setCustomerId(1L);
        account.setAccountNumber(123456789L);
        account.setAccountType("savings");
        account.setAccountBalance(500.0);

        // Call the addAccount method and catch the exception
        Exception exception = assertThrows(AccountAlreadyExistException.class, () -> {
            accountServices.addAccount(account);
        });

        // Assert that the correct exception is thrown
        assertEquals("Account You are trying to add already exist", exception.getMessage());
    }

    @Test
    void testAddAccountInternalError_Failure() {
        // Mock the JDBC template call to return a map with the expected result
        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList()))
                .thenReturn(new HashMap<String, Object>() {{
                    put("p_result", "SQL105"); // Simulate internal error
                }});

        // Create a sample Account object with valid data
        Account account = new Account();
        account.setCustomerId(1L);
        account.setAccountNumber(123456789L);
        account.setAccountType("savings");
        account.setAccountBalance(500.0);

        // Call the addAccount method and catch the exception
        Exception exception = assertThrows(AccountAlreadyExistException.class, () -> {
            accountServices.addAccount(account);
        });

        // Assert that the correct exception is thrown
        assertNotEquals("Internal error occurred", exception.getMessage());
    }

    @Test
    void testAddAccount_SuccessfulInsertion() throws AccountAlreadyExistException, CustomerInactiveException {
        // Arrange
        ResourceBundle resourceBundle = ResourceBundle.getBundle("account");
        Account account = new Account();
        account.setCustomerId(1L);
        account.setAccountNumber(123456789L);
        account.setAccountType("savings");
        account.setAccountBalance(500.0);

        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(
                Collections.singletonMap("p_result", "SQL103")
        );

        // Act
        String result = accountServices.addAccount(account);

        // Assert
        assertEquals(resourceBundle.getString("successfull.added"), result);
    }
    @Test
    void testCustomerExists_WhenCustomerExists() {
        // Arrange
        Long customerId = 1L;
        when(jdbcTemplate.queryForObject(any(String.class), eq(Integer.class), any(Long.class))).thenReturn(1);

        // Act
        boolean result = accountServices.customerExists(customerId);

        // Assert
        assertTrue(result);
    }

    @Test
    void testCustomerExists_WhenCustomerDoesNotExist() {
        // Arrange
        Long customerId = 2L;
        when(jdbcTemplate.queryForObject(any(String.class), eq(Integer.class), any(Long.class))).thenReturn(0);

        // Act
        boolean result = accountServices.customerExists(customerId);

        // Assert
        assertFalse(result);
    }

    @Test
    void testAddAccount_SuccessfulInsertionfails() throws AccountAlreadyExistException, CustomerInactiveException {
        // Arrange
        Account account = new Account();
        account.setCustomerId(1L);
        account.setAccountNumber(123456789L);
        account.setAccountType("savings");
        account.setAccountBalance(500.0);

        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(
                Collections.singletonMap("p_result", "SQL103")
        );

        // Act
        String result = accountServices.addAccount(account);

        // Assert

        ResourceBundle resourceBundle = ResourceBundle.getBundle("account");
        assertEquals(resourceBundle.getString("successfull.added"), result);
    }



    @Test
    void testAddAccount_CustomerInactive_Failure() {
        // Arrange
        Account account = new Account();
        account.setCustomerId(1L);
        account.setAccountNumber(123456789L);
        account.setAccountType("savings");
        account.setAccountBalance(500.0);

        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(
                Collections.singletonMap("p_result", "SQL101")
        );

        // Act and Assert
        assertThrows(CustomerInactiveException.class, () -> accountServices.addAccount(account));
    }

    @Test
    void testAddAccount_InternalError_Failure() {
        // Arrange
        Account account = new Account();
        account.setCustomerId(1L);
        account.setAccountNumber(123456789L);
        account.setAccountType("savings");
        account.setAccountBalance(500.0);

        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList())).thenReturn(
                Collections.singletonMap("p_result", "SQL105")
        );

        // Act and Assert
        assertThrows(AccountAlreadyExistException.class, () -> accountServices.addAccount(account));
    }
    @Test
    void testFilterByStatus_NoActiveAccounts() {
        // Arrange
        Long customerId = 1L;
        List<Account> emptyAccountList = Collections.emptyList();
        when(jdbcTemplate.query(any(String.class), any(Object[].class), any(AccountServices.AccountMapper.class)))
                .thenReturn(emptyAccountList);

        // Act and Assert
        assertThrows(AccountNotFoundException.class, () -> accountServices.filterByStatus(customerId));
    }

    @Test
    void testCustomerExists_CustomerDoesNotExist() {
        // Arrange
        Long nonExistingCustomerId = 2L;
        int count = 0; // Assuming the customer doesn't exist
        when(jdbcTemplate.queryForObject(any(String.class), any(Class.class), any(Long.class)))
                .thenReturn(count);

        // Act
        boolean exists = accountServices.customerExists(nonExistingCustomerId);

        // Assert
        assertFalse(exists);
    }

    @Test
    void testCustomerExists_CustomerExists() {
        // Arrange
        Long existingCustomerId = 1L;
        int count = 1; // Assuming the customer exists
        when(jdbcTemplate.queryForObject(any(String.class), any(Class.class), any(Long.class)))
                .thenReturn(count);

        // Act
        boolean exists = accountServices.customerExists(existingCustomerId);

        // Assert
        assertTrue(exists);
    }

    @Test
    void testFilterByStatus_ActiveAccountsExist() throws AccountNotFoundException, SQLSyntaxErrorException {
        // Arrange
        Long customerId = 2L; // Assuming customer ID 2 has active accounts
        List<Account> activeAccountList = new ArrayList<>();
        activeAccountList.add(new Account(1L, 123456789L, 2L, "savings", "active", 500.0));

        when(jdbcTemplate.query(any(String.class), any(Object[].class), any(AccountServices.AccountMapper.class)))
                .thenReturn(activeAccountList);

        // Act
        List<Account> result = accountServices.filterByStatus(customerId);

        // Assert
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals("active", result.get(0).getAccountStatus());
    }

    @Test
    void testFilterByStatus_NoActiveAccount() {
        // Arrange
        Long customerId = 1L; // Assuming customer ID 1 has no active accounts
        List<Account> emptyAccountList = Collections.emptyList();

        when(jdbcTemplate.query(any(String.class), any(Object[].class), any(AccountServices.AccountMapper.class)))
                .thenReturn(emptyAccountList);

        // Act and Assert
        assertThrows(AccountNotFoundException.class, () -> accountServices.filterByStatus(customerId));
    }
    @Test
    void testAccountMapper_SQLException() throws SQLException {
        // Arrange
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getLong(anyInt())).thenThrow(SQLException.class);

        AccountServices.AccountMapper accountMapper = new AccountServices.AccountMapper();

        // Act and Assert
        assertThrows(SQLException.class, () -> accountMapper.mapRow(resultSet, 1));
    }

    @Test
    void testAccountMapper_NullResultSet() throws SQLException {
        // Arrange
        AccountServices.AccountMapper accountMapper = new AccountServices.AccountMapper();

        // Act and Assert
        assertThrows(NullPointerException.class, () -> accountMapper.mapRow(null, 1));
    }
    @Test
    void testFilterByStatus_EmptyResultSet() throws AccountNotFoundException, SQLSyntaxErrorException {
        // Arrange
        when(jdbcTemplate.query(any(String.class), any(Object[].class), any(AccountServices.AccountMapper.class)))
                .thenReturn(Collections.emptyList());

        // Act and Assert
        assertThrows(AccountNotFoundException.class, () -> accountServices.filterByStatus(1L));
    }















}
