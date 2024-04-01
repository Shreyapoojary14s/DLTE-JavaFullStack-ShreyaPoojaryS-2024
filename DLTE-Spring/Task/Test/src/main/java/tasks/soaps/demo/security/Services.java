package tasks.soaps.demo.security;

import org.springframework.*;
import org.springframework.stereotype.Service;
@Service
public class Services implements UserDetailsService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MyBankUsers signUp(MyBankUsers myBankUsers){
        jdbcTemplate.update("insert into MY_BANK_USERS values(?,?,?,?,?,?,?)",new Object[]{
                myBankUsers.getName(),myBankUsers.getUsername(),
                myBankUsers.getPassword(),myBankUsers.getEmail(),
                myBankUsers.getContact(),myBankUsers.getAadhaar(),
                myBankUsers.getRole()
        });
        return myBankUsers;
    }

    public MyBankUsers filterUsername(String username){
        MyBankUsers myBankUsers = jdbcTemplate.queryForObject("select * from MY_BANK_USERS where username=?",
                new Object[]{username},new BeanPropertyRowMapper<>(MyBankUsers.class));
        return myBankUsers;
    }
    @Override
    public UserDetails Username(String username) throws UsernameNotFoundException {
        MyBankUsers users = filterUsername(username);
        if(users==null)
            throw new UsernameNotFoundException(username);
        return users;
    }
}
