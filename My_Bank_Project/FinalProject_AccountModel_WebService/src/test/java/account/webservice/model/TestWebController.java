package account.webservice.model;


import account.webservice.model.mvc.MyBankWebController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import project.dao.accountmodel.security.MyBankCustomers;
import project.dao.accountmodel.security.MyBankCustomersService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MyBankWebController.class)
public class TestWebController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MyBankCustomersService myBankCustomersService;

    @Test
    @WithMockUser(username = "shreya")
    void testLanding() throws Exception {
        mockMvc.perform(get("/customer/"))
                .andExpect(status().isOk());
        // .andExpect(view().name("index"));
    }

    @Test
    @WithMockUser(username = "shreya")
    void testHomePage() throws Exception {
        mockMvc.perform(get("/customer/dashboard"))
                .andExpect(status().isOk());
        // .andExpect(view().name("dashboard"));
    }

    @Test
    @WithMockUser(username = "shreya")
    void testView() throws Exception {
        mockMvc.perform(get("/customer/view"))
                .andExpect(status().isOk());
        //.andExpect(view().name("viewAccounts"));
    }



    @Test
    @WithMockUser(username = "shreya")
    void testError() throws Exception {
        mockMvc.perform(get("/customer/error"))
                .andExpect(status().isOk());
        //.andExpect(view().name("error"));
    }

    @Test
    @WithMockUser(username = "shreya")
    void testCustomerName_ReturnsName_Successfully() throws Exception {
        // Mock MyBankCustomersService response
        MyBankCustomers customer = new MyBankCustomers();
        customer.setCustomerName("Shreya");

        when(myBankCustomersService.findByUsername(any())).thenReturn(customer);

        mockMvc.perform(get("/customer/name"))
                .andExpect(status().isOk())
                .andExpect(content().string("Shreya"));
    }
    @Test
    @WithMockUser(username = "shreya")
    void testAddAccountPage() throws Exception {
        mockMvc.perform(get("/customer/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("addAccount"));
    }


}