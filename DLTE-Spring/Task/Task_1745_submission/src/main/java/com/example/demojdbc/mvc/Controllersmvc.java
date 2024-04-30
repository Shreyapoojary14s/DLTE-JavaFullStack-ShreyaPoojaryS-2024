package com.example.demojdbc.mvc;

import com.example.demojdbc.TransactionException;
import com.example.demojdbc.TransactionNew;
import com.example.demojdbc.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ResourceBundle;

@Controllers
@RequestMapping("/index")
public class Controllersmvc {
    @Autowired
    TransactionService transactionService;
    ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
    Logger logger= LoggerFactory.getLogger(Controllermvc.class);
    @GetMapping("/")
    //directs first page
    public String index(){
        return "firstPage.html";
    }


    @GetMapping("/new")
    public String submit(Model model){
        TransactionNew transactionNew=new TransactionNew();
        model.addAttribute("transactionNew",new TransactionNew());
        return "transaction.html";
    }


//    public String submit(Model model){
//        TransactionNew transactionNew=new TransactionNew();
//        model.addAttribute("transactionNew");  //error ,need one para
//        return "newTransaction.html";
//    }
//
    @RequestMapping(value="/submit",method = RequestMethod.POST)
    public String transaction(TransactionNew transactionNew, BindingResult bindingResult,Model model){
        try{
            if(!bindingResult.hasErrors()){
                transactionNew = transactionService.apiSave(transactionNew);
                model.addAttribute("status",transactionNew.getTransactionId()+" has added");
            }

        }
        catch(TransactionException transactionException){
            logger.warn(transactionException.toString());
            model.addAttribute("error",transactionException.toString());
        }

        return "transaction.html"; //html page
    }

}
