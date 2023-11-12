package com.example.jpa_bulletin_board.controller;

import com.example.jpa_bulletin_board.domain.Member;
import com.example.jpa_bulletin_board.dto.request.PostSaveRequest;
import com.example.jpa_bulletin_board.dto.response.PostListDetailResponse;
import com.example.jpa_bulletin_board.dto.response.PostListResponse;
import com.example.jpa_bulletin_board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> savePost(@RequestBody PostSaveRequest postsaveRequest, @RequestParam("member_id") Long memberId) {
        postService.savePost(postsaveRequest, memberId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<PostListResponse> findPostList() {
        List<PostListResponse> responseList = postService.findPostList();
        return responseList;
    }

    @GetMapping("/search")
    public List<PostListResponse> findPostListByTitle(@RequestParam("title") String title) {
        List<PostListResponse> responseList = postService.findPostListByTitle(title);
        return responseList;
    }

    @GetMapping("/search/email/{email}")
    public List<PostListResponse> findPostListByEmail(@RequestParam("email") String email) {
        List<PostListResponse> responseList = postService.findPostListByEmail(email);
        return responseList;
    }

    @GetMapping("/search/{post-id}")
    public PostListDetailResponse findPostListDetail(@RequestParam("post-id") Long postId) {
        return (PostListDetailResponse) postService.findPostListDetail(postId);
    }
}
