package project.dao.accountmodel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.remote.AccountRepository;
import project.dao.accountmodel.services.AccountServices;

import javax.security.auth.login.AccountException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AccountTest {

    @Mock
    JdbcTemplate jdbcTemplate;
    @InjectMocks
    AccountRepository accountService;


    @Test
    void testactive() throws AccountException, SQLSyntaxErrorException {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(1L, 5673456565661L, 1L, "savings", "active", 600D));
        accountList.add(new Account(2L, 234567L, 2L, "savings", "active", 600D));
        accountList.add(new Account(3L, 3456789L, 3L, "savings", "active", 600D));
        accountList.add(new Account(4L, 23456789L, 4L, "savings", "active", 600D));

        when(jdbcTemplate.query(anyString(), any(Object[].class), any(AccountServices.AccountMapper.class)))
                .thenReturn(accountList);
        when(jdbcTemplate.queryForObject(anyString(), eq(Integer.class), any(Long.class))).thenReturn(1);
        List<Account> result = accountService.filterByStatus(1L);
        assertEquals(4, result.size());
        //assertEquals("Active", result.get(0).getAccountStatus());//fail
        assertEquals("active", result.get(1).getAccountStatus());
    }
    //test case fails expected
//    @Test
//    void testactives() throws AccountException, SQLSyntaxErrorException {
//        List<Account> accountList = new ArrayList<>();
//        accountList.add(new Account(1L, 5673456565661L, 1L, "savings", "active", 600D));
//        when(jdbcTemplate.query(anyString(), any(Object[].class), any(AccountServices.AccountMapper.class)))
//                .thenReturn(accountList);
//        when(jdbcTemplate.queryForObject(anyString(), eq(Integer.class), any(Long.class))).thenReturn(1);
//        List<Account> result = accountService.filterByStatus(4L);
//        assertEquals(1, result.size());
//        assertEquals("active", result.get(1).getAccountStatus());
//    }
}