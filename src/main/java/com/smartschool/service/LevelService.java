package com.smartschool.service;

import com.smartschool.pojo.Level;
import com.smartschool.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LevelService {
    @Autowired
    LevelRepository levelRepository;

    public void save(Level level) {
        levelRepository.save(level);
    }

    public void delete(Level level) {
        levelRepository.delete(level);
    }

    public Level getLevelById(Long id) {
        return levelRepository.getOne(id);
    }

    public Iterable<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    public boolean exists(Long id) {
        return levelRepository.existsById(id);
    }

    public long count() {
        return levelRepository.count();
    }

    public void deleteAll() {
        levelRepository.deleteAll();
    }

    public void deleteById(Long id) {
        levelRepository.deleteById(id);
    }

    public Iterable<Level> saveAll(Iterable<Level> iterable) {
        return levelRepository.saveAll(iterable);
    }

    public Iterable<Level> findAllById(Iterable<Long> iterable) {
        return levelRepository.findAllById(iterable);
    }

    public Level findByCode(String code) {
        return levelRepository.findByCode(code);
    }

    public Level findByName(String name) {
        return levelRepository.findByName(name);
    }


}
