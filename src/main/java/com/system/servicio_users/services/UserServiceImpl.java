package com.system.servicio_users.services;

import com.system.servicio_users.models.User;
import com.system.servicio_users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly=true)
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=false)
    public User save(User use) {
        return userRepository.save(use);
    }

    @Override
    @Transactional(readOnly=false)
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
