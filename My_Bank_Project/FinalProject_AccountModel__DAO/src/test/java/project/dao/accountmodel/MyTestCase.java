package project.dao.accountmodel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import project.dao.accountmodel.security.MyBankCustomers;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyTestCase {

    @Mock
    private UserDetails userDetailsMock;

    @Test
    public void testGettersAndSetters() {
        MyBankCustomers customer = new MyBankCustomers();

        // Set values
        customer.setCustomerId(1L);
        customer.setCustomerName("John Doe");
        customer.setCustomerAddress("123 Main St");
        customer.setCustomerStatus("Active");
        customer.setCustomerContact(1234567890L);
        customer.setUsername("john");
        customer.setPassword("password");
        customer.setAttempts(0);

        // Check values using getters
        assertEquals(1L, customer.getCustomerId());
        assertEquals("John Doe", customer.getCustomerName());
        assertEquals("123 Main St", customer.getCustomerAddress());
        assertEquals("Active", customer.getCustomerStatus());
        assertEquals(1234567890L, customer.getCustomerContact());
        assertEquals("john", customer.getUsername());
        assertEquals("password", customer.getPassword());
        assertEquals(0, customer.getAttempts());
    }

    @Test
    public void testMaxAttempt() {
        MyBankCustomers customer = new MyBankCustomers();
        assertEquals(3, customer.getMaxAttempt());
    }

    @Test
    public void testUserDetailsInterfaceMethods() {
        MyBankCustomers customer = new MyBankCustomers();

        // Assuming account is always active and non-expired
        assertTrue(customer.isAccountNonExpired());
        assertTrue(customer.isEnabled());

        // Assuming account is never locked or credentials never expire
        assertTrue(customer.isAccountNonLocked());
        assertTrue(customer.isCredentialsNonExpired());
    }

    @Test
    public void testGetAuthorities() {
        MyBankCustomers customer = new MyBankCustomers();
        Collection<? extends GrantedAuthority> authorities = customer.getAuthorities();
        assertNull(authorities); // Since no authorities are set, it should return null
    }

}

