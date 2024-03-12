package first;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

//@WebServlet("/first/api/")   // package!= url
@WebServlet("/task/api/")
public class MyFirstServlet extends HttpServlet {
    Logger logger;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestPrinciple = req.getParameter("principle");
        String requestIntrestRate = req.getParameter("Intrest rate");
        String requestPeriod = req.getParameter("Period");
        String requestRegime = req.getParameter("Regime");
        String requestIncome = req.getParameter("AnnualIncome");
       double total = 0;
       // double remain = 2;

        if (requestPrinciple != null && requestIntrestRate != null && requestPeriod != null) {
            Double principle = Double.parseDouble(requestPrinciple);
            Double intrestrate = Double.parseDouble(requestIntrestRate);
            Double period = Double.parseDouble(requestPeriod);


            total = (principle * ((Math.pow(1 + intrestrate, period) - 1) / intrestrate) * (1 + intrestrate));
            // total=principle+intrestrate;
            //    double totalMoneyInvested =(12*period)-(principle*12*100);

        }
        else{
            String slab = incomeSlab(requestRegime,Double.parseDouble(requestIncome));
            resp.getWriter().println(slab);
        }

        resp.setContentType("application/json");
        Gson gson = new Gson();
        //String message = gson.toJson(EMI);
        //resp.getWriter().println(message);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(total);
    }
        public String incomeSlab(String requestRegime, double annualIncome) {

            switch (requestRegime.toLowerCase()){
                case "new":
                    if(annualIncome<50000)
                        return("Exempt in new regime");
                    else if(annualIncome>=50000 && annualIncome<60000){
                        return ("With slab 5%:"+(annualIncome*0.05));
                    }
                    else if(annualIncome>=60000 && annualIncome<750000){
                        return("With slab 10%:"+(annualIncome*0.1));
                    }
                    else if(annualIncome>=750000 && annualIncome<1000000){
                        return ("With slab 15%: "+(annualIncome*0.15));
                    }
                    else if(annualIncome>=1000000 && annualIncome<1250000){
                        return("With slab 20%:"+(annualIncome*0.2));
                    }
                    else if(annualIncome>=1250000 && annualIncome<1500000){
                        return("With slab 25%:"+(annualIncome*0.25));
                    }
                    else{
                        return ("With slab 28%: "+(annualIncome*0.28));
                    }
                    

                case "old" :
                    if(annualIncome<250000)
                        return("Exempt in both old and new regims");
                    else if(annualIncome>=250000 && annualIncome<500000){
                        return("With slab 5%:"+annualIncome*0.05);
                    }
                    else if(annualIncome>=500000 && annualIncome<7500000){
                        return("With slab 20%: "+annualIncome*0.2);
                    }
                    else if(annualIncome>=750000 && annualIncome<1000000){
                        return("With slab 20%: "+annualIncome*0.2);
                    }
                    else if(annualIncome>=1000000 && annualIncome<1250000){
                        return("With slab 30%:"+annualIncome*0.3);
                    }
                    else if(annualIncome>=1250000 && annualIncome<1500000){
                        return("With slab 30%: "+annualIncome*0.3);
                    }
                    else{
                        return("With slab 31%: "+annualIncome*0.31);
                    }
            }
            return "no tax ";
        }


    }

