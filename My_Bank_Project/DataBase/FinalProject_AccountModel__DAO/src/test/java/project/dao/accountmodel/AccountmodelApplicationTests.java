//package project.dao.accountmodel;//package project.dao.accountmodel;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import project.dao.accountmodel.entity.Account;
//import project.dao.accountmodel.exception.AccountNotFoundException;
//import project.dao.accountmodel.exception.CustomerNotFoundException;
//import project.dao.accountmodel.services.AccountServices;
//
//import java.sql.SQLSyntaxErrorException;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.lenient;
//import static org.mockito.Mockito.when;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(MockitoExtension.class)
//class AccountmodelApplicationTests {
//
//    @Mock
//   private JdbcTemplate jdbcTemplate;
//
//    @InjectMocks
//    private AccountServices accountServices;
//
//
//
//    @Test
//    void testFilterByStatusWithActiveAccounts() throws AccountNotFoundException, CustomerNotFoundException, SQLSyntaxErrorException {
//        // Arrange
//        Long customerId = 1L; // Example customer ID
//        List<Account> mockAccounts = Arrays.asList(
//                new Account(1L, 100L, 1L, "savings", "active", 5000D),
//                new Account(2L, 101L, 1L, "savings", "active", 3000D)
//        );
//lenient().when(jdbcTemplate.query(any(), any(Object[].class), any(AccountServices.AccountMapper.class))).thenReturn(mockAccounts);
//      //  lenient().when(jdbcTemplate.update(anyString(),any(Object[].class))).thenReturn(1);
//      //lenient.when(jdbcTemplate.query(any(String.class), any(Object[].class), any(AccountServices.AccountMapper.class)))
//         //       .thenReturn(mockAccounts);
//        when(jdbcTemplate.queryForObject(anyString(), eq(Integer.class), any(Long.class))).thenReturn(1);
//        // Act
//        List<Account> result = accountServices.filterByStatus(customerId);
//
//        // Assert
//        assertEquals(mockAccounts.size(), result.size(), "The size of the result list should match the mock");
//    }
//}
//
