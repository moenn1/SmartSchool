package com.smartschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartschool.pojo.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
