package project.dao.accountmodel.remote;

import org.springframework.stereotype.Repository;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.exception.AccountNotFoundException;
import java.sql.SQLSyntaxErrorException;
import java.util.List;

@Repository
public interface AccountRepository {
    public List<Account> filterByStatus(Long customerId)  throws AccountNotFoundException, SQLSyntaxErrorException;
}
