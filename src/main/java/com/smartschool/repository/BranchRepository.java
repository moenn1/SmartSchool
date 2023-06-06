package com.smartschool.repository;

import com.smartschool.pojo.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {

        public Branch findByCode(String code);

        public Branch findByName(String name);
}
