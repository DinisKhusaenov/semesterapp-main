package ru.kpfu.itis.repositories;

import ru.kpfu.itis.models.Auth;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;


public class AuthRepositoryJdbcImpl implements AuthRepository {

    private final DataSource dataSource;
    private final SimpleJdbcTemplate template;

    public AuthRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.template = new SimpleJdbcTemplate(dataSource);
    }


    @Override
    public Auth findByCookieValue(String cookieValue) {
        return null;
    }

    @Override
    public void save(Auth entity) {

    }

    @Override
    public void update(Auth entity) {

    }

    @Override
    public void delete(Auth entity) {

    }

    @Override
    public Optional<Auth> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Auth> findAll() {
        return null;
    }
}
