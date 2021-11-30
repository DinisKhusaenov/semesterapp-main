package ru.kpfu.itis.listeners;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kpfu.itis.repositories.*;
import ru.kpfu.itis.services.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;

@WebListener
public class AppConfigServletContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        Properties properties = new Properties();
        try {
            properties.load(servletContext.getResourceAsStream("/WEB-INF/properties/db.properties"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }

        // HikariCP for dataSource
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(properties.getProperty("db.url"));
        hikariConfig.setDriverClassName(properties.getProperty("db.driver.classname"));
        hikariConfig.setUsername(properties.getProperty("db.username"));
        hikariConfig.setPassword(properties.getProperty("db.password"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikari.max-pool-size")));
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        servletContext.setAttribute("dataSource", dataSource);

        // UsersRepository
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryJdbcImpl(dataSource);
        UsersService usersService = new UsersServiceImpl(usersRepository, authRepository);
        servletContext.setAttribute("usersService", usersService);

        // DeputyRepository
        DeputyRepository deputyRepository = new DeputyRepositoryJdbcImpl(dataSource);
        DeputyService deputyService = new DeputyServiceImpl(deputyRepository);
        servletContext.setAttribute("deputyService", deputyService);

        // NewsRepository
        NewsRepository newsRepository = new NewsRepositoryJdbcImpl(dataSource);
        NewsService newsService = new NewsServiceImpl(newsRepository);
        servletContext.setAttribute("newsService", newsService);

        // PasswordEncoder
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        servletContext.setAttribute("passwordEncoder", passwordEncoder);
    }

}
