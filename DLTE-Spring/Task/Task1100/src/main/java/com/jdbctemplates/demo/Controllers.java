package com.jdbctemplates.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

    @RestController
    @RequestMapping("/ControllerTransaction")
    class Controllers {
        @Autowired
        Services transactionService;
        Logger logger= LoggerFactory.getLogger(Controllers.class);
    //add new
        @PostMapping("/add")
        public Entitys saved(@RequestBody Entitys transactionEntity){
            try {
                return transactionService.newTransaction(transactionEntity);
            } catch (Exceptions exception) {
                logger.error("Error while saving transaction: " + exception.getMessage());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage(), exception);
            }
        }
    //view
        @GetMapping("/viewBySender/{sender}")
        public List<Entitys> fetchAllBySender(@PathVariable("sender") String sender){
            try {
                return transactionService.findBySender(sender);
            } catch (Exceptions exception) {
                logger.error("Error while fetching transactions by sender: " + exception.getMessage());
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
            }
        }
       //view by receiver
        @GetMapping("/viewByReceiver/{receiver}")
        public List<Entitys> fetchAllByReceiver(@PathVariable("receiver") String receiver){
            try {
                return transactionService.findByReceiver(receiver);
            } catch (Exceptions exception) {
                logger.error("Error while fetching transactions by receiver: " + exception.getMessage());
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
            }
        }
       //view by amount
        @GetMapping("/viewByAmount/{amount}")
        public List<Entitys> fetchALLByAmount(@PathVariable("amount") Double amount){
            try {
                return transactionService.findByAmount(amount);
            } catch (Exceptions exception) {
                logger.error("Error while fetching transactions by amount: " + exception.getMessage());
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage(), exception);
            }
        }

}
