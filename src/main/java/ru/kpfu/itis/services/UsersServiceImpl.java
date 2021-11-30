package ru.kpfu.itis.services;

import ru.kpfu.itis.exceptions.DuplicateEntryException;
import ru.kpfu.itis.exceptions.WrongEmailOrPasswordException;
import ru.kpfu.itis.form.LoginForm;
import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.models.User;
import ru.kpfu.itis.repositories.AuthRepository;
import ru.kpfu.itis.repositories.UsersRepository;

import javax.servlet.http.Cookie;
import java.util.List;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final AuthRepository authRepository;

    public UsersServiceImpl(UsersRepository usersRepository, AuthRepository authRepository) {
        this.usersRepository = usersRepository;
        this.authRepository = authRepository;
    }



    @Override
    public void save(User entity) {
        usersRepository.save(entity);
    }

    @Override
    public void delete(User entity) {
        usersRepository.delete(entity);
    }

    @Override
    public void deleteByEmail(String email) {
        usersRepository.deleteByEmail(email);
    }

    @Override
    public void update(User entity) {
        usersRepository.update(entity);
    }

    @Override
    public void updateByEmail(String firstName, String lastName, String email) {
        usersRepository.updateByEmail(firstName, lastName, email);
    }

    @Override
    public void updateDeputiesIdByID(Long deputies_id, Long id) {
        usersRepository.updateDeputiesIdByID(deputies_id, id);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<User> findOneByEmail(String email) {
        return usersRepository.findOneByEmail(email);
    }

    @Override
    public void signUp(UserForm userForm) throws DuplicateEntryException {
        usersRepository.signUp(userForm);
    }

    @Override
    public Cookie signIn(LoginForm loginForm) throws WrongEmailOrPasswordException {
        return usersRepository.signIn(loginForm);
    }
}
