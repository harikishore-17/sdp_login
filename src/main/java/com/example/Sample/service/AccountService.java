package com.example.Sample.service;

import com.example.Sample.entity.Account;
import com.example.Sample.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {
      @SuppressWarnings("unused")
      @Autowired private AccountRepository accountRepository;

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Account> accountOptional = accountRepository.findByUsername(username);
            if(accountOptional.isPresent()) {
                  Account account = accountOptional.get();
                  return new User(account.getUsername(), account.getPassword(), account.getAuthorities());
            } else throw new UsernameNotFoundException(username + " not found");
      }
}