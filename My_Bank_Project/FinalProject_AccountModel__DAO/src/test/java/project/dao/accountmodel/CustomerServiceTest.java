package project.dao.accountmodel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.security.MyBankCustomers;
import project.dao.accountmodel.security.MyBankCustomersService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @Mock
    private MyBankCustomersService customerRepository;

    @InjectMocks
    private MyBankCustomersService myBankCustomersService;

    @Test
    void testSigningUp() {
        MyBankCustomers myBankCustomers = new MyBankCustomers();
        myBankCustomers.setCustomerName("Mahesh");
        myBankCustomers.setCustomerAddress("Moodabidri");
        myBankCustomers.setCustomerStatus("Active");
        myBankCustomers.setCustomerContact(1234567890L);
        myBankCustomers.setUsername("mahesh");
        myBankCustomers.setPassword("mahesh");

        lenient().when(customerRepository.signingUp(any(MyBankCustomers.class))).thenReturn(myBankCustomers);

        MyBankCustomers savedCustomer = myBankCustomersService.signingUp(myBankCustomers);

//        System.out.println(savedCustomer.getUsername());
//        System.out.println(savedCustomer.getPassword());
        // Assertions
        assertNotNull(savedCustomer);
        assertEquals("mahesh", savedCustomer.getUsername());
    }

    @Test
    void testFindByUsername() {
        List<MyBankCustomers> customerList = new ArrayList<>();
        MyBankCustomers customer = new MyBankCustomers();
        customer.setUsername("mahesh");
        customerList.add(customer);

        when(jdbcTemplate.query(anyString(), any(RowMapper.class)))
                .thenReturn(customerList);

        MyBankCustomers foundCustomer = myBankCustomersService.findByUsername("mahesh");

        assertEquals("mahesh", foundCustomer.getUsername());
    }





    @Test
    void testLoadUserByUsername() {
        MyBankCustomers customer = new MyBankCustomers();
        customer.setUsername("mahesh");


        List<MyBankCustomers> customerList = new ArrayList<>();
        customerList.add(customer);

        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class)))
                .thenReturn(customerList);

        UserDetails userDetails = myBankCustomersService.loadUserByUsername("mahesh");

        assertNotNull(userDetails);
        assertEquals("mahesh", userDetails.getUsername());
    }

    @Test
    void testUpdateStatus(){
        MyBankCustomers myBankCustomers = new MyBankCustomers();
        myBankCustomers.setUsername("mahesh");
        myBankCustomers.setCustomerStatus("active");

        myBankCustomersService.updateStatus(myBankCustomers);

        verify(jdbcTemplate).update("update mybank_app_customer set customer_status = 'Inactive' where username = ?", "mahesh");
    }

    @Test
    void testUpdateAttempts() {
        MyBankCustomers myBankCustomers = new MyBankCustomers();
        myBankCustomers.setUsername("johndoe");
        myBankCustomers.setAttempts(1);


        myBankCustomersService.updateAttempts(myBankCustomers);

        verify(jdbcTemplate).update("update mybank_app_customer set attempts = ? where username = ?", 1, "johndoe");
        // System.out.println(myBankCustomers.getAttempts());
    }
}
