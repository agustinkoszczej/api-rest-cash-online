package org.backend.exam.apirestcashonline.repository;

import org.backend.exam.apirestcashonline.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}