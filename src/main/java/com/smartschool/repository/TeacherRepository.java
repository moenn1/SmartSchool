package com.smartschool.repository;

import com.smartschool.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findByUsername(String username);

    Teacher findByEmail(String email);

    Teacher findByCin(String cin);

    //    Teacher findByLoginOrEmail(String username, String email);


}
