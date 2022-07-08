package com.sii.socialMediaApi.controller;

import com.sii.socialMediaApi.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/follow")
public class FollowController {

    private final FollowService followService;

    @PutMapping
    public ResponseEntity addOrRemove(long userId, long followedId) {
        boolean follow = followService.followOrUnfollow(userId, followedId);
        return ResponseEntity.ok(String.format("Successfully add s%!", follow ? "follow" : "unfollow"));
    }
}
