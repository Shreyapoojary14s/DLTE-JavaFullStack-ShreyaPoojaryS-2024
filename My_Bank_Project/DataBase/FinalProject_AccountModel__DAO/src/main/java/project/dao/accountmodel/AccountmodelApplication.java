package project.dao.accountmodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountmodelApplication {
//    public static void main(String[] args) throws AccountException, SQLSyntaxErrorException {
//        ConfigurableApplicationContext context=  SpringApplication.run(AccountmodelApplication.class, args);
//
//        AccountServices loanServices=context.getBean(AccountServices.class);
//        System.out.println(loanServices.filterByStatus((long)3));
//    }
//
    public static void main(String[] args) {

        SpringApplication.run(AccountmodelApplication.class, args);
    }

}
