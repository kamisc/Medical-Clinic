package com.user.service;

import com.user.domain.User;
import com.user.domain.exception.UserExistException;
import com.user.domain.exception.UserNotExistException;
import com.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(final Long id) throws UserNotExistException {
        return userRepository.findById(id).orElseThrow(UserNotExistException::new);
    }

    public User findUserByEmail(final String email) throws UserNotExistException {
        if(!userRepository.existsByEmail(email)) {
            throw new UserNotExistException(email);
        }
        return userRepository.findByEmail(email);
    }

    public boolean isUserExist(final String email) {
        return userRepository.existsByEmail(email);
    }

    public User createUser(final User user) throws UserExistException {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new UserExistException(user.getEmail());
        }
        return userRepository.save(user);
    }

    public User updateUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteUser(final User user) throws UserNotExistException {
        if(!userRepository.existsByEmail(user.getEmail())) {
            throw new UserNotExistException(user.getEmail());
        }
        userRepository.delete(user);
    }
}