package project.dao.accountmodel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.exception.AccountNotFoundException;
import project.dao.accountmodel.exception.CustomerNotFoundException;
import project.dao.accountmodel.remote.AccountRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.ResourceBundle;

@Service
public class AccountServices implements AccountRepository {
    ResourceBundle resourceBundle=ResourceBundle.getBundle("account");
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> filterByStatus(Long customerId)  throws AccountNotFoundException, SQLSyntaxErrorException {

        // Check if customer exists
        if (!customerExists(customerId)) {
            // Throw exception if customer does not exist
            throw new CustomerNotFoundException(resourceBundle.getString("no.customer"));
        }

        // List to store shortlisted accounts
        List<Account> shortlisted;

        try {
            // Query database to fetch accounts based on customer ID, customer status, and account status
            shortlisted = jdbcTemplate.query("SELECT a.*\n" +
                            "FROM MYBANK_APP_ACCOUNT a\n" +
                            "INNER JOIN MYBANK_APP_CUSTOMER c ON a.CUSTOMER_ID = c.CUSTOMER_ID\n" +
                            "WHERE c.CUSTOMER_ID=? AND c.CUSTOMER_STATUS = 'active' AND a.ACCOUNT_STATUS = 'active'",
                    new Object[]{customerId}, new AccountMapper());
        } catch (DataAccessException e) {
            // Handle any data access exception
            throw new SQLSyntaxErrorException();
        }

        // If no accounts are found, throw AccountException
        if (shortlisted.isEmpty()) {
            throw new AccountNotFoundException("customer has no active accounts with customer ID" + customerId);
        }

        // Print the shortlisted accounts (for debugging or logging purposes)
        //System.out.println(shortlisted.toString());
        return shortlisted;
    }



    //check customer exist
    private boolean customerExists(Long customerId) {
        try {
            String sql = "SELECT COUNT(*) FROM MYBANK_APP_CUSTOMER WHERE CUSTOMER_ID = ?";
            int count = jdbcTemplate.queryForObject(sql, Integer.class, customerId);
            return count > 0;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }



    public class AccountMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account=new Account();
            account.setAccountId(rs.getLong(1));
            account.setAccountNumber(rs.getLong(2));
            account.setCustomerId(rs.getLong(3));
            account.setAccountType(rs.getString(4));
            account.setAccountStatus(rs.getString(5));
            account.setAccountBalance(rs.getDouble(6));
            return account;
        }
    }



}
