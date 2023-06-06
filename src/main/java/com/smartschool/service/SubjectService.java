package com.smartschool.service;

import com.smartschool.pojo.Subject;
import com.smartschool.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    public void delete(Subject subject) {
        subjectRepository.delete(subject);
    }

    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }


    public Iterable<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Iterable<Subject> findAllById(Iterable<Long> ids) {
        return subjectRepository.findAllById(ids);
    }

    public long count() {
        return subjectRepository.count();
    }

    public boolean existsById(Long id) {
        return subjectRepository.existsById(id);
    }

    public void deleteById(Long id) {
        subjectRepository.deleteById(id);
    }

    public void deleteAll() {
        subjectRepository.deleteAll();
    }

    public void deleteAll(Iterable<Subject> subjects) {
        subjectRepository.deleteAll(subjects);
    }

    public Iterable<Subject> saveAll(Iterable<Subject> subjects) {
        return subjectRepository.saveAll(subjects);
    }

}
