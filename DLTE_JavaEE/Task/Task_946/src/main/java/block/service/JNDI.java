package block.service;
//Update data in account

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

@WebServlet("/updateData/")
class UpdateServlet extends HttpServlet {
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Context context= new InitialContext();
            Connection connection=null;
            PreparedStatement preparedStatement;

            //default in name: java:/OracleDS
            DataSource dataSource = (DataSource) context.lookup("java:/OracleDS");

            // Get a connection from the DataSource
            connection = dataSource.getConnection();

            //user and password parameters from the request
            String username=req.getParameter("user");
            String password = req.getParameter("password");
            if(username !=null && password !=null){

                // update the password for the given username
                String query = "update account set password=? where username=?";
                preparedStatement=connection.prepareStatement(query);
                preparedStatement.setString(1,password);
                preparedStatement.setString(2,username);
                int updatesRows=preparedStatement.executeUpdate();

                // Check if the update was successful
                if (updatesRows==1)
                    resp.getWriter().println("Successfully updated");
                else
                    resp.getWriter().println("Update Failed");
            }
        }catch (NamingException | SQLException e){
            e.printStackTrace();
        }
    }
}

