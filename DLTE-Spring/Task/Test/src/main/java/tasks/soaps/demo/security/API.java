package tasks.soaps.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class API {
    @Autowired
    Services service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public MyBankUsers save(@RequestBody MyBankUsers myBankUsers){
        myBankUsers.setPassword(passwordEncoder.encode(myBankUsers.getPassword()));
        return service.signUp(myBankUsers);
    }
}
