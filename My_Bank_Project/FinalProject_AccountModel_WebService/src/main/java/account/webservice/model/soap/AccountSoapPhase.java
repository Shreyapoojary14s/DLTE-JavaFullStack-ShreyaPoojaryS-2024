package account.webservice.model.soap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.exception.AccountNotFoundException;

import project.dao.accountmodel.remote.AccountRepository;
import project.dao.accountmodel.security.MyBankCustomers;
import project.dao.accountmodel.security.MyBankCustomersService;

import services.account.ServiceStatus;
import services.account.ViewAllAccountRequest;
import services.account.ViewAllAccountResponse;


import javax.servlet.http.HttpServletResponse;
import java.sql.SQLSyntaxErrorException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


@ComponentScan("project.dao.accountmodel") //bean identification
@Endpoint
public class AccountSoapPhase {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("account");
    private Logger logger = LoggerFactory.getLogger(AccountSoapPhase.class);




    //path
    private final String url = "http://account.services";
    @Autowired
    public AccountRepository accountServices;
    @Autowired
    MyBankCustomersService myBankCustomersService;


    //filter by active
    @PayloadRoot(namespace = url, localPart = "viewAllAccountRequest")
    @ResponsePayload
    public ViewAllAccountResponse viewAllAccountResponse(@RequestPayload ViewAllAccountRequest viewAllAccountRequest) throws AccountNotFoundException, SQLSyntaxErrorException {

        ViewAllAccountResponse viewAllAccountRes = new ViewAllAccountResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        String info="";
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        String username= authentication.getName();
        MyBankCustomers customer1=myBankCustomersService.findByUsername(username);

        // AccountEntity>> dao
        try {
            if(customer1 !=null && accountServices!=null){



                List<Account> fromDao = accountServices.filterByStatus(customer1.getCustomerId());
                // soap account>> using lambda expression
                List<services.account.Account> actualAccount = fromDao.stream().map(account -> {
                    services.account.Account currentAccount = new services.account.Account();
                    //target>>account & current account
                    BeanUtils.copyProperties(account, currentAccount);
                    return currentAccount;
                })
                        .collect(Collectors.toList());

                logger.info(resourceBundle.getString("failure.fetch"));

                serviceStatus.setStatus(HttpServletResponse.SC_OK);
                serviceStatus.setMessage(resourceBundle.getString("account.fetch.success"));
                viewAllAccountRes.setServiceStatus(serviceStatus);
                viewAllAccountRes.getAccount().addAll(actualAccount);

        }
            else {
                logger.warn(resourceBundle.getString("no.customer"));
                serviceStatus.setStatus(HttpServletResponse.SC_OK);
                serviceStatus.setMessage(resourceBundle.getString("no.customer"));
                viewAllAccountRes.setServiceStatus(serviceStatus);
            }

            }

        catch (AccountNotFoundException e) {

            logger.info(resourceBundle.getString("failure.fetch"));
            serviceStatus.setStatus(HttpServletResponse.SC_OK);

            serviceStatus.setMessage(resourceBundle.getString("failure.fetch"));
            viewAllAccountRes.setServiceStatus(serviceStatus);
        }


        return viewAllAccountRes;
    }
}

