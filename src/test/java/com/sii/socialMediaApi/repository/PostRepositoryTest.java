package com.sii.socialMediaApi.repository;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.sii.socialMediaApi.model.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@DatabaseSetup("/repositoryTest/post.xml")
public class PostRepositoryTest {

    private final PostRepository postRepository;

    public PostRepositoryTest(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private final static long ALICE_USER_ID = 1l;
    private final static long BOB_USER_ID = 2l;
    private final static long JOHN_USER_ID = 3l;

    @Test
    public void findAllAsc_AliceCanSeeBobAndJohnPosts() {
        //given
        List<Post> posts = postRepository.findAllAsc(ALICE_USER_ID);
        //then
        assertTrue(posts.size() == 3);
        assertTrue(containsPostCreatedByUserId(posts, ALICE_USER_ID));
        assertTrue(containsPostCreatedByUserId(posts, BOB_USER_ID));
        assertTrue(containsPostCreatedByUserId(posts, JOHN_USER_ID));
    }

    @Test
    public void findAllAsc_BobCanSeeOnlyJohnPosts() {
        //given
        List<Post> posts = postRepository.findAllAsc(BOB_USER_ID);
        //then
        assertTrue(posts.size() == 2);
        assertTrue(containsPostCreatedByUserId(posts, BOB_USER_ID));
        assertTrue(containsPostCreatedByUserId(posts, JOHN_USER_ID));
        assertFalse(containsPostCreatedByUserId(posts, ALICE_USER_ID));
    }

    @Test
    public void findAllAsc_BobShouldNotFollowAlicePosts() {
        //given
        List<Post> posts = postRepository.findAllAsc(BOB_USER_ID);
        //then
        assertTrue(posts.size() == 2);
        assertTrue(containsPostCreatedByUserId(posts, BOB_USER_ID));
        assertFalse(containsPostCreatedByUserId(posts, ALICE_USER_ID));
        assertTrue(containsPostCreatedByUserId(posts, JOHN_USER_ID));
    }

    @Test
    public void findAllAsc_JohnShouldNotFollowAnyUsersPosts() {
        //given
        List<Post> posts = postRepository.findAllAsc(JOHN_USER_ID);
        //then
        assertTrue(posts.size() == 1);
        assertTrue(containsPostCreatedByUserId(posts, JOHN_USER_ID));
        assertFalse(containsPostCreatedByUserId(posts, ALICE_USER_ID));
        assertFalse(containsPostCreatedByUserId(posts, BOB_USER_ID));
    }

    private boolean containsPostCreatedByUserId(List<Post> posts, long userId) {
        return posts.stream().map(Post::getUserId).filter(id -> id == userId).findFirst().isPresent();
    }
}