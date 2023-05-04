package com.smartschool.service;


import com.smartschool.pojo.Account;
import com.smartschool.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;


    public AccountService() {
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void save(Account account) {
        accountRepository.save(account);
    }

    public void delete(Account account) {
        accountRepository.delete(account);
    }

    public Account getAccountById(Long id) {
        return accountRepository.getOne(id);
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public boolean exists(Long id) {
        return accountRepository.existsById(id);
    }

    public long count() {
        return accountRepository.count();
    }

    public void deleteAll() {
        accountRepository.deleteAll();
    }

    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    public Iterable<Account> saveAll(Iterable<Account> iterable) {
        return accountRepository.saveAll(iterable);
    }

    public Iterable<Account> findAllById(Iterable<Long> iterable) {
        return accountRepository.findAllById(iterable);
    }

    /*
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public Account findByUsernameAndPassword(String username, String password) {
        return accountRepository.findByUsernameAndPassword(username, password);
    }

    public Account findByEmailAndPassword(String email, String password) {
        return accountRepository.findByEmailAndPassword(email, password);
    }

    public Account findByUsernameOrEmail(String username, String email) {
        return accountRepository.findByUsernameOrEmail(username, email);
    }

    */

}
