package org.backend.exam.apirestcashonline.controller;

import org.backend.exam.apirestcashonline.exception.ResourceNotFoundException;
import org.backend.exam.apirestcashonline.model.Loan;
import org.backend.exam.apirestcashonline.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("/cash-online")
public class LoanController {
    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/loans")
    public List<Loan> getLoans(
            @RequestParam("page") int page,
            @RequestParam("size") int size,
            @RequestParam(value = "user_id", required = false) Long userId)
            throws ResourceNotFoundException {
        ;
        return loanRepository
                .findAll(PageRequest.of(page, size))
                .getContent()
                .stream()
                .filter(loan -> loan.getUser().getId() == userId || userId == null)
                .collect(Collectors.toList());
        //.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    }
}