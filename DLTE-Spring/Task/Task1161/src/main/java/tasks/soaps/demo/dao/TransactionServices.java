package tasks.soaps.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

//import java.util.List;
@Service
public class TransactionServices {
       @Autowired
    private JdbcTemplate jdbcTemplate;
       public TransactionEntity addNew(TransactionEntity transactionEntity){
           //update query
           int ack=jdbcTemplate.update("insert into transaction_first values (?,?,?,?,?,?)",
                   transactionEntity.getTransaction_Id(),
                   transactionEntity.getTransaction_Date(),
                   transactionEntity.getTransaction_from(),
                   transactionEntity.getTransaction_To(),
                   transactionEntity.getTransaction_amount(),
                   transactionEntity.getTransaction_remarks());
           if(ack!=0) {
               return transactionEntity;
           }
           else return null;
       }
       //delete by range of date
       public String rangeBydDelete(
               XMLGregorianCalendar startDate,
               XMLGregorianCalendar endDate ){
           jdbcTemplate.update("delete from transactions_first where transaction_date between ? and ?",
                   new Object[]{startDate,endDate});
           return null;
       }


       //update the remarks
       public TransactionEntity update(TransactionEntity transactionEntity){
           int acknowledge=jdbcTemplate.update("update transactions_table set transaction_remarks=? where transaction_id=?",
                   new Object[]{transactionEntity.getTransaction_remarks(),transactionEntity.getTransaction_Id()}
           );
           if(acknowledge!=0) return transactionEntity;
           else  return null;
       }

//       public TransactionEntity update(TransactionEntity transactionEntity ){
//           TransactionEntity transactionEntityObj = jdbcTemplate.query("update  transaction_first set transaction_remarks=? where  transaction_id=?",
//                   new Object []{transactionEntity.getTransaction_remarks(),transactionEntity.getTransaction_Id()}, new );
//           return transactionEntityObj;
//       }
//       public List<TransactionEntity> updateRemarks(String remarks ){
//           List<TransactionEntity>collections=(List<TransactionEntity>)jdbcTemplate.update("update  transaction_first set transaction_remarks=? where transaction_id=?",
//               new Object []{remarks},
//                   new BeanPropertyRowMapper<>(TransactionEntity.class));
//           return collections;
//       }



    //filter by amount
    public List<TransactionEntity> FilterByAmount(String amount ){
        List<TransactionEntity>collections=(List<TransactionEntity>)jdbcTemplate.query("select * from transaction_first where transaction_amount=?",
                new Object []{amount},
                new BeanPropertyRowMapper<>(TransactionEntity.class));
        return collections;
    }

       //filter by sender
       public List<TransactionEntity> FilterByFrom(String sender){
           List <TransactionEntity> collections=(List<TransactionEntity>)jdbcTemplate.query("select * from transaction_first where transaction_from=?",
           new Object[]{sender},
           new BeanPropertyRowMapper<>(TransactionEntity.class));
           return collections;
       }
       //filter by to
       public List<TransactionEntity> FilterByTo(String reciever ){
           List<TransactionEntity>collections=(List<TransactionEntity>)jdbcTemplate.query("select * from transaction_first where transaction_from=?",
                   new Object []{reciever},
           new BeanPropertyRowMapper<>(TransactionEntity.class));
           return collections;
       }

}
//http://localhost:8082/transactionsRepo/transaction.wsdl << wsdl