package kz.iitu.library.service;

import kz.iitu.library.model.User;
import kz.iitu.library.model.UserRole;
import kz.iitu.library.repository.UserRepository;
import kz.iitu.library.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class UserService {

    Scanner scanner = new Scanner(System.in);

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    List<User> users = new ArrayList<>();

    public void addNewUser()
    {
        String name;
        String surname;
        String role;
        UserRole userRole;

        System.out.println("Enter user name");
        name = scanner.next();

        System.out.println("Enter user name");
        surname = scanner.next();

        System.out.println("Enter role");
        role = scanner.next();

        if (role.equals("Member"))
        {
            userRole = userRoleRepository.getOne(1L);
        }

        else if (role.equals("Librarian"))
        {
            userRole = userRoleRepository.getOne(2L);
        }

        else
        {
            userRole = null;
        }

        User user = new User(name, surname, userRole);

        userRepository.save(user);

        System.out.println(user.toString() + "\nsuccessfully saved");
    }

    public void listUsers()
    {
        for (User u: userRepository.findAll())
        {
            users.add(u);
            System.out.println(u.toString());
        }
    }

    public User findUserByNameAndSurname()
    {
        String name;
        String surname;

        System.out.println("Enter user name");
        name = scanner.next();

        System.out.println("Enter user name");
        surname = scanner.next();

        User user = userRepository.findUserByNameAndSurname(name, surname);
        return user;
    }



}
