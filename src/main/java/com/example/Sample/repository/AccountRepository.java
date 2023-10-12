package com.example.Sample.repository;

import com.example.Sample.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
      Optional<Account> findByUsername(String username);
}
