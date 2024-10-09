package com.system.servicio_users.services;

import com.system.servicio_users.models.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public User findById(Integer id);
    public User save (User use);
    public void deleteById(Integer id);

}
