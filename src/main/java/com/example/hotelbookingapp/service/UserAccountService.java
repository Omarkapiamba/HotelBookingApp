package com.example.hotelbookingapp.service;

import com.example.hotelbookingapp.entity.userManagement.UserAccount;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

    UserAccount createUserAccount(UserAccount newUserAccount);

    List<UserAccount> getAllUserAccounts();

    Optional<UserAccount> getUserAccountById(Long id);

    Optional<UserAccount> getUserByEmail(String email);

    UserAccount updateUserAccount(UserAccount newUserAccount);

    void deleteUserAccountById(Long id);


}
