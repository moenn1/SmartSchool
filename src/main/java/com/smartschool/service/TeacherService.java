package com.smartschool.service;

import com.smartschool.pojo.Teacher;
import com.smartschool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void delete(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    public Teacher findById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Iterable<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Iterable<Teacher> findAllById(Iterable<Long> ids) {
        return teacherRepository.findAllById(ids);
    }

    public long count() {
        return teacherRepository.count();
    }

    public boolean existsById(Long id) {
        return teacherRepository.existsById(id);
    }

    public void deleteById(Long id) {
        teacherRepository.deleteById(id);
    }

    public void deleteAll() {
        teacherRepository.deleteAll();
    }

    public void deleteAll(Iterable<Teacher> teachers) {
        teacherRepository.deleteAll(teachers);
    }

    public Iterable<Teacher> saveAll(Iterable<Teacher> teachers) {
        return teacherRepository.saveAll(teachers);
    }

}
