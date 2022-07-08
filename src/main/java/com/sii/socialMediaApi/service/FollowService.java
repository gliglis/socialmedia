package com.sii.socialMediaApi.service;

import com.sii.socialMediaApi.model.Follow;
import com.sii.socialMediaApi.repository.FollowRepository;
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