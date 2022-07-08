package com.sii.socialMediaApi.repository;

import com.sii.socialMediaApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);
}
