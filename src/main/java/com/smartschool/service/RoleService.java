package com.smartschool.service;

import com.smartschool.pojo.Role;
import com.smartschool.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public void save(Role role) {
        roleRepository.save(role);
    }

    public void delete(Role role) {
        roleRepository.delete(role);
    }

    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public Iterable<Role> findAll() {
        return roleRepository.findAll();
    }

    public Iterable<Role> findAllById(Iterable<Long> ids) {
        return roleRepository.findAllById(ids);
    }

    public long count() {
        return roleRepository.count();
    }

    public boolean existsById(Long id) {
        return roleRepository.existsById(id);
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    public void deleteAll() {
        roleRepository.deleteAll();
    }

    public void deleteAll(Iterable<Role> roles) {
        roleRepository.deleteAll(roles);
    }

    public Iterable<Role> saveAll(Iterable<Role> roles) {
        return roleRepository.saveAll(roles);
    }



}
