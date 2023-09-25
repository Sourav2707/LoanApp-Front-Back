package com.bridgelabz.finserve.repository;

import com.bridgelabz.finserve.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "Select * from user_reg where bzlxmn_email = ?", nativeQuery = true)
    User findAllByEmail(String bzlxmn_email);

}
