package com.sii.socialMediaApi.service;

import com.sii.socialMediaApi.model.Follow;
import com.sii.socialMediaApi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<Long> getUserIdAndFollowedUserId(Long userId) {
        List<Long> userIdAndFollowedUserId = userRepository.findUserById(userId).getFollowed().stream()
                .map(Follow::getFollowedUserId)
                .collect(Collectors.toList());
        userIdAndFollowedUserId.add(userId);
        return userIdAndFollowedUserId;
    }
}
