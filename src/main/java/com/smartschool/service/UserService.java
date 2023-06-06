package com.smartschool.service;

import com.smartschool.pojo.User;
import com.smartschool.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public Iterable<User> findAllById(Iterable<Long> ids) {
        return userRepository.findAllById(ids);
    }

    public long count() {
        return userRepository.count();
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void deleteAll(Iterable<User> users) {
        userRepository.deleteAll(users);
    }

    public Iterable<User> saveAll(Iterable<User> users) {
        return userRepository.saveAll(users);
    }
}
