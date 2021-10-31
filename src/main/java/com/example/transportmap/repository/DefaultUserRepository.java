package com.example.transportmap.repository;


import com.example.transportmap.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

@Repository
@Profile("prod")
public class DefaultUserRepository implements UserRepository {
    //    private final JdbcTemplate jdbcTemplate;
    private final EntityManager entityManager;

    public DefaultUserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public int saveUser(User user) {
//        return jdbcTemplate.update("insert into users (name, age) values (?, ?)", user.getName(), user.getAge());
        return 0;
    }

    @Override
    public List<User> getUsers() {
//        return jdbcTemplate.query("select * from users",
//                (rs, rowNum) -> new User(rs.getString("name"), rs.getInt("age")));
        return null;
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
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
