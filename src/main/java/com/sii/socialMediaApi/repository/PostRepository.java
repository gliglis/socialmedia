package com.sii.socialMediaApi.repository;

import com.sii.socialMediaApi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.userId IN (SELECT f.followedUserId FROM Follow f WHERE f.userId = :userId) AND p.userId = :userId ORDER BY p.createDate")
    List<Post> findAllAsc(Long userId);

    @Query("SELECT p FROM Post p WHERE p.userId IN (SELECT f.followedUserId FROM Follow f WHERE f.userId = :userId) AND p.userId = :userId ORDER BY p.createDate DESC")
    List<Post> findAllDesc(Long userId);
}
