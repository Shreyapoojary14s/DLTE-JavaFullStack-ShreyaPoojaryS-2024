package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    @RestController
    @RequestMapping("/controllers")
    public class Controllers {
        //list of loans
        private List<Loan> myLoans = Stream.of(
                new Loan(2541324L, 13244.0, "16/02/2024", "personal Loan", "shreya", 964132854L),
                new Loan(62351324L, 2224324.0, "12/08/2024", "education loan", "anusha", 8534132485L),
                new Loan(1041324L, 202432524.0, "14/04/2024", "hostel loan", "shreya", 963252324L),
                new Loan(18571324L, 93233334.0, "11/06/2024", "home loan", "shreya", 85138541324L)
        ).collect(Collectors.toList());

        @GetMapping("/{attri}")
        //loan on index
        public Loan readAllLoans(@PathVariable int attri){
            if (attri>=0 && attri < myLoans.size())
                return myLoans.get(attri);
            else
                throw new IndexOutOfBoundsException("Not found");
        }
        @PostMapping("/")
        //add a new loan
        public String createLoan(@RequestBody Loan loan){
            myLoans.add(loan);

            return ("Added successfully"+myLoans);
        }


}
/*
http://localhost:8181/controllers/2
{
    "loanNumber": 1041324,
    "loanAmount": 202432524,
    "loanDate": "14/04/2024",
    "loanStatus": "hostel loan",
    "borrowerName": "shreya",
    "borrowerContact": 9632324
}
 */