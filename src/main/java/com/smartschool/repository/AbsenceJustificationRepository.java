package com.smartschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smartschool.pojo.AbsenceJustification;

@Repository
public interface AbsenceJustificationRepository extends JpaRepository<AbsenceJustification, Long> {

}
