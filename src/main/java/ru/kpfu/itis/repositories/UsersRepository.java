package ru.kpfu.itis.repositories;

import ru.kpfu.itis.exceptions.DuplicateEntryException;
import ru.kpfu.itis.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.form.LoginForm;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.models.User;

import javax.servlet.http.Cookie;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findOneByEmail(String email);
    void deleteByEmail(String email);
    void updateByEmail(String firstName, String lastName, String email);
    void updateDeputiesIdByID(Long deputies_id, Long id);
    void signUp(UserForm userForm) throws DuplicateEntryException;
    Cookie signIn(LoginForm loginForm) throws WrongEmailOrPasswordException;
}
