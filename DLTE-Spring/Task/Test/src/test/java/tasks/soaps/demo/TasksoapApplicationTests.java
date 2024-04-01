package tasks.soaps.demo;


import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import services.transaction.*;
import tasks.soaps.demo.configuration.TransactionSoapPhase;
import tasks.soaps.demo.dao.TransactionEntity;
import tasks.soaps.demo.dao.TransactionServices;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import javax.xml.datatype.DatatypeConfigurationException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.lenient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TasksoapApplicationTests {
    @MockBean
    private TransactionServices transactionServices;
    @InjectMocks
    TransactionSoapPhase transactionSoapPhase;

    //receiver search
    @Test
    public void Receiver() {
        // Mock data
        ReceiverRequest filterByReceiverRequest = new ReceiverRequest();
        ReceiverRequest.setReceiver("vignesh");

        TransactionEntity transactionsModel1 = new TransactionEntity(111L, new Date(2024, 03, 28), "shreya", "asha", "1000000L", "education");
        TransactionEntity transactionsModel2 = new TransactionEntity(895775L, new Date(2024, 12, 2), "vinay", "kumar", "1000000L", "family");

        List<TransactionEntity> transactionsList = Stream.of(transactionsModel1, transactionsModel2).collect(Collectors.toList());
        lenient().when(transactionServices.receiver(anyString())).thenReturn(transactionsList);

        // Execute the method under test
        ReceiverResponse response = transactionSoapPhase.ReceiverResponse(filterByReceiverRequest);

        // Assert the response
        assertEquals("SUCCESS", response.getServiceStatus().getStatus());
        assertEquals("Transactions  fetched", response.getServiceStatus().getMessage());
        //assertNull(response);//false
        assertTrue(transactionsList.get(0).getTransaction_Id() == response.getTransaction().get(0).getTransactionId());//success
    }


    //remarks

    @Test
    public void Remarks() {
        // Mocking data
        UpdateRemarksRequest updateRemarksTransactionRequest = new UpdateRemarksRequest();
        services.transaction.Transaction transactions = new services.transaction.Transaction();
        TransactionEntity.setTransaction_remarks("family");
        TransactionEntity.setTransaction_from("Shreya");
        TransactionEntity.setTransaction_Date(XMLGregorianCalendarImpl.createDate(2024, 3, 28, 0));
        TransactionEntity.setTransaction_To("Asha");
        TransactionEntity.setTransaction_amount(500000L);
        TransactionEntity. setTransaction_Id(111L);
        updateRemarksTransactionRequest.setTransaction(transactions);

        TransactionEntity transactionsModel1 = new TransactionEntity(111L, new Date(2024, 03, 28), "prashanth", "vignesh", 1000000L, "education");
        lenient().when(transactionServices.update(any())).thenReturn(transactionsModel1);


        UpdateRemarksResponse response = transactionSoapPhase.updateRemarksResponse(updateRemarksTransactionRequest);

        // Assert message
        assertEquals("SUCCESS", response.getServiceStatus().getStatus());//success
        assertTrue(transactionsModel1.getTransaction_Id()==response.updateRemarksResponse().getTransactionId());//success

    }



//add new transactions
    @Test
    void AddNew(){
        TransactionEntity transactionsModel1 = new TransactionEntity(133L, new Date(2022, 03, 28), "shreya", "asha", "2000000L", "education");
        TransactionEntity transactionsModel2 = new TransactionEntity(895775L, new Date(2022, 12, 2), "vinay", "kumar", "1000000L", "family");

        lenient().when(transactionServices.addNew(any())).thenReturn(transactionsModel1);

        AddTransactionRequest addTransactionRequest = new AddTransactionRequest();
        services.transaction.Transaction transactions = new services.transaction.Transaction();

        transactions.setTransactionId(133L);
        transactions.setTransactionFrom("shreya");
        transactions.setTransactionDate(XMLGregorianCalendarImpl.createDate(2024, 3, 28, 0));
        transactions.setTransactionTo("asha");
        transactions.setTransactionAmount(2000000L);
        transactions.setTransactionFrom("education");

        addTransactionRequest.setTransaction(transactions);
        // Execute the method under test
        AddTransactionResponse response = transactionSoapPhase.addTransactionResponse(addTransactionRequest);

        // Assert
        assertEquals("SUCCESS", response.getServiceStatus().getStatus());    //success
        assertSame(transactionsModel1.getTransaction_Id(), response.getTransaction().getTransactionId());//success

    }



    //by sender
    @Test
    public void Sender() {
        // Mock data
        SenderRequest filterBySenderRequest = new  SenderRequest();
        filterBySenderRequest.setSender("shreya");

        TransactionEntity transactionsModel1 = new TransactionEntity(111L, new Date(2024, 03, 28), "shreya", "asha", "1000000L", "education");
        TransactionEntity transactionsModel2 = new TransactionEntity(895775L, new Date(2024, 12, 2), "vinay", "kumar", "1000000L", "family");

        List<TransactionEntity> transactionsList = Stream.of(transactionsModel1,transactionsModel2,transactionsModel2).collect(Collectors.toList());
        lenient().when(transactionServices.filterBySender(anyString())).thenReturn(transactionsList);

        // Execute the method under test
        SenderResponse response = transactionSoapPhase.SenderResponse(filterBySenderRequest);

        // Assert the response
        //assertEquals("SUCCESS", response.getServiceStatus().getStatus());
        // assertEquals("Transactions fetched", response.getServiceStatus().getMessage());

        //sucess
        assertTrue(transactionsList.get(0).getTransaction_Id()==response.getTransaction().get(0).getTransactionId());
    }







    //by amount
    @Test
    public void Amount() {
        // Mock data
        AmountRequest filterByAmountRequest = new AmountRequest();
        filterByAmountRequest.setAmount(50000000L);

        TransactionEntity transactionsModel1 = new TransactionEntity(111L, new Date(2024, 03, 28), "shreya", "asha", "1000000L", "education");
        TransactionEntity transactionsModel2 = new TransactionEntity(895775L, new Date(2024, 12, 2), "vinay", "kumar", "1000000L", "family");

        List<TransactionEntity> transactionsList = Stream.of(transactionsModel1,transactionsModel2,transactionsModel2).collect(Collectors.toList());
        lenient().when(transactionServices.FilterByAmount(anyLong())).thenReturn(transactionsList);

        // Execute the method under test
        AmountResponse response = transactionSoapPhase.filterAmount(filterByAmountRequest);

        // Assert the response
        assertEquals("SUCCESS", response.getServiceStatus().getStatus());
        assertEquals("Transactions were fetched", response.getServiceStatus().getMessage());

    }














}
