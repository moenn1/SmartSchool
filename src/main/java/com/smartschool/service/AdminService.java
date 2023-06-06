package com.smartschool.service;

import com.smartschool.pojo.Admin;
import com.smartschool.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public AdminService() {
    }

    public AdminRepository getAdminRepository() {
        return adminRepository;
    }

    public void setAdminRepository(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void save(Admin admin) {
        adminRepository.save(admin);
    }

    public void delete(Admin admin) {
        adminRepository.delete(admin);
    }

    public Admin getAdminById(Long id) {
        return adminRepository.getOne(id);
    }

    public Iterable<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public boolean exists(Long id) {
        return adminRepository.existsById(id);
    }

    public long count() {
        return adminRepository.count();
    }

    public void deleteAll() {
        adminRepository.deleteAll();
    }

    public void deleteById(Long id) {
        adminRepository.deleteById(id);
    }

    public Iterable<Admin> saveAll(Iterable<Admin> iterable) {
        return adminRepository.saveAll(iterable);
    }

    public Iterable<Admin> findAllById(Iterable<Long> iterable) {
        return adminRepository.findAllById(iterable);
    }



}
