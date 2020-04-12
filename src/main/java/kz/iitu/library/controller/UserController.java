package kz.iitu.library.controller;

import kz.iitu.library.model.User;
import kz.iitu.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id)
    {
        return userRepository.findById(id).get();
    }

    @GetMapping("/find/")
    public List<User> getByNameContainingAndAge(@RequestParam("Name") String name,
                                                @RequestParam("Surname") String surname)
    {
        return userRepository.findUserByNameContainingAndSurnameContaining(name, surname);
    }

    @PostMapping("")
    public User createUser(@RequestBody User user)
    {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public  User updateUser(@PathVariable("id") Long id,
                            @RequestBody User user)
    {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id)
    {
        User user = new User();
        user.setId(id);
        userRepository.delete(user);
    }



}
