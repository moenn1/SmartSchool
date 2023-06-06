package com.smartschool.repository;

import com.smartschool.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByCne(String cne);

    Student findByLname(String name);
}
