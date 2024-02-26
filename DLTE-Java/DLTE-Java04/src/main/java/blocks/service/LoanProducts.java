package blocks.service;
import java.util.Date;
public class LoanProducts {
    //declare
    private Long loanNumber;
    private Double loanAmount;
    private Integer loanDate;
    private String loanStatus,borrowerName;
    private  Long borrowerContact;

    public Long getLoanNumber(){
        return loanNumber;
    }

    @Override
    public String toString() {
        //label and variable concatination
        return "loanNumber="+loanNumber+
                ",loanAmount="+loanNumber+
                ",loanDate="+loanDate+
                ",loanStatus+"+loanStatus+
                ",borrowerName+"+borrowerName+
                ",borrowerContact="+ borrowerContact;

    }
// @Override
  /*  public String toString() {
        //label and variable concatination
        return "loanNumber="+loanNumber+
                ",loanAmount="+loanNumber+
                ",loanDate="+loanDate+
                ",loanStatus+"+loanStatus+
                ",borrowerName+"+borrowerName+
                ",borrowerContact="+ borrowerContact;

    }*/
  /*  public void setLoanNumber(Long loanNumber){
        this.loanNumber=loanNumber;
    }*/

    public void setLoanNumber(Long loanNumber) {
        this.loanNumber = loanNumber;
    }

    public Double getLoanAmount(){
        return loanAmount;
    }
    public void setLoanAmount(Double loanAmount){
        this.loanAmount=loanAmount;
    }
    public Integer getLoanDate(){
        return loanDate;
    }
    public void setLoanDate(Integer loanDate){
        this.loanDate=loanDate;
    }
    public String getLoanStatus(){
        return loanStatus;
    }


    public void setLoanStatus(String loanStatus){
        this.loanStatus=loanStatus;
    }
    public String getBorrowerName(){
    return borrowerName;
    }
    public void setBorrowerName(String borrowerName){
        this.borrowerName=borrowerName;
    }
    public Long getBorrowerContact(){
        return borrowerContact;
    }

    public void setBorrowerContact(Long borrowerContact){
        this.borrowerContact=borrowerContact;
    }
    public LoanProducts(Long loanNumber, Integer loanDate, Double loanAmount, String  borrowerName, String loanStatus, Long borrowerContact ){
        this.loanNumber=loanNumber;
        this.loanAmount=loanAmount;
        this.loanDate=loanDate;
        this.loanStatus=loanStatus;
        this.borrowerName=borrowerName;
        this.borrowerContact=borrowerContact;

    }
}



