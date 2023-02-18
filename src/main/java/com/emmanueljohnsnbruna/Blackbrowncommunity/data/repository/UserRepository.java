package com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
