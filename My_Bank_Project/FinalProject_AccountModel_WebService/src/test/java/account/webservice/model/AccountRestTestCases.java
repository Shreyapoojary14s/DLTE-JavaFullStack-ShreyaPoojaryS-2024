package account.webservice.model;


import account.webservice.model.rest.AccountRestController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.exception.AccountAlreadyExistException;
import project.dao.accountmodel.exception.CustomerInactiveException;
import project.dao.accountmodel.remote.AccountRepository;
import project.dao.accountmodel.security.MyBankCustomers;
import project.dao.accountmodel.security.MyBankCustomersService;

import java.util.Map;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class AccountRestTestCases {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private MyBankCustomersService myBankCustomersService;

    @InjectMocks
    private AccountRestController accountRestController;
    @Mock
    private MethodArgumentNotValidException methodArgumentNotValidException;

    @Test
    @WithMockUser(username = "siri")
    void testAddAccount_AccountAlreadyExist() throws Exception {
        Account account = new Account();
        account.setCustomerId(898765432166L);

        MyBankCustomers customer = new MyBankCustomers();
        when(myBankCustomersService.findByUsername(any())).thenReturn(customer);
        when(accountRepository.addAccount(account)).thenThrow(new AccountAlreadyExistException("Account already exists"));

        mockMvc.perform(MockMvcRequestBuilders.post("/addAccount/insert")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"customerId\": 898765432166L}"))
                .andExpect(status().isBadRequest()) ;}

    @Test
    @WithMockUser(username = "siri")
    void testHandleBeanValidationException() throws Exception {
        // Create a request with invalid data
        String request = "\"accountNumber\":12334423332244,\n" +
                "  \"accountType\": \"null\",\n" +
                "  \"accountBalance\": null";


        // Perform the request
        mockMvc.perform(put("/addAccount/insert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    @WithMockUser(username = "siri")
    void testAddAccount_BadRequest_InvalidInput() throws Exception {
        // Create a request with invalid input data
        String request = "{\"customerId\": \"invalidCustomerId\"}";

        // Perform the request
        mockMvc.perform(MockMvcRequestBuilders.post("/addAccount/insert")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isBadRequest());
    }


    @Test
    void testHandleValidationExceptions() {
        // Create a MethodArgumentNotValidException with mock errors
        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(null, new BeanPropertyBindingResult(null, ""));
        ex.getBindingResult().addError(new FieldError("objectName", "fieldName1", "Error message 1"));
        ex.getBindingResult().addError(new FieldError("objectName", "fieldName2", "Error message 2"));

        // Call the method under test
        AccountRestController controller = new AccountRestController();
        Map<String, String> errors = controller.handleValidationExceptions(ex);

        // Verify the result
        assertEquals(2, errors.size());
        assertEquals("Error message 1", errors.get("fieldName1"));
        assertEquals("Error message 2", errors.get("fieldName2"));
    }





}
