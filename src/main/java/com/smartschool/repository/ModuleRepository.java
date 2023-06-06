package com.smartschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<com.smartschool.pojo.Module, Long> {

    public com.smartschool.pojo.Module findByCode(String code);

    public com.smartschool.pojo.Module findByName(String name);
}
