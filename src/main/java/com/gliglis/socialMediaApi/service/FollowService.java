package com.gliglis.socialMediaApi.service;

import com.gliglis.socialMediaApi.repository.FollowRepository;
import com.gliglis.socialMediaApi.model.Follow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository followRepository;

    public boolean followOrUnfollow(Long userId, Long followedId) {
        if (shouldFollow(userId, followedId)) {
            follow(userId, followedId);
            return true;
        } else {
            unfollow(userId, followedId);
            return false;
        }
    }

    private boolean shouldFollow(Long userId, Long followedId) {
        return followRepository.findByUserIdAndFollowedUserId(userId, followedId) == null;
    }

    private void follow(Long userId, Long followedId) {
        followRepository.save(Follow.builder()
                .userId(userId)
                .followedUserId(followedId)
                .build());
    }

    private void unfollow(Long userId, Long followedId) {
        followRepository.deleteByUserIdAndFollowedUserId(userId, followedId);
    }
}