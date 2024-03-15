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
import java.util.List;

    @WebServlet("/rest/user")
    public class FindAllByUserName extends HttpServlet {
        private TransactionService transactionService;

        @Override
        public void init() throws ServletException {
            StorageTarget storageTarget=new DatabaseTarget();
            transactionService=new TransactionService(storageTarget);
        }
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String requestUser =req.getParameter("user");
            resp.setContentType("application/json");
            try {
                List<Transaction> transactions=transactionService.callViewTransaction(requestUser);
                Gson gson=new Gson();
                String responseData= gson.toJson(transactions);
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().println(responseData);
            }catch (Exception e){
                System.out.println(e.getMessage());

            }
        }


}
/* output


http://localhost:7001/Task870/rest/user?user=shreya

[
    {
        "userName": "shreya",
        "transactionType": "deposit",
        "transactionAmount": 1000,
        "transactionDate": "May 2, 2021"
    }
]

