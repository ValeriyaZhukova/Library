package kz.iitu.library.controller;

import kz.iitu.library.model.User;
import kz.iitu.library.repository.UserRepository;
import kz.iitu.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id)
    {
        return userService.getUserByID(id);
    }

    @PostMapping("/auth/register")
    public void createUserByUsernamePassword(@RequestParam String username, @RequestParam String password)
    {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        userService.createUser(user);
    }

    @GetMapping("/auth/")
    public User login(@RequestParam String username, @RequestParam String password)
    {
        return (User)userService.loadUserByUsername(username);
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user)
    {
        userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id,
                           @RequestBody User user)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication.getName() = " + authentication.getName());

        userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id)
    {
        userService.deleteUser(id);
    }



}
