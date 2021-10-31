package com.example.transportmap.repository;


import com.example.transportmap.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    @Transactional
    public User saveUser(User user) {
//        return jdbcTemplate.update("insert into users (name, age) values (?, ?)", user.getName(), user.getAge());
        entityManager.persist(user);
        return user;
    }

    @Override
    public List<User> getUsers() {
//        return jdbcTemplate.query("select * from users",
//                (rs, rowNum) -> new User(rs.getString("name"), rs.getInt("age")));
        return entityManager.createQuery("Select a from User a", User.class)
                .getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getUsers(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> from = query.from(User.class);
        query.select(from)
                .where(criteriaBuilder.like(from.get("name"), name));
        return null;
    }

    @Override
    public Map<Integer, Integer> getUserCountByAge() {
        return null;
    }


}
