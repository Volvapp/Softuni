package org.springintro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springintro.data.entities.User;
import org.springintro.data.repositories.UserRepository;
import org.springintro.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(User user) {
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public User findUserById(int id) {
        Optional<User> optional = this.userRepository.findById(id);
        if (optional.isPresent()){
            return optional.get();
        }
        System.out.println("No such user with given id - " + id);
        return null;
    }
}
