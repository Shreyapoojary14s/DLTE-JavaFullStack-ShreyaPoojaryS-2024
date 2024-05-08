package project.dao.accountmodel.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Service;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.exception.*;
import project.dao.accountmodel.remote.AccountRepository;

import java.sql.*;
import java.util.*;

@Service
public class AccountServices implements AccountRepository {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("account");
    Logger logger= LoggerFactory.getLogger(AccountServices.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> filterByStatus(Long customerId) throws AccountNotFoundException, SQLSyntaxErrorException {

        List<Account> shortlisted;


            shortlisted = jdbcTemplate.query("SELECT a.*\n" +
                            "FROM MYBANK_APP_ACCOUNT a\n" +
                            "INNER JOIN MYBANK_APP_CUSTOMER c ON a.CUSTOMER_ID = c.CUSTOMER_ID\n" +
                            "WHERE c.CUSTOMER_ID=? AND c.CUSTOMER_STATUS = 'active' AND a.ACCOUNT_STATUS = 'active'",
                    new Object[]{customerId}, new AccountMapper());


        if (shortlisted.isEmpty()) {
            throw new AccountNotFoundException(resourceBundle.getString("no.active") + customerId);
        }


        return shortlisted;
    }

        public boolean customerExists(Long customerId) {

            String sql = "SELECT COUNT(*) FROM MYBANK_APP_CUSTOMER WHERE CUSTOMER_ID = ?";
            int count = jdbcTemplate.queryForObject(sql, Integer.class, customerId);
            return count > 0;

    }


    @Override
    public String addAccount(Account account)  {


            String procedureCall = "{call add_accounts(?, ?, ?, ?, ?)}";
            List<SqlParameter> declaredParameters = Arrays.asList(
                    new SqlParameter(Types.NUMERIC),
                    new SqlParameter(Types.NUMERIC),
                    new SqlParameter(Types.VARCHAR),
                    new SqlParameter(Types.NUMERIC),
                    new SqlOutParameter("p_result", Types.VARCHAR)
            );

           //pass to procedure
            Map<String, Object> inParams = new HashMap<>();
            inParams.put("p_customer_id", account.getCustomerId());
            inParams.put("p_account_number", account.getAccountNumber());
            inParams.put("p_account_type", account.getAccountType());
            inParams.put("p_account_balance", account.getAccountBalance());

            // result
            Map<String, Object> result = jdbcTemplate.call(conn -> {
                CallableStatement cs = conn.prepareCall(procedureCall);
                cs.setLong(1, account.getCustomerId());
                cs.setLong(2, account.getAccountNumber());
                cs.setString(3, account.getAccountType());
                cs.setDouble(4, account.getAccountBalance());
                cs.registerOutParameter(5, Types.VARCHAR);
                return cs;
            }, declaredParameters);

           //output
            String procedureResult =result.get("p_result").toString();

            logger.info(procedureResult);
            if (procedureResult.equals("SQL103")) {
                logger.info(resourceBundle.getString("successfull.added"));
                return resourceBundle.getString("successfull.added");
            }
            else if (procedureResult.equals("SQL101")) {
                logger.info(resourceBundle.getString("customer.inactive"));
                throw new CustomerInactiveException(resourceBundle.getString("customer.inactive"));//"customer inactive from dao"
            }
            else if (procedureResult.equals("SQL102")) {
                logger.info(resourceBundle.getString("account.AlreadyExist"));
                throw new AccountAlreadyExistException(resourceBundle.getString("account.AlreadyExist"));
            }

            else if (procedureResult.equals("SQL105")) {
                logger.info(resourceBundle.getString("internal.error"));
                throw new AccountAlreadyExistException(resourceBundle.getString("account.AlreadyExist"));

            }


        return null;
    }




    public static class AccountMapper implements RowMapper<Account> {
        @Override
        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
            Account account = new Account();
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

