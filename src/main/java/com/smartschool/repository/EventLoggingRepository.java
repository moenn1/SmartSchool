package com.smartschool.repository;

import com.smartschool.pojo.EventLogging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLoggingRepository extends JpaRepository<EventLogging, Long> {
}
