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
        double total;
        double remain=0 ;

        if (requestPrinciple != null && requestIntrestRate != null && requestPeriod != null) {
            Double principle = Double.parseDouble(requestPrinciple);
            Double intrestrate = Double.parseDouble(requestIntrestRate);
            Double period = Double.parseDouble(requestPeriod);

            total = (principle * ((Math.pow(1 + intrestrate, period) - 1) / intrestrate) * (1 + intrestrate));
            double totalMoneyInvested =(12*period)-(principle*12*100);
            remain =(totalMoneyInvested)-(total);
        }
        else {
            total=0;
        }
        resp.setContentType("application/json");
        Gson gson=new Gson();
        //String message = gson.toJson(EMI);
        //resp.getWriter().println(message);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(remain);

    }
}
