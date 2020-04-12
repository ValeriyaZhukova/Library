package kz.iitu.library.repository;

import kz.iitu.library.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByNameAndSurname(String name, String surname);

    public List<User> findUserByNameContainingAndSurnameContaining(String name, String surname);
}
