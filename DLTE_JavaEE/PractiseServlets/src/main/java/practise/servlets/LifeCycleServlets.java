package practise.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/obj")
public class LifeCycleServlets extends HttpServlet{
    // Initialization method
    public void init() throws ServletException {
        System.out.println("Servlet initialized");
    }

    // Request handling method (GET)
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");


    }

    // Cleanup method
    public void destroy() {
        System.out.println("Servlet destroyed");
    }

}
