package com.gliglis.socialMediaApi.repository;

import com.gliglis.socialMediaApi.model.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {

    Follow findByUserIdAndFollowedUserId(Long userId, Long followedId);

    Follow deleteByUserIdAndFollowedUserId(Long userId, Long followedId);
}
