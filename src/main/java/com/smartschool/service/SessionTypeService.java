package com.smartschool.service;

import com.smartschool.pojo.SessionType;
import com.smartschool.repository.SessionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class SessionTypeService {
    @Autowired
    SessionTypeRepository sessionTypeRepository;

    public void save(SessionType sessionType) {
        sessionTypeRepository.save(sessionType);
    }

    public void delete(SessionType sessionType) {
        sessionTypeRepository.delete(sessionType);
    }

    public SessionType findById(Long id) {
        return sessionTypeRepository.findById(id).orElse(null);
    }

    public Iterable<SessionType> findAll() {
        return sessionTypeRepository.findAll();
    }

    public Iterable<SessionType> findAllById(Iterable<Long> ids) {
        return sessionTypeRepository.findAllById(ids);
    }

    public long count() {
        return sessionTypeRepository.count();
    }

    public boolean existsById(Long id) {
        return sessionTypeRepository.existsById(id);
    }

    public void deleteById(Long id) {
        sessionTypeRepository.deleteById(id);
    }

    public void deleteAll() {
        sessionTypeRepository.deleteAll();
    }

    public void deleteAll(Iterable<SessionType> sessionTypes) {
        sessionTypeRepository.deleteAll(sessionTypes);
    }

    public Iterable<SessionType> saveAll(Iterable<SessionType> sessionTypes) {
        return sessionTypeRepository.saveAll(sessionTypes);
    }

}
