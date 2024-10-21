package com.example.hotelbookingapp.repository;

import com.example.hotelbookingapp.entity.userManagement.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> getUserAccountByEmail (String email);
}
