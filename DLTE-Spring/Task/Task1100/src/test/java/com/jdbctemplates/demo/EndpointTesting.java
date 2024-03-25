package com.jdbctemplates.demo;

//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//import java.util.Date;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Date;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.get;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
    @AutoConfigureMockMvc
    @SpringBootTest
    public class EndpointTesting {

        @MockBean
        private Services bankService;

        @InjectMocks
        private Controllers bankController;

        @Autowired
        private MockMvc mockMvc;
//        @Autowired
//        private MockMvc mockMvc;

        @Test
        void testAproval() throws Exception {
            String request = "{\n" +
                    "        \"transactionId\": 2024002,\n" +
                    "        \"transactionDate\": \"2024-02-19\",\n" +
                    "        \"transactionAmount\": 4000.0,\n" +
                    "        \"transactionTo\": \"Gopal\",\n" +
                    "        \"remarks\": \"Education\",\n" +
                    "        \"transactionBy\": \"Kumar\"\n" +
                    "    }";

            Entitys transaction = new Entitys(768757847L, new Date("03/22/2024"), "Shreya", "Vinay", 7000.0, "Education");
            when(bankService.newTransaction(any())).thenReturn(transaction);

            mockMvc.perform(post("/transaction/new").contentType(MediaType.APPLICATION_JSON).content(request))
                    .andExpect(status().isOk()).
                    andExpect(jsonPath("$.transactionId").value(2024002L)).
                    andExpect(jsonPath("$.transactionDate").value("2024-02-18T18:30:00.000+00:00")).
                    andExpect(jsonPath("$.transactionAmount").value(4000.0)).
                    andExpect(jsonPath("$.transactionTo").value("Gopal")).
                    andExpect(jsonPath("$.remarks").value("hostel")).
                    andExpect(jsonPath("$.transactionBy").value("Shreya"));
        }

        @Test
        void testFindBySender() throws Exception {
            Entitys transaction1 = new Entitys(768757847L, new Date("03/22/2024"), "Shreya", "Vinay", 7000.0, "Education");
            List<Entitys> list = Stream.of(transaction1).collect(Collectors.toList());

            when(bankService.findBySender(eq("Shreya"))).thenReturn(list);  // Corrected method name

            mockMvc.perform(get("/transaction/sender/Peter"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].transactionId").value(768757847L))
                    .andExpect(jsonPath("$[0].transactionDate").value("2024-03-21T18:30:00.000+00:00"))
                    .andExpect(jsonPath("$[0].transactionAmount").value(7000.0))
                    .andExpect(jsonPath("$[0].transactionTo").value("Shreya"))
                    .andExpect(jsonPath("$[0].remarks").value("Education"))
                    .andExpect(jsonPath("$[0].transactionBy").value("anusha"));
        }



    @Test
        void testFindByReceiver() throws Exception {
            Entitys transaction1 = new Entitys(768757847L, new Date("03/22/2024"), "Shreya", "Vinay", 7000.0, "Education");
            List<Entitys> list = Stream.of(transaction1).collect(Collectors.toList());

            when(bankService.findByReceiver(eq("John"))).thenReturn(list);  // Corrected method name

            mockMvc.perform(get("/transaction/receiver/John"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].transactionId").value(768757847L))
                    .andExpect(jsonPath("$[0].transactionDate").value("2024-03-21T18:30:00.000+00:00"))
                    .andExpect(jsonPath("$[0].transactionAmount").value(8000.0))
                    .andExpect(jsonPath("$[0].transactionTo").value("Shreya"))
                    .andExpect(jsonPath("$[0].remarks").value("Education"))
                    .andExpect(jsonPath("$[0].transactionBy").value("anusha"));
        }

        @Test
        void testFindByAmount() throws Exception {
            Entitys transaction1 = new Entitys(768757847L, new Date("03/22/2024"), "Shreya", "Vinay", 7000.0, "Education");
            List<Entitys> list = Stream.of(transaction1).collect(Collectors.toList());

            when(bankService.findByAmount(eq(7000.0))).thenReturn(list);

            mockMvc.perform(get("/transaction/view/7000"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].transactionId").value(768757847L))
                    .andExpect(jsonPath("$[0].transactionDate").value("2024-03-21T18:30:00.000+00:00"))
                    .andExpect(jsonPath("$[0].transactionAmount").value(7000.0))
                    .andExpect(jsonPath("$[0].transactionTo").value("Shreya"))
                    .andExpect(jsonPath("$[0].remarks").value("Education"))
                    .andExpect(jsonPath("$[0].transactionBy").value("Gopal"));

        }


}
