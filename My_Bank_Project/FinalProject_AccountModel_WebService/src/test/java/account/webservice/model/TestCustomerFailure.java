package account.webservice.model;

import account.webservice.model.rest.AccountRestController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.exception.AccountAlreadyExistException;
import project.dao.accountmodel.exception.CustomerInactiveException;
import project.dao.accountmodel.remote.AccountRepository;
import project.dao.accountmodel.security.MyBankCustomers;
import project.dao.accountmodel.security.MyBankCustomersService;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestCustomerFailure {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private MyBankCustomersService myBankCustomersService;

    @InjectMocks
    private AccountRestController accountRestController;

    @Test
    public void testAddAccountSuccess() throws CustomerInactiveException, AccountAlreadyExistException {
        // Arrange
        Account accountRequest = new Account();
        accountRequest.setCustomerId(1L); // Set customer ID as needed

        MyBankCustomers customer = new MyBankCustomers();
        customer.setCustomerId(1L); // Set customer ID as needed

        when(myBankCustomersService.findByUsername(anyString())).thenReturn(customer);
        when(accountRepository.addAccount(any(Account.class))).thenReturn("Account added successfully");

        // Mock authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken("username", "password");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Act
        ResponseEntity<String> response = accountRestController.addAccount(accountRequest);

        // Assert
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody().equals("Account added successfully");
    }

    @Test
    public void testAddAccountCustomerInactive() throws CustomerInactiveException, AccountAlreadyExistException {
        // Arrange
        Account accountRequest = new Account();
        accountRequest.setCustomerId(1L); // Set customer ID as needed

        MyBankCustomers customer = new MyBankCustomers();
        customer.setCustomerId(1L); // Set customer ID as needed

        when(myBankCustomersService.findByUsername(anyString())).thenReturn(customer);
        doThrow(new CustomerInactiveException("Customer is inactive")).when(accountRepository).addAccount(any(Account.class));

        // Mock authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken("username", "password");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Act
        ResponseEntity<String> response = accountRestController.addAccount(accountRequest);

        // Assert
        assert response.getStatusCode() == HttpStatus.OK;
        assert response.getBody().equals("Customer is inactive");
    }

    @Test
    public void testAddAccountAlreadyExists() throws CustomerInactiveException, AccountAlreadyExistException {
        // Arrange
        Account accountRequest = new Account();
        accountRequest.setCustomerId(1L); // Set customer ID as needed

        MyBankCustomers customer = new MyBankCustomers();
        customer.setCustomerId(1L); // Set customer ID as needed

        when(myBankCustomersService.findByUsername(anyString())).thenReturn(customer);
        doThrow(new AccountAlreadyExistException("Account already exists")).when(accountRepository).addAccount(any(Account.class));

        // Mock authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken("username", "password");
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Act
        ResponseEntity<String> response = accountRestController.addAccount(accountRequest);

        // Assert
        assert response.getStatusCode() == HttpStatus.CONFLICT;
        assert response.getBody().equals("Account already exists");
    }
    @Mock
    private SpringApplicationBuilder mockApplicationBuilder;

    @Test
    void configureTest() {
        ServletInitializer servletInitializer = new ServletInitializer();

        servletInitializer.configure(mockApplicationBuilder);

        verify(mockApplicationBuilder).sources(ModelApplication.class);
    }

    @Test
    void configureTests() {
        // Mock the SpringApplicationBuilder
        SpringApplicationBuilder mockApplicationBuilder = mock(SpringApplicationBuilder.class);

        // Create an instance of ServletInitializer
        ServletInitializer servletInitializer = new ServletInitializer();

        // Call the configure method with the mock SpringApplicationBuilder
        servletInitializer.configure(mockApplicationBuilder);

        // Verify that the sources method is called with ModelApplication.class
        verify(mockApplicationBuilder).sources(ModelApplication.class);
    }



}



