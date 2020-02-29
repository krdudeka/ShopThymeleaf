package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.wszib.dao.UserDao;
import pl.edu.wszib.domain.User;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("users")
    public String users(Model model) {
        model.addAttribute("users", userDao.getUsers());
        return "users";
    }

    @GetMapping("users/remove/{id}")
    public String remove(@PathVariable Long id) {
        userDao.removeUser(id);
        return "redirect:/users";
    }

    @GetMapping("users/new")
    public String newProduct(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }


}
