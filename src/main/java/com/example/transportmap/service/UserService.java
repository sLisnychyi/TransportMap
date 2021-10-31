package com.example.transportmap.service;

import com.example.transportmap.model.User;
import com.example.transportmap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final List<User> privilegedUsers;

    public UserService(UserRepository userRepository,
                       @Value("${services.user.cache.size}") int cacheSize) {
        this.userRepository = userRepository;
        this.privilegedUsers = new ArrayList<>(cacheSize);
    }

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    public List<User> getPrivilegedUsers() {
        return privilegedUsers;
    }
}
