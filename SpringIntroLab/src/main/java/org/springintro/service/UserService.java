package org.springintro.service;

import org.springintro.data.entities.User;

public interface UserService{
    void register(User user);

    User findUserById(int id);
}
