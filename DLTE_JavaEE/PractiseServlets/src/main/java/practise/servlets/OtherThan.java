package practise.servlets;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

    public class OtherThan extends GenericServlet {
        @Override
        public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            res.getWriter().println("Hello from MyServlet!");
        }

}
