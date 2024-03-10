package block.service.task641;

import java.io.IOException;
//abstract methods
    public interface MyBank {
        void checkAvailableLoan() throws IOException, ClassNotFoundException;
        void getCheckClosedLoan() throws IOException, ClassNotFoundException;
        void addLoan(Loan loanInfo) throws ClassNotFoundException, IOException;
}
