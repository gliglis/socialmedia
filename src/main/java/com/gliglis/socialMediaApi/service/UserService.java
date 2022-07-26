package com.gliglis.socialMediaApi.service;

import com.gliglis.socialMediaApi.repository.UserRepository;
import com.gliglis.socialMediaApi.model.Follow;
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
