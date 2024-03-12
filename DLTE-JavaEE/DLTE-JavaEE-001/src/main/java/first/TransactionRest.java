package first;


import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//servlet class and mapping
    @WebServlet("/rest/transaction/") //no package name
    //extends inbuilt HttpServlets
    public class TransactionRest extends HttpServlet {
        ArrayList<Transactions> allTransaction= (ArrayList<Transactions>) Stream.of(

                //array list of data
                new Transactions(new Date("3/05/2024"),500,"Shreya","Family"),
                new Transactions(new Date("1/08/2024"),5000,"Anusha","Friend"),
                new Transactions(new Date("2/28/2023"),6500,"Sweedal","Hostel"),
                new Transactions(new Date("9/14/2022"),7000,"Mahalaxmi","PG")

        ).collect(Collectors.toList());


        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //get parameter
            String requestMaxAmount=req.getParameter("maxium");
            String requestMinAmount=req.getParameter("minimum");

            //check if it null
            if(requestMaxAmount!=null&&requestMinAmount!=null){
                int max=Integer.parseInt(requestMaxAmount);
                int min=Integer.parseInt(requestMinAmount);

                //Creating Gson object for JSON
                Gson gson=new Gson();
                resp.setContentType("application/json");
                for (Transactions each:allTransaction) {
                    //check conditions
                    if(each.getAmountInTransaction()>min&&each.getAmountInTransaction()<max){

                        resp.getWriter().println(gson.toJson(each));
                    }
                }
                resp.setStatus(HttpServletResponse.SC_OK); //setting response to Ok=200
            }
            else{
                Gson gson=new Gson();
                resp.setContentType("application/json"); //response in jason format
                String json = gson.toJson(allTransaction);
                resp.setStatus(HttpServletResponse.SC_OK);//setting response to Ok=200
                resp.getWriter().println(json);
            }
        }
        //get data and add to array list
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Gson gson=new Gson();
            Transactions transactions=gson.fromJson(req.getReader(),Transactions.class);
            allTransaction.add(transactions);
            resp.setStatus(HttpServletResponse.SC_OK);//setting response to Ok=200
            resp.getWriter().println("to" + transactions.getToWhom()+ "\n******Successfully transaction done******");
        }

}
