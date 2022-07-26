package com.gliglis.socialMediaApi.controller;

import com.gliglis.socialMediaApi.service.PostService;
import com.gliglis.socialMediaApi.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping
    public Post newPost(@Valid @RequestBody Post post) {
        return postService.addNew(post);
    }

    @GetMapping("/posts/{userId}/{isAsc}")
    public List<Post> loadPosts(@PathVariable @Min(1) Long userId, @PathVariable boolean isAsc) {
        return postService.loadAll(userId, isAsc);
    }
}
