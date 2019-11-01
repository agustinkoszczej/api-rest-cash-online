package org.backend.exam.apirestcashonline.repository;

import org.backend.exam.apirestcashonline.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {}