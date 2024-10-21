package com.example.hotelbookingapp.controller;

import com.example.hotelbookingapp.entity.userManagement.UserAccount;
import com.example.hotelbookingapp.service.impl.UserAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserAccountController {
    private final UserAccountServiceImpl userAccountService;

    @Autowired
    public UserAccountController(UserAccountServiceImpl userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserAccount> createUserAccount(@RequestBody UserAccount userAccount) {
        UserAccount createdUser = userAccountService.createUserAccount(userAccount);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<UserAccount>> getAllUserAccounts() {
        List<UserAccount> accountList = userAccountService.getAllUserAccounts();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserAccount> getUserAccountById(@PathVariable Long id) {
        return userAccountService.getUserAccountById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "/email")
    public ResponseEntity<UserAccount> getUserAccountByEmail(@RequestParam String email) {
        return userAccountService.getUserByEmail(email)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(path = "/update")
    public UserAccount updateUserAccount(@RequestBody UserAccount userAccount) {
        return userAccountService.updateUserAccount(userAccount);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable Long id) {
        userAccountService.deleteUserAccountById(id);
        return new ResponseEntity<>(String.format("Kund med id: %s är nu raderad", id), HttpStatus.ACCEPTED);
    }
}
