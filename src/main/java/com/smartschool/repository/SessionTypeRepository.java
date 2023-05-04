package com.smartschool.repository;

import com.smartschool.pojo.SessionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionTypeRepository extends JpaRepository<SessionType, Long> {

}
