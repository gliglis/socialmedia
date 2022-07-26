package com.gliglis.socialMediaApi.service;

import com.gliglis.socialMediaApi.model.Post;
import com.gliglis.socialMediaApi.repository.PostRepository;
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

    public Post addNew(Post post) {
        return postRepository.save(post);
    }
}
