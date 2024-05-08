package account.webservice.model;

import account.webservice.model.soap.AccountSoapPhase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.exception.AccountNotFoundException;
import project.dao.accountmodel.remote.AccountRepository;
import project.dao.accountmodel.security.MyBankCustomers;
import project.dao.accountmodel.security.MyBankCustomersService;
import services.account.ServiceStatus;
import services.account.ViewAllAccountRequest;
import services.account.ViewAllAccountResponse;

import javax.security.auth.login.AccountException;
import javax.servlet.http.HttpServletResponse;
import java.rmi.ServerException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class SoapPhaseTest {

    @Mock
    private AccountRepository accountsServices;

    @InjectMocks
    private AccountSoapPhase soapPhase;

    @MockBean
    private MyBankCustomersService myBankCustomersService;

    @Mock
    private AccountRepository customerRepository;
    private Authentication authentication;
    private MyBankCustomers myBankCustomer;

    @BeforeEach
    void setup() {
        authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }








    @Test
    public void testViewAllAccountResponse_CustomerNotFound() throws AccountNotFoundException, SQLSyntaxErrorException {
        // Mock authentication
        when(myBankCustomersService.findByUsername("testUser")).thenReturn(null);

        // Call the method under test
        ViewAllAccountRequest request = new ViewAllAccountRequest();
        ViewAllAccountResponse response = soapPhase.viewAllAccountResponse(request);

        // Assertions
        ServiceStatus serviceStatus = response.getServiceStatus();
        assertEquals(HttpServletResponse.SC_OK, serviceStatus.getStatus());
        assertEquals("Customer Id not found..", serviceStatus.getMessage());
    }

    @Test
    @WithMockUser(username = "siri")
    public void FetchAllDebitCardException() throws SQLException {
        ViewAllAccountRequest viewAllRequest = new ViewAllAccountRequest();


        lenient().when(customerRepository.filterByStatus(777777777721L)).thenThrow(AccountNotFoundException.class);

        ViewAllAccountResponse response = soapPhase.viewAllAccountResponse(viewAllRequest);


        assertEquals(HttpServletResponse.SC_OK, response.getServiceStatus().getStatus());
        assertEquals("Customer Id not found..", response.getServiceStatus().getMessage());
    }






}



