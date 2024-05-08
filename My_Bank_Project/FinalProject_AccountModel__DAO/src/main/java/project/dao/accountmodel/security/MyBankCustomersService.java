package project.dao.accountmodel.security;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Service
public class MyBankCustomersService implements UserDetailsService {

    ResourceBundle resourceBundle = ResourceBundle.getBundle("account");
    @Autowired
    private JdbcTemplate jdbcTemplate;

    Logger logger= LoggerFactory.getLogger(MyBankCustomersService.class);


    public MyBankCustomers signingUp(MyBankCustomers myBankCustomers){

        Long nextCustomerId = jdbcTemplate.queryForObject("SELECT CUSTOMERID_SEQ1.NEXTVAL FROM DUAL", Long.class);

        jdbcTemplate.update("insert into mybank_app_customer (CUSTOMER_ID,CUSTOMER_NAME,CUSTOMER_ADDRESS,CUSTOMER_STATUS,CUSTOMER_CONTACT,USERNAME,PASSWORD) values(?,?,?,?,?,?,?)", new Object[]{nextCustomerId,myBankCustomers.getCustomerName(),myBankCustomers.getCustomerAddress(),myBankCustomers.getCustomerStatus(),myBankCustomers.getCustomerContact(),myBankCustomers.getUsername(),myBankCustomers.getPassword()});
        return myBankCustomers;
    }

public MyBankCustomers findByUsername(String username) {

    List<MyBankCustomers> customerList = jdbcTemplate.query("SELECT * FROM mybank_app_customer",
            new BeanPropertyRowMapper<>(MyBankCustomers.class));
    return filterByUserName(customerList,username);

}
    public MyBankCustomers filterByUserName( List<MyBankCustomers> customerList,String username){
        List<MyBankCustomers> filteredCustomers = customerList.stream()
                .filter(customer -> customer.getUsername().equals(username))
                .collect(Collectors.toList());
        if (!filteredCustomers.isEmpty()) {
            return filteredCustomers.get(0);
        } else {
            return null; // if no customer found
        }
    }

    public void updateAttempts(MyBankCustomers myBankCustomers){
        jdbcTemplate.update("update mybank_app_customer set attempts = ? where username = ?",new Object[]{myBankCustomers.getAttempts(),myBankCustomers.getUsername()});
        logger.info(resourceBundle.getString("attempts.updated"));
    }
    public void updateStatus(MyBankCustomers myBankCustomers){
        jdbcTemplate.update("update mybank_app_customer set customer_status = 'Inactive' where username = ?",new Object[]{myBankCustomers.getUsername()});
        logger.info(resourceBundle.getString("status.changed"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyBankCustomers myBankCustomers=findByUsername(username);
        if(myBankCustomers==null)
            throw new UsernameNotFoundException(username);
        return myBankCustomers;
    }



}