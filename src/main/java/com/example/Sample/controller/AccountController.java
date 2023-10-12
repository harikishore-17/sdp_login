package com.example.Sample.controller;

import com.example.Sample.dto.CredentialsDto;
import com.example.Sample.entity.Account;
import com.example.Sample.repository.AccountRepository;
import com.example.Sample.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
      @Autowired private AccountRepository accountRepository;
      @Autowired private AccountService accountService;
      @Autowired private PasswordEncoder passwordEncoder;

      @GetMapping
      public ResponseEntity<String> welcome() {
            return new ResponseEntity<>("Anyone can access", HttpStatus.OK);
      }

      @GetMapping("/user")
      public ResponseEntity<String> user() {
            return new ResponseEntity<>("Authenticated can access", HttpStatus.OK );
      }

      @GetMapping("/student")
      @PreAuthorize("hasAuthority('STUDENT')")
      public ResponseEntity<String> student() {
            return new ResponseEntity<>("Student can access", HttpStatus.OK );
      }

      @GetMapping("/admin")
      @PreAuthorize("hasAuthority('ADMIN')")
      public ResponseEntity<String> admin() {
            return new ResponseEntity<>("Admin can access", HttpStatus.OK );
      }

      @Transactional
      @PostMapping
      @PreAuthorize("hasAuthority('ADMIN')")
      public ResponseEntity<String> createUser(@RequestBody CredentialsDto credentialsDto) {
            Account account = new Account(
                    credentialsDto.getUsername(),
                    passwordEncoder.encode(credentialsDto.getPassword()),
                    credentialsDto.getRole()
            );
            accountRepository.save(account);
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
      }
}
