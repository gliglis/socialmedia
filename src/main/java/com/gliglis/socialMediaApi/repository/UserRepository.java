package com.gliglis.socialMediaApi.repository;

import com.gliglis.socialMediaApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
}
