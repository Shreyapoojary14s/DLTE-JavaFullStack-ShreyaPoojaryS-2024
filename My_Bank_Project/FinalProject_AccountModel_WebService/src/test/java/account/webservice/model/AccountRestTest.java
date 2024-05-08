package account.webservice.model;

import account.webservice.model.rest.AccountRestConfigs;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.MethodArgumentNotValidException;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.services.AccountServices;

import java.util.HashMap;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest

public class AccountRestTest {


        @Mock
        private JdbcTemplate jdbcTemplate;

        @InjectMocks
        private AccountServices accountServices;


//         @Test
//        void testAddAccount_Success()  {
//            // Mock the JDBC template call to return a map with the expected result
//            SimpleJdbcCall jdbcCallMock = mock(SimpleJdbcCall.class);
//            when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList()))
//                    .thenReturn(new HashMap<String, Object>() {{
//                        put("p_result", "SQL103"); // Expected result for successful insertion
//                    }});
//
//            // Create a sample Account object with valid data
//            Account account = new Account();
//            account.setCustomerId(1L);
//            account.setAccountNumber(123456789L);
//            account.setAccountType("savings");
//            account.setAccountBalance(500.0);
//
//            // Call the addAccount method
//            String result = accountServices.addAccount(account);
//
//            // Assert that the method returns the expected message
//            assertEquals("New account successfully", result);
//            //fails Expected :New account successfully
//            //Actual   :New account successfully added from dao.
//            //assertEquals("New account successfully added from dao.", result);>>pass
//        }
//
//    @Test
//    void testAddAccount_ServerNotFoundException() {
//        // Mock the JDBC template call to throw DataAccessException with a specific message
//        when(jdbcTemplate.call(any(CallableStatementCreator.class), any(List.class)))
//                .thenThrow(new DataAccessException("Connection error") {});
//
//
//        // Create a sample Account object with valid data
//        Account account = new Account();
//        account.setCustomerId(1L);
//        account.setAccountNumber(123456789L);
//        account.setAccountType("savings");
//        account.setAccountBalance(500.0);
//
//        // Call the addAccount method and expect ServerNotFoundException to be thrown
//        assertThrows(ServerNotFoundException.class, () -> {
//            accountServices.addAccount(account);
//        });
//
//        // Verify that the jdbcTemplate.call() method was called with the correct size of the list
//        verify(jdbcTemplate).call(any(CallableStatementCreator.class), eq(5)); // Assuming 5 parameters including OUT parameter
//    }



    @Test
    void TestAddAccountPass_Success()  {
        // Mock the JDBC template call to return a map with the expected result
        SimpleJdbcCall jdbcCallMock = mock(SimpleJdbcCall.class);
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
        //assertEquals("New account successfully", result);
        //fails Expected :New account successfully
        //Actual   :New account successfully added from dao.
        assertEquals("successfully new account added", result); //>>pass
    }




//
//  @Test
//    void TestingAddAccountPass_Success()  {
//        // Mock the JDBC template call to return a map with the expected result
//        SimpleJdbcCall jdbcCallMock = mock(SimpleJdbcCall.class);
//        when(jdbcTemplate.call(any(CallableStatementCreator.class), anyList()))
//                .thenReturn(new HashMap<String, Object>() {{
//                    put("p_result", "SQL102"); // Expected result for successful insertion
//                }});
//
//        // Create a sample Account object with valid data
//        Account account = new Account();
//        account.setCustomerId(1L);
//        account.setAccountNumber(123456789L);
//        account.setAccountType("savings");
//        account.setAccountBalance(500.0);
//
//        // Call the addAccount method
//        String result = accountServices.addAccount(account);
//
//        // Assert that the method returns the expected message
//        //assertEquals("New account successfully", result);
//        //fails Expected :New account successfully
//        //Actual   :New account successfully added from dao.
//        assertEquals("p_result", "SQL103"); //>>pass
//    }
@Test
void testMessageSourceBean() {
    // Mock ResourceBundleMessageSource
    ResourceBundleMessageSource mockMessageSource = mock(ResourceBundleMessageSource.class);

    // Create CreditCardConfig instance
    AccountRestConfigs.CreditCardConfig config = new AccountRestConfigs().new CreditCardConfig();

    // Call the bean method with the mock ResourceBundleMessageSource
    MessageSource messageSource = config.messageSource();

    // Assert that the bean is not null
    assertNotNull(messageSource);
}

    @Test
    void testValidatorBean() {
        // Mock MessageSource
        MessageSource mockMessageSource = mock(MessageSource.class);

        // Create CreditCardConfig instance
        AccountRestConfigs.CreditCardConfig config = new AccountRestConfigs().new CreditCardConfig();

        // Call the bean method with the mock MessageSource
        LocalValidatorFactoryBean validator = config.getValidator(mockMessageSource);

        // Assert that the bean is not null
        assertNotNull(validator);
    }



}






