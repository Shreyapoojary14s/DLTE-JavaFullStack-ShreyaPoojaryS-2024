package com.jpa.demo.remote;

import com.jpa.demo.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAcct extends CrudRepository<Account,String> {

}
