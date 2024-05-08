package account.webservice.model.authenticate;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import project.dao.accountmodel.security.MyBankCustomers;
import project.dao.accountmodel.security.MyBankCustomersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@Component
public class CustomersSucccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    MyBankCustomersService myBankCustomersService;
    ResourceBundle resourceBundle=ResourceBundle.getBundle("account");
    Logger logger= LoggerFactory.getLogger(CustomersSucccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        MyBankCustomers myBankCustomers= (MyBankCustomers) authentication.getPrincipal();
        if(!myBankCustomers.getCustomerStatus().equals("Inactive")){
            if(myBankCustomers.getAttempts() >1){
                myBankCustomers.setAttempts(1);
                myBankCustomersService.updateAttempts(myBankCustomers);
            }
            super.setDefaultTargetUrl("/customer/dashboard/");
        }else{
            logger.warn(resourceBundle.getString("max.reached"));

            AuthenticationException exception=new LockedException(resourceBundle.getString("no.customer"));
            super.setDefaultTargetUrl("/customer/?errors="+resourceBundle.getString("max.reached"));

        }
        super.onAuthenticationSuccess(request,response,authentication);
    }
}
