package com.smartschool.repository;

import com.smartschool.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);

    Account findByEmail(String email);

    //    Account findByLoginOrEmail(String username, String email);
}
