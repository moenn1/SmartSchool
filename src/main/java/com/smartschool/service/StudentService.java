package com.smartschool.service;

import com.smartschool.pojo.Student;
import com.smartschool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    public Iterable<Student> findAllById(Iterable<Long> ids) {
        return studentRepository.findAllById(ids);
    }

    public long count() {
        return studentRepository.count();
    }

    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

    public void deleteAll(Iterable<Student> students) {
        studentRepository.deleteAll(students);
    }

    public Iterable<Student> saveAll(Iterable<Student> students) {
        return studentRepository.saveAll(students);
    }

    public Student findByCne(String cne) {
        return studentRepository.findByCne(cne);
    }

    public Student findByName(String name){
        return studentRepository.findByLname(name);
    }

}
