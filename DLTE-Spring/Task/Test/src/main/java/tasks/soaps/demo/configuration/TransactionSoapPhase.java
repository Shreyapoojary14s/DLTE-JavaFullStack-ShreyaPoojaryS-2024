package tasks.soaps.demo.configuration;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import services.transaction.*;
import tasks.soaps.demo.dao.TransactionEntity;
import tasks.soaps.demo.dao.TransactionServices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Endpoint
public class TransactionSoapPhase {
    private final String url="http://transaction.services";
    @Autowired
    private TransactionServices transactionServices;

//    @PayloadRoot(namespace = url,localPart = "receiverRequest")
//    @ResponsePayload
//    public ReceiverRequest receiverRequest(@RequestPayload ReceiverRequest receiverRequest){
//        SenderRequest filterBySenderResponse=new ();
//        ServiceStatus serviceStatus=new ServiceStatus();
//        List<services.transaction.Transaction> transactions=new ArrayList<>();
//        List<Transaction> daoTransaction=transactionServices.FilterByTo(ReceiverRequest.getReciever);
//        Iterator<Transaction> iterator =daoTransaction.iterator();
//
//        while (iterator.hasNext()){
//            services.transaction.Transaction currentTransaction=new services.transaction.Transaction();
//            BeanUtils.copyProperties(iterator.next(),currentTransaction);
//            transactions.add(currentTransaction);
//        }
//        serviceStatus.setStatus("SUCCESS");
//        serviceStatus.setMessage("Transaction by sender "+ReceiverRequest.getReciever()+" is fetched");
//
//        filterBySenderResponse.setServiceStatus(serviceStatus);
//        filterBySenderResponse.getTransaction().addAll(transactions);
//        return filterBySenderResponse;
//
//    }


    //authority only by cashier
     @PreAuthorize("hasAnyAuthority('cashier')")
@PayloadRoot(namespace = url,localPart = "SenderRequest")
@ResponsePayload
public SenderResponse filterBySender(@RequestPayload SenderRequest filterSenderRequest){
    SenderResponse filterSenderResponse=new SenderResponse();
    ServiceStatus serviceStatus=new ServiceStatus();
    List<services.transaction.Transaction> transactions=new ArrayList<>();
    List<TransactionEntity> transactionEntity=transactionServices.FilterByFrom(filterSenderRequest.getSender());

    Iterator<TransactionEntity> iterator =transactionEntity.iterator();
    while (iterator.hasNext()){
        services.transaction.Transaction currentTransaction=new services.transaction.Transaction();
        BeanUtils.copyProperties(iterator.next(),currentTransaction);
        transactions.add(currentTransaction);
    }
    serviceStatus.setStatus("SUCCESS");
    serviceStatus.setMessage("Transaction by sender "+filterSenderRequest.getSender()+" is fetched");
    filterSenderResponse.setServiceStatus(serviceStatus);
    filterSenderResponse.getTransaction().addAll(transactions);
    return filterSenderResponse;
}




///authority only by cashier
 @PreAuthorize("hasAnyAuthority('cashier')")
    @PayloadRoot(namespace = url,localPart = "ReceiverRequest")
    @ResponsePayload
    public ReceiverResponse filterByReceiver(@RequestPayload ReceiverRequest filterReceiverRequest){
    ReceiverResponse filterReceiverResponse=new ReceiverResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        List<services.transaction.Transaction> transactions=new ArrayList<>();
        List<TransactionEntity> transactionEntity=transactionServices.FilterByTo(filterReceiverRequest.getReceiver());

        Iterator<TransactionEntity> iterator = transactionEntity.iterator();

        while (iterator.hasNext()){
            services.transaction.Transaction currentTransaction=new services.transaction.Transaction();
            BeanUtils.copyProperties(iterator.next(),currentTransaction);
            transactions.add(currentTransaction);
        }
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Transaction by receiver "+filterReceiverRequest.getReceiver()+" is retrieved succcessfull");

        filterReceiverResponse.setServiceStatus(serviceStatus);
        filterReceiverResponse.getTransaction().addAll(transactions);
        return filterReceiverResponse;

    }


