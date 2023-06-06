package com.smartschool.service;

import com.smartschool.pojo.Branch;
import com.smartschool.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
    @Autowired
    BranchRepository branchRepository;


    public Branch saveBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    public Branch getBranchById(Long id) {
        return branchRepository.findById(id).get();
    }

    public Iterable<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    public void deleteBranch(Branch branch) {
        branchRepository.delete(branch);
    }

    public void deleteBranchById(Long id) {
        branchRepository.deleteById(id);
    }

    public void deleteAllBranches() {
        branchRepository.deleteAll();
    }

    public long countBranches() {
        return branchRepository.count();
    }

    public boolean existsBranch(Long id) {
        return branchRepository.existsById(id);
    }

    public Iterable<Branch> saveAllBranches(Iterable<Branch> iterable) {
        return branchRepository.saveAll(iterable);
    }

    public Iterable<Branch> findAllByIdBranch(Iterable<Long> iterable) {
        return branchRepository.findAllById(iterable);
    }

    public Branch findByCode(String code) {
        return branchRepository.findByCode(code);
    }

    public Branch findByName(String name) {
        return branchRepository.findByName(name);
    }

}
