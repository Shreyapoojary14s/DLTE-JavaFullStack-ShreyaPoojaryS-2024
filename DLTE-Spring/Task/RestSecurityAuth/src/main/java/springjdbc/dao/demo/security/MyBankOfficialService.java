package springjdbc.dao.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyBankOfficialService implements UserDetailsService {
@Autowired
private JdbcTemplate jdbcTemplate;


    public MyBankOfficials bySigningUp(MyBankOfficials myBankOfficials){
        int ack = jdbcTemplate.update("insert into my_bank_officials values(?,?,?,?,?)",new Object[]{
                myBankOfficials.getUsername(),
                myBankOfficials.getPassword(),
                myBankOfficials.getRole(),
                myBankOfficials.getContact(),
                myBankOfficials.getEmail()
        });
        return myBankOfficials;
    }
    public MyBankOfficials findByUsername(String username){
        MyBankOfficials myBankOfficials = jdbcTemplate.queryForObject("select * from my_bank_officials where username=?",
                new Object[]{username},new BeanPropertyRowMapper<>(MyBankOfficials.class));
        return myBankOfficials;
    }

    @Override
    public UserDetails byUsername(String username) throws UsernameNotFoundException {
        MyBankOfficials officials = findByUsername(username);
        if(officials==null)
            throw new UsernameNotFoundException(username);
        return officials;
    }
}
