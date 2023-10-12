package com.example.Sample.dto;

import com.example.Sample.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredentialsDto {
      private String username;
      private String password;
      private String role;

      public CredentialsDto(Account account) {
            this.username = account.getUsername();
            this.password = account.getPassword();
            this.role = account.getRole();
      }
}
