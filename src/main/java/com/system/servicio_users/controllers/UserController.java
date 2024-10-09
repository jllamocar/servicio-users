package com.system.servicio_users.controllers;

import com.system.servicio_users.models.User;
import com.system.servicio_users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> finAll() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }

    @PostMapping("/user")
    private User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/user/{id}")
    public User update(@RequestBody User user, @PathVariable Integer id){
        User userActualizar = userService.findById(id);

        userActualizar.setNombre(user.getNombre());
        userActualizar.setApellido(user.getApellido());
        userActualizar.setCargo(user.getCargo());

        return userService.save(userActualizar);
    }

    @DeleteMapping("/user/{id}")
    public void delete (@PathVariable Integer id){
        userService.deleteById(id);
    }

}
