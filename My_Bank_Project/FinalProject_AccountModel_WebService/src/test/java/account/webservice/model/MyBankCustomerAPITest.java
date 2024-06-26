package account.webservice.model;


import account.webservice.model.authenticate.CustomersFailureHandler;
import account.webservice.model.authenticate.CustomersSucccessHandler;
import account.webservice.model.authenticate.MyBankCustomersAPI;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import project.dao.accountmodel.security.MyBankCustomers;
import project.dao.accountmodel.security.MyBankCustomersService;

import static org.junit.jupiter.api.Assertions.assertEquals;
        import static org.mockito.Mockito.lenient;
        import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class MyBankCustomerAPITest {
    @Mock
    private MyBankCustomersService repository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private MyBankCustomersAPI controller;
    @InjectMocks
    private CustomersFailureHandler failureHandler;
    @InjectMocks
    private CustomersSucccessHandler successHandler;

    private MockMvc mockMvc;

    @Test
    public void testSave() throws Exception {
        // Mock customer data
        MyBankCustomers customer = new MyBankCustomers();
        customer.setUsername("testUser");
        customer.setPassword("testPassword");

        // Mock the repository response
        lenient().when(repository.signingUp(ArgumentMatchers.any(MyBankCustomers.class))).thenReturn(customer);

        // Mock the password encoder response
        lenient().when(passwordEncoder.encode(ArgumentMatchers.anyString())).thenReturn("encodedPassword");

        // Set up mockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/profile/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customer)))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //.andExpect(MockMvcResultMatchers.content().json(asJsonString(customer)));
    }

    @Test
    public void testSaveProfile() {
        // Mock customer data
        MyBankCustomers customer = new MyBankCustomers();
        customer.setUsername("testUser");
        customer.setPassword("testPassword");

        // Mock repository response
        Mockito.when(repository.signingUp(ArgumentMatchers.any(MyBankCustomers.class))).thenReturn(customer);

        // Mock password encoder response
        Mockito.when(passwordEncoder.encode(ArgumentMatchers.anyString())).thenReturn("encodedPassword");

        // Perform save operation
        MyBankCustomers savedCustomer = controller.save(customer);

        // Verify that repository method is called with the correct argument
        Mockito.verify(repository).signingUp(customer);

        // Verify that password encoder is called with the correct argument
        Mockito.verify(passwordEncoder).encode("testPassword");

        // Verify the returned customer object
        assertEquals(customer.getUsername(), savedCustomer.getUsername());
        assertEquals("encodedPassword", savedCustomer.getPassword()); // Assuming password was encoded correctly
    }

    //
    // Helper method to convert object to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}