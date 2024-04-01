package tasks.soaps.demo;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import services.transaction.*;
import tasks.soaps.demo.configuration.TransactionSoapPhase;
import tasks.soaps.demo.dao.TransactionEntity;
import tasks.soaps.demo.dao.TransactionServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.sql.Date;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EndPoint_Task {
    @MockBean
    private TransactionServices transactionServices;

    @InjectMocks
    TransactionSoapPhase transactionPhase;


    //remove range of dates
    @Test
    public void Date() {

        TransactionEntity transactionsModel1 = new TransactionEntity(111L, new Date(2022, 03, 30), "Shreya", "Asha", "1000000L", "education");
        TransactionEntity transactionsModel2 = new TransactionEntity(895775L, new Date(2022, 03, 21), "Kumar", "Vinay", "1000000L", "family");

        List<TransactionEntity> transactionsList = Stream.of(transactionsModel1, transactionsModel2, transactionsModel2).collect(Collectors.toList());
        // Mocking the data
        DeleteDatesRequest removeByDateRequest = new DeleteDatesRequest();


        removeByDateRequest.setStartDate(XMLGregorianCalendarImpl.createDate(2024, 3, 21, 0));
        removeByDateRequest.setEndDate(XMLGregorianCalendarImpl.createDate(2024, 3, 25, 0));

        lenient().when(transactionServices.rangeBydDelete(any(java.util.Date.class), any(java.util.Date.class))).thenReturn("removed");

        // Execute the method under test
        DeleteDatesResponse response = transactionPhase.deleteDates(removeByDateRequest);

        // Assert message
        assertEquals("removed transactions", response.getServiceStatus().getStatus());  //----success
        assertEquals("removed", response.getServiceStatus().getMessage());//-------------success

    }

    //addnew transaction
    @Test
    void AddNew(){
        TransactionEntity transactionsModel1 = new TransactionEntity(111L,new Date(2022,03,28),"Shreya","asha","1000000L","education");

        lenient().when(transactionServices.addNew(any())).thenReturn(transactionsModel1);

        AddTransactionRequest newTransactionRequest = new AddTransactionRequest();
        services.transaction.Transaction transactions = new services.transaction.Transaction();

        transactions.setTransactionId(111L);
        transactions.setTransactionFrom("shreya");
        transactions.setTransactionDate(XMLGregorianCalendarImpl.createDate(2024, 3, 28, 0));
        transactions.setTransactionTo("asha");
        transactions.setTransactionAmount(1000000L);
        transactions.setTransactionTo("education");

        newTransactionRequest.setTransaction(transactions);
        // method under test
        AddTransactionResponse response = transactionPhase.addTransactionResponse(newTransactionRequest);

        // Assert message
        assertEquals("SUCCESS", response.getServiceStatus().getStatus());//success
        assertSame(transactionsModel1.getTransaction_Id(), response.getTransaction().getTransactionId());//-------succes
    }


    //by amount search
    @Test
    public void Amount() {
        // Mock data
        AmountRequest filterByAmountRequest = new AmountRequest();
        filterByAmountRequest.setAmount(1000000L);

        TransactionEntity transactionsModel1 = new TransactionEntity(111L, new Date(2024, 03, 28), "shreya", "vinay", "1000000L", "education");
        TransactionEntity transactionsModel2 = new TransactionEntity(895775L,new Date(2024,12,2),"asha","kumar","1000000L","family");

        List<TransactionEntity> transactionsList = Stream.of(transactionsModel1,transactionsModel2).collect(Collectors.toList());
        when(transactionServices.FilterByAmount(anyLong())).thenReturn(transactionsList);

        // Execute the method under test
        AmountResponse response = transactionPhase.filterAmount(filterByAmountRequest);

        // Assert the response
        assertTrue(transactionsModel1.getTransaction_amount()=response.getTransaction().get(0).getTransactionAmount());//-------success

    }


    //by sender
    @Test
    public void Sender(){
        TransactionEntity transactionsModel1 = new TransactionEntity(111L, new Date(2022, 03, 28), "shreya", "vinay", "1000000L", "education");
        TransactionEntity transactionsModel2 = new TransactionEntity(895775L, new Date(2022, 12, 2), "asha", "kumar", "1000000L", "family");

        List<TransactionEntity> transactionsList = Stream.of(transactionsModel1, transactionsModel2, transactionsModel1).collect(Collectors.toList());

        when(transactionServices.FilterByFrom(anyString())).thenReturn(transactionsList);

        SenderRequest filterBySenderRequest = new SenderRequest();
        filterBySenderRequest.setSender("Shreya");
        SenderResponse response = transactionPhase.SenderResponse(filterBySenderRequest);


        //assertSame(transactionsList,response);
        assertEquals(transactionsList.get(0).getTransactionAmount(),response.getTransaction().get(0).getTransactionAmount());//----------success
    }





    //remarks
    @Test
    public void Remarks() {
        // Mock
        UpdateRemarksRequest updateRemarksTransactionRequest = new UpdateRemarksRequest();
        services.transaction.Transaction transactions = new services.transaction.Transaction();
        transactions.setTransactionId(111L);
        transactions.setTransactionId(111L);
        transactions.setTransactionFrom("Shreya");
        transactions.setTransactionDate(XMLGregorianCalendarImpl.createDate(2022, 3, 30, 0));
        transactions.setTransactionTo("Asha");
        transactions.setTransactionAmount(1000000L);
        transactions.setTransactionTo("family");
        updateRemarksTransactionRequest.setTransaction(transactions);

        TransactionEntity transactionsModel1 = new TransactionEntity(111L, new Date(2022, 05, 28), "shreya", "asha", "100000L", "education");
        lenient().when(transactionServices.filterByRemarks(any())).thenReturn(transactionsModel1);

        // Execute the method under test
        UpdateRemarksResponse response = transactionPhase.updateRemarksResponse(updateRemarksTransactionRequest);

        // Assert message
        //success
        assertEquals("SUCCESS", response.getServiceStatus().getStatus());


        //success
        assertTrue(transactionsModel1.getTransaction_Id()==response.getTransaction().getTransactionId());

    }





    //receiver
    @Test
    public void Receiver() {
        // Mock data
        ReceiverRequest filterByReceiverRequest = new ReceiverRequest();
        filterByReceiverRequest.setReceiver("asha");

        TransactionEntity transactionsModel1 = new TransactionEntity (111L, new Date(2024, 03, 28), "shreya", "asha", "500000L", "education");

        List<TransactionEntity> transactionsList = Stream.of( transactionsModel1).collect(Collectors.toList());
        lenient().when(transactionServices.FilterByTo(anyString())).thenReturn(transactionsList);

        // methods
        ReceiverResponse response = transactionPhase.ReceiverResponse(filterByReceiverRequest);

        // Assert message
        assertEquals("SUCCESS", response.getServiceStatus().getStatus());
        assertEquals("Transactions fetched", response.getServiceStatus().getMessage());

        //sucess
        assertTrue(transactionsList.get(0).getTransaction_Id() == response.getTransaction().get(0).getTransactionId());
    }

}

