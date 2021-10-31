package com.example.transportmap.repository;


import com.example.transportmap.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public class DefaultUserRepository implements UserRepository{
    private final JdbcTemplate jdbcTemplate;

    public DefaultUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int saveUser(User user) {
        //todo DB usage
        return jdbcTemplate.update("insert into users (name, age) values (?, ?)", user.getName(), user.getAge());

    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> getUsers(String name) {
        return null;
    }

    @Override
    public Map<Integer, Integer> getUserCountByAge() {
        return null;
    }


}
