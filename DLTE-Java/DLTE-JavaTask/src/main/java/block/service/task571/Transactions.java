package block.service.task571;


import java.util.Date;

    public class Transactions {
        private Date dateOfTransaction;
        private Integer amountInTransaction;
        private String toWhom;
        private String remarks;
        public Date getDateOfTransaction() {
            return dateOfTransaction;
        }


        public Transactions(Date dateOfTransaction, Integer amountInTransaction, String toWhom, String remarks) {
            this.dateOfTransaction = dateOfTransaction;
            this.amountInTransaction = amountInTransaction;
            this.toWhom = toWhom;
            this.remarks = remarks;

        }

}
