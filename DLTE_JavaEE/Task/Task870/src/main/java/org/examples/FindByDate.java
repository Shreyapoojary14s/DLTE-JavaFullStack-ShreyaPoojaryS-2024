package org.examples;

import app.mybank.entity.Transaction;
import app.mybank.middleware.DatabaseTarget;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.TransactionService;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

//url mapping
    @WebServlet("/rest/date")
    public class FindByDate extends HttpServlet {
        private TransactionService transactionService;

        @Override
        public void init() throws ServletException {
            StorageTarget storageTarget=new DatabaseTarget();
            transactionService=new TransactionService(storageTarget);
        }

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //parameters
            String requestUser =req.getParameter("user");
            String requestStartDate=req.getParameter("startDate");
            String requestEndDate=req.getParameter("endDate");
            //into jason format
            resp.setContentType("application/json");
            try {
                List<Transaction> transactions=transactionService.callFindByDate(requestUser,requestStartDate,requestEndDate);
                Gson gson=new Gson();
                String responseData= gson.toJson(transactions);
                //successful
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().println(responseData);
            }catch (Exception e){
                System.out.println(e.getMessage());

            }
        }

}

/*output
http://localhost:7001/Task870/rest/date?user=shreya&startDate=01/02/2014&endDate=03/04/2029

[{"userName":"shreya","transactionType":"deposit","transactionAmount":1000.0,"transactionDate":"May 2, 2021"}]
 */
