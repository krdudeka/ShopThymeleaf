package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.User;


import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin
public class UserRestController {

    @Autowired
    private UserDao userDao;

    @GetMapping("users")
    public List<User> users() {
        return userDao.getUsers();
    }

    @DeleteMapping("users/remove/{id}")
    public void removeUser(@PathVariable Long id) {
        userDao.removeUser(id);
    }

    @PostMapping("users/save")
    public void saveProduct(@RequestBody User user) {
        userDao.saveUser(user);
    }

    @GetMapping("users/single/{id}")
    public User getUser(@PathVariable Long id) {
        return userDao.getById(id);
    }

}


