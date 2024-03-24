package com.jdbctemplates.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
    @Service
    public class Services {
        @Autowired
        private JdbcTemplate jdbcTemplate;

        public Entitys newTransaction(Entitys transaction) {
            jdbcTemplate.update("INSERT INTO transaction_entity (transaction_id, amount, received_by, remarks, sent_to, transaction_date ) VALUES (?, ?, ?, ?, ?, ?)",
                    new Object[]{
                            transaction.getTransactionId(),
                            transaction.getAmount(),
                            transaction.getReceivedBy(),
                            transaction.getRemarks(),
                            transaction.getSentTo(),
                            transaction.getTransactionDate()});
            return transaction;
        }
        //filter by sender
        public List<Entitys> findBySender(String sender) {
            return jdbcTemplate.query("SELECT * FROM transaction_entity WHERE sent_to = ?",
                    new Object[]{sender},
                    new TransactionMapper());
        }
    //filter by receiver
        public List<Entitys> findByReceiver(String receiver) {
            return jdbcTemplate.query("SELECT * FROM transaction_entity WHERE received_by = ?",
                    new Object[]{receiver},
                    new TransactionMapper());
        }
    //filter by amount
        public List<Entitys> findByAmount(Double amount) {
            return jdbcTemplate.query("SELECT * FROM transaction_entity WHERE amount = ?",
                    new Object[]{amount},
                    new TransactionMapper());
        }

        class TransactionMapper implements RowMapper<Entitys>{
//add manually
            @Override
            public Entitys mapRow(ResultSet rs, int rowNum) throws SQLException {
              Entitys entities=new Entitys();
                entities.setTransactionId(rs.getLong(1));
                entities.setAmount(rs.getDouble(2));
                entities.setReceivedBy(rs.getString(3));
                entities.setRemarks(rs.getString(4));
                entities.setSentTo(rs.getString(5));
                entities.setTransactionDate(rs.getDate(6));
                return entities;
            }
        }

}
