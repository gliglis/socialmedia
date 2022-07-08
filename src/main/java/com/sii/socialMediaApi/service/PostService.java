package com.sii.socialMediaApi.service;

import com.sii.socialMediaApi.model.Post;
import com.sii.socialMediaApi.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public List<Post> loadAll(long userId, boolean isAsc) {
        return isAsc ? postRepository.findAllAsc(userId) : postRepository.findAllDesc(userId);
    }
}
