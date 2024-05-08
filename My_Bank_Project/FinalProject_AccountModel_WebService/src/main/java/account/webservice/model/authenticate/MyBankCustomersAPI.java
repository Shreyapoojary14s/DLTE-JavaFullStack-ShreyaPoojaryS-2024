package account.webservice.model.authenticate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.dao.accountmodel.security.MyBankCustomers;
import project.dao.accountmodel.security.MyBankCustomersService;
import project.dao.accountmodel.services.AccountServices;

import java.util.ResourceBundle;

@RestController
@RequestMapping("/profile")
public class MyBankCustomersAPI {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("account");

    @Autowired
    MyBankCustomersService myBankCustomersService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public MyBankCustomers save(@RequestBody MyBankCustomers myBankCustomers){
        myBankCustomers.setPassword(passwordEncoder.encode(myBankCustomers.getPassword()));
        return myBankCustomersService.signingUp(myBankCustomers);
    }
}