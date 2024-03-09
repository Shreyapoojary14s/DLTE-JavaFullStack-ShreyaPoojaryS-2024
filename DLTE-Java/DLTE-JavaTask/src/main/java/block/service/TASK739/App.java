package block.service.task739;
import java.util.ArrayList;
import java.util.Date;


public class App {
        public static void main(String[] args) {
            //hardcoded data
            ArrayList<Loan> loanArrayList = new ArrayList<>();
            loanArrayList.add(new Loan(1231323L,464641.0,new Date(2023,11,11),"open","Shodhan",745285252L));
            loanArrayList.add(new Loan(8656235L,895622.0,new Date(2022,6,11),"open","prabhanjan",852415215L));
            loanArrayList.add(new Loan(36552415L,8524112.0,new Date(2022,05,25),"closed","Harshitha",885241641L));
            loanArrayList.add(new Loan(74445521L,464641.0,new Date(2023,05,01),"closed","Mahalaxmi",87963451411L));

        //lambda
            MyBank myBank = (start,end)->{
                for(Loan each: loanArrayList){
                    if(each.getLoanDate().before(start) && each.getLoanDate().after(end)){
                        System.out.println(each.toString());
                    }
                }
            };

            myBank.filter(new Date(2023,04,1),new Date(2022,04,01));
        }


}
