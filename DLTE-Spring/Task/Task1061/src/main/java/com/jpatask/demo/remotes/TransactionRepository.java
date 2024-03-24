package com.jpatask.demo.remotes;

import com.jpatask.demo.model.ViewTransaction;
import org.springframework.data.repository.CrudRepository;

    public interface TransactionRepository extends CrudRepository<ViewTransaction,String> {

}
