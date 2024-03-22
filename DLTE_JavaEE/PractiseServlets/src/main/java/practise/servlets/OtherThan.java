package practise.servlets;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

    public class OtherThan extends GenericServlet {
        @Override

        public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
            // Get method to receive minimum and maximum transaction as the parameters
//            String minAmount = request.getParameter("min");
//            String maxAmount = request.getParameter("max");

            // Initialize HTML content
            StringBuilder htmlContent = new StringBuilder("<html><head><title>Transaction Analysis</title></head><body>");
            htmlContent.append("<h1>Hello</h1>");

         //   htmlContent.append("<p>").append(transaction.toString()).append("</p>");

        }
    }
//            // If the values are not null, filter based on the range
//            if (minAmount != null && maxAmount != null) {
//                double minimumAmount = Double.parseDouble(minAmount);
//                double maximumAmount = Double.parseDouble(maxAmount);
//
//                // Lambda expression to filter based on the range given.
//                List<Transaction> transactions = myTransactions.stream()
//                        .filter(each -> each.getTransactionAmount() >= minimumAmount && each.getTransactionAmount() <= maximumAmount)
//                        .collect(Collectors.toList());
//
//                // Append transaction details to HTML content
//                htmlContent.append("<h1>Transactions within the range:</h1>");
//                for (Transaction transaction : transactions) {
//                    htmlContent.append("<p>").append(transaction.toString()).append("</p>");
//                }
//            } else {
//                // Read All: GET service
//                htmlContent.append("<h1>All Transactions:</h1>");
//                for (Transaction transaction : myTransactions) {
//                    htmlContent.append("<p>").append(transaction.toString()).append("</p>");
//                }
//            }
//
//            // Close HTML content
//            htmlContent.append("</body></html>");
//
//            // Set response content type to HTML
//            response.setContentType("text/html");
//
//            // Write HTML content to response
//            response.getWriter().println(htmlContent.toString());
//        }
////        public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
////            res.getWriter().println("Hello from MyServlet!");
////        }