    //by cashier
    @PreAuthorize("hasAnyAuthority('cashier')")
    @PayloadRoot(namespace = url,localPart = "AmountRequest")
    @ResponsePayload
    public AmountResponse filterAmount(@RequestPayload AmountRequest filterAmountRequest){
        AmountResponse filterAmountResponse=new AmountResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        List<Transaction> transactions=new ArrayList<>();
        List<TransactionEntity>transactionEntity=transactionServices.FilterByAmount(filterAmountRequest.getAmount());
        Iterator<TransactionEntity> iterator =transactionEntity.iterator();

        while (iterator.hasNext()){
            Transaction transactioncurr=new Transaction();
            BeanUtils.copyProperties(iterator.next(),transactioncurr);
            transactions.add(transactioncurr);
        }
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Transaction by amount "+filterAmountRequest.getAmount()+" is fetched");

        filterAmountResponse.setServiceStatus(serviceStatus);
        filterAmountResponse.getTransaction().addAll(transactions);
        return filterAmountResponse;
    }

//authority by manager
    @PreAuthorize("hasAnyAuthority('admin','manager')")
    @PayloadRoot(namespace = url,localPart = "updateRemarksRequest")
    @ResponsePayload
    public UpdateRemarksResponse updateRemarksResponse(@RequestPayload UpdateRemarksRequest updateRemarksRequest){
        UpdateRemarksResponse updateRemarksResponse=new UpdateRemarksResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        services.transaction.Transaction transaction=new services.transaction.Transaction();

        TransactionEntity transactionEntity=new TransactionEntity();
        BeanUtils.copyProperties(updateRemarksRequest.getTransaction(),transactionEntity);
        transactionEntity=transactionServices. update(transactionEntity);

        if(transactionEntity!=null){
            serviceStatus.setStatus("SUCCESS");
            serviceStatus.setMessage("Transaction updated");
        }else
        {
            serviceStatus.setStatus("FAILURE");
            serviceStatus.setMessage("Transaction update failed");
        }

        BeanUtils.copyProperties(transactionEntity,transaction);
        updateRemarksResponse.setServiceStatus(serviceStatus);
        updateRemarksResponse.setTransaction(transaction);
        return updateRemarksResponse;
    }



    //authority by admin//shreya

    @PreAuthorize("hasAnyAuthority('admin')")
    @PayloadRoot(namespace = url,localPart = "deleteDatesRequest")
    @ResponsePayload
    public DeleteDatesResponse deleteDates(@RequestPayload DeleteDatesRequest deleteDatesRequest){
        DeleteDatesResponse deleteRangeOfDatesResponse=new DeleteDatesResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        String deleteTransaction =transactionServices.rangeBydDelete(deleteDatesRequest.getStartDate(),deleteDatesRequest.getEndDate());
        if(deleteTransaction.contains("deleted")){
            serviceStatus.setStatus("FAILURE");
        }else
            serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage(deleteTransaction);
        deleteRangeOfDatesResponse.setServiceStatus(serviceStatus);
        return deleteRangeOfDatesResponse;
    }










//accessible only by the admin
    @PreAuthorize("hasAnyAuthority('admin')")
    @PayloadRoot(namespace =url,localPart="addTransactionRequest")
    @ResponsePayload
    public AddTransactionResponse addTransactionResponse(@RequestPayload AddTransactionRequest addTransactionRequest){
        AddTransactionResponse addTransactionResponse=new AddTransactionResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        Transaction transactionactual=addTransactionResponse.getTransaction();
        TransactionEntity transactionEntity=new TransactionEntity();
        BeanUtils.copyProperties(transactionactual,transactionEntity);
        transactionEntity=transactionServices.addNew(transactionEntity);
        if(transactionEntity!=null){
            serviceStatus.setStatus("Success");
            serviceStatus.setMessage(transactionEntity.getTransaction_Id()+"is inserted successfully");
        }
        else{
            serviceStatus.setStatus("failure");
            serviceStatus.setMessage(transactionEntity.getTransaction_Id()+"is not inserted successfully");
        }
        addTransactionResponse.setServiceStatus(serviceStatus);
        BeanUtils.copyProperties(transactionEntity,transactionactual);
        addTransactionResponse.setTransaction(transactionactual);
        return addTransactionResponse;


    }


}
