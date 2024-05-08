package account.webservice.model.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import project.dao.accountmodel.entity.Account;
import project.dao.accountmodel.exception.AccountAlreadyExistException;
import project.dao.accountmodel.exception.CustomerInactiveException;


import project.dao.accountmodel.remote.AccountRepository;
import project.dao.accountmodel.security.MyBankCustomers;
import project.dao.accountmodel.security.MyBankCustomersService;
import project.dao.accountmodel.services.AccountServices;

import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/addAccount")
@ComponentScan("project.dao.accountmodel")
public class AccountRestController {


    @Autowired
    AccountRepository accountServices;
    @Autowired
    MyBankCustomersService myBankCustomersService;

    Logger logger= LoggerFactory.getLogger(AccountRestController.class);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("account");

    @Operation(summary = "Add new account")
    @PostMapping("/insert")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "SQL101", description = "Customer inactive"),
            @ApiResponse(responseCode = "SQL102", description = "Account already exit"),
            @ApiResponse(responseCode = "SQL103", description = "successful"),
            @ApiResponse(responseCode = "SQL104", description = "Customer not found"),
            @ApiResponse(responseCode = "SQL105", description = "Internal server error")
    })
    public ResponseEntity<String> addAccount(@Valid @RequestBody Account accountRequest) {

        String info="";
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        String username= authentication.getName();
        MyBankCustomers customer1=myBankCustomersService.findByUsername(username);


        try {
            accountRequest.setCustomerId(customer1.getCustomerId());
            String message = accountServices.addAccount(accountRequest);
            logger.info(resourceBundle.getString("successfull.added"));
            return ResponseEntity.ok(message);
        }

        catch (CustomerInactiveException e){
            logger.info(resourceBundle.getString("customer.inactive"));
            return  ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
        catch (AccountAlreadyExistException e){
            logger.info(resourceBundle.getString("account.AlreadyExist"));
            return  ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }


    }

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }


}
