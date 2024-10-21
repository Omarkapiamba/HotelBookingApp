package com.example.hotelbookingapp.service.impl;

import com.example.hotelbookingapp.entity.userManagement.UserAccount;
import com.example.hotelbookingapp.exceptions.EmailException;
import com.example.hotelbookingapp.exceptions.UserNotFoundException;
import com.example.hotelbookingapp.repository.UserAccountRepository;
import com.example.hotelbookingapp.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    public final UserAccountRepository userRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserAccount createUserAccount(UserAccount user) {
        String newEmail = user.getEmail();
        boolean emailAlreadyExist = userRepository.getUserAccountByEmail(newEmail).isPresent();

        Pattern pattern;
        Matcher matcher; //TODO skapa mönster för mejl.

        if (newEmail == null || newEmail.isEmpty()) {
            throw new EmailException("Email är obligatoriskt och måste fyllas i");
        }
        if (emailAlreadyExist) {
            throw new EmailException(String.format("Email: %s finns redan registrerad", newEmail));
        } else
            return userRepository.save(user);

    }

    @Override
    public List<UserAccount> getAllUserAccounts() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserAccount> getUserAccountById(Long id) {
        Optional<UserAccount> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            return existingUser;
        }
        throw new UserNotFoundException("Finns ingen användare med id: " + id);


    }

    @Override
    public Optional<UserAccount> getUserByEmail(String email) {
        Optional<UserAccount> existingUser = userRepository.getUserAccountByEmail(email);
        if (existingUser.isPresent()) {
            return userRepository.getUserAccountByEmail(email);
        }
        throw new EmailException(String.format("Användare med email: %s finns inte", email));

    }

    @Override
    public UserAccount updateUserAccount(UserAccount updatedUser) {

        //TODO Jag ska kunna updatera en user med samma email (funkar inte just nu).
        Long updatedUserId = updatedUser.getId();
        String updatedUserEmail = updatedUser.getEmail();
        Optional<UserAccount> existingUser = userRepository.findById(updatedUserId);
        Optional<UserAccount> isExistingUserByEmail = userRepository.getUserAccountByEmail(updatedUserEmail);

        if (existingUser.isPresent()) {
            if (isExistingUserByEmail.isEmpty()) {
                return userRepository.save(updatedUser);
            } else
                throw new EmailException(String.format("Mail: %s finns redan registrerad", updatedUserEmail));
        } else
            throw new UserNotFoundException(String.format("User med id: %s finns inte", updatedUserId));

    }

    @Override
    public void deleteUserAccountById(Long id) {
        Optional<UserAccount> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            userRepository.deleteById(id);
        } else
            throw new UserNotFoundException(String.format("Användare med id: %s finns inte", id));
    }

        /*
    Andra metoder jag ska lägga till

    authenticateUser
    changePassword
    resetPassword
    lockUserAccount
    unlockUserAccount
    getAllReviews
    writeReview
     */
}
