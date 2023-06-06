package com.smartschool.service;

import com.smartschool.pojo.Module;
import com.smartschool.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModuleService {
    @Autowired
    ModuleRepository moduleRepository;

    public void save(Module module) {
        moduleRepository.save(module);
    }

    public void delete(Module module) {
        moduleRepository.delete(module);
    }

    public Module findById(Long id) {
        return moduleRepository.findById(id).orElse(null);
    }

    public Iterable<Module> findAll() {
        return moduleRepository.findAll();
    }

    public Iterable<Module> findAllById(Iterable<Long> ids) {
        return moduleRepository.findAllById(ids);
    }

    public long count() {
        return moduleRepository.count();
    }

    public boolean existsById(Long id) {
        return moduleRepository.existsById(id);
    }

    public void deleteById(Long id) {
        moduleRepository.deleteById(id);
    }

    public void deleteAll() {
        moduleRepository.deleteAll();
    }

    public void deleteAll(Iterable<Module> modules) {
        moduleRepository.deleteAll(modules);
    }

    public Iterable<Module> saveAll(Iterable<Module> modules) {
        return moduleRepository.saveAll(modules);
    }


    public Module findByCode(String code) {
        return moduleRepository.findByCode(code);
    }

    public Module findByName(String name) {
        return moduleRepository.findByName(name);
    }


}
