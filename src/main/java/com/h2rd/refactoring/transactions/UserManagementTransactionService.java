package com.h2rd.refactoring.transactions;

import com.h2rd.refactoring.repository.UserRepository;
import com.j2rd.refactoring.entity.User;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserManagementTransactionService
{
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Optional<User> findUserByName(String name) {
        return Optional.ofNullable(userRepository.findUserByName(name));
    }
    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }
    
    @Transactional
    public User updateUser(final String id , User user) {
        return userRepository.save(user);
    }
    @Transactional
    public void deleteUserByName(final String name) {
        User user= userRepository.findUserByName(name);
        if(user==null)
        {
            //TODO need to log
        }
         userRepository.delete(user);
    }
    
    
}