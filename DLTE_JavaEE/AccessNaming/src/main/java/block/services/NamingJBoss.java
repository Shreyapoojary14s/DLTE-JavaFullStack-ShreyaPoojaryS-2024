package block.services;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/role")
public class NamingJBoss extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Context context= new InitialContext();
            String role =(String)context.lookup("java:/MyPOC");//cast into string
            resp.getWriter().println(role);
            //display integer
            Integer age =(Integer) context.lookup("java:/MyInteger");//cast into string
            resp.getWriter().println(age);
            //double
//            Double agemonth =(Double) context.lookup("java:/MyDouble");//cast into string
//            resp.getWriter().println(agemonth);

        } catch (NamingException e) {
           throw new RuntimeException(e);
        }


    }
}
//http://localhost:16092/AccessNaming/type ::run for connecting JBoss
