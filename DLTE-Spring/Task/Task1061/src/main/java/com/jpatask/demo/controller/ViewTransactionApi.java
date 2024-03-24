package com.jpatask.demo.controller;

import com.jpatask.demo.model.ViewTransaction;
import com.jpatask.demo.services.ViewTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
    @RequestMapping("/hqlNativeQuery")
    public class ViewTransactionApi {
        @Autowired
        ViewTransactionService transactionService;

        @PostMapping(value="/", consumes="application/xml")
        public ViewTransaction apiSave(@RequestBody ViewTransaction viewTransaction){
            return transactionService.callSave(viewTransaction);
        }

        @GetMapping("/{amount1}/{amount2}")
        public List<ViewTransaction> apiAmountRange(@PathVariable("amount1") Double amount1, @PathVariable("amount2") Double amount2){
            return transactionService.callFindAllByRangeOfTransactionAmount(amount1,amount2);
        }

        @GetMapping("/filter/{user}/{type}")
        public List<ViewTransaction> apiType(@PathVariable("user") String user,@PathVariable("type") String type){
            return transactionService.callFindAllByTypeOfTransaction(user, type);
        }

}
