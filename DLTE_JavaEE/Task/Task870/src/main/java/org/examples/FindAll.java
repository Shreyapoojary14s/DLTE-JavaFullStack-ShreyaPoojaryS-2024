
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
//webapp
//servlet mapping url
@WebServlet("/rest/*")
public class FindAll extends HttpServlet {
    private TransactionService transactionService;

    //invoke
    @Override
    public void init() throws ServletException {
        StorageTarget storageTarget=new DatabaseTarget();
        transactionService=new TransactionService(storageTarget);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");//json format
        try {
            List<Transaction> transactions=transactionService.callViewAllTransaction();
            //into jason format
            Gson gson=new Gson();
            String responseData= gson.toJson(transactions);
            //successful status
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(responseData);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}
/*output
configure jboss
[
    {
        "userName": "shreya",
        "transactionType": "deposit",
        "transactionAmount": 1000.0,
        "transactionDate": "May 2, 2021"
    },
    {
        "userName": "ankitha",
        "transactionType": "deposit",
        "transactionAmount": 500.0,
        "transactionDate": "Jun 2, 2024"
    },
    {
        "userName": "elroy",
        "transactionType": "withdraw",
        "transactionAmount": 5000.0,
        "transactionDate": "Dec 5, 2024"
    }
]

