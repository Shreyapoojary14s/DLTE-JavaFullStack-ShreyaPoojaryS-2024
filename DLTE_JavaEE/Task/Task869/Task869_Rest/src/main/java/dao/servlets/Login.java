package dao.servlets;

import app.mybank.entity.Account;
import app.mybank.middleware.DatabaseTarget;
import app.mybank.remotes.StorageTarget;
import app.mybank.services.TransactionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private TransactionService transactionService;

    @Override
    public void init() throws ServletException {
        StorageTarget storageTarget=new DatabaseTarget();
        transactionService=new TransactionService(storageTarget);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//parameters
        String requestUser=req.getParameter("user");
        String requestPassword=req.getParameter("password");
        resp.setContentType("application/json");
        try{
            Boolean account = transactionService.verifyAccount(requestUser,requestPassword);
            if(account==true){
                //successful
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().println("Login Successfull");
            }
            else {
                //not found
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().println("Account not found");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}
