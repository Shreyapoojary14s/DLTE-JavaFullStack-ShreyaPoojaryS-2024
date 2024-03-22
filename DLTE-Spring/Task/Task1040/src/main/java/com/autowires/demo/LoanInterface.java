package com.autowires.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    public interface LoanInterface {
        //list of data
        List<Loan> loanList = Stream.of(
                new Loan(16752361523423L, 50000.0, "Hostel", "Open", "Shreya", 7656765456L),
                new Loan(87463253635221L, 100000.0, "Rent", "Open", "anusha", 7647342389L),
                new Loan(674563872634L, 150000.0, "College", "Closed", "Gombla", 9874563785L)
        ).collect(Collectors.toList());
        List<Loan> findAll();

}
