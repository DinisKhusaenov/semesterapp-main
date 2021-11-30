package ru.kpfu.itis.services;

import ru.kpfu.itis.exceptions.DuplicateEntryException;
import ru.kpfu.itis.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.form.LoginForm;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.models.User;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Optional;

public interface UsersService {
    void save(User entity);
    void delete(User entity);
    void deleteByEmail(String email);
    void update(User entity);
    void updateByEmail(String firstName, String lastName, String email);
    void updateDeputiesIdByID(Long deputies_id, Long id);
    List<User> getAllUsers();
    Optional<User> findById(Long id);
    Optional<User> findOneByEmail(String email);

    void signUp(UserForm userForm) throws DuplicateEntryException;
    Cookie signIn(LoginForm loginForm) throws WrongEmailOrPasswordException;
}
