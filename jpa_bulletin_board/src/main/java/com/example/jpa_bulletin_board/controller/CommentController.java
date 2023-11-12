package com.example.jpa_bulletin_board.controller;

import com.example.jpa_bulletin_board.dto.request.CommentSaveRequest;
import com.example.jpa_bulletin_board.dto.request.MemberSaveRequest;
import com.example.jpa_bulletin_board.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> saveComment(
            CommentSaveRequest commentSaveRequest,
            @RequestParam("post-id") Long post_id,
            @RequestParam("member-id") Long member_id) {
        commentService.saveComment(commentSaveRequest, post_id, member_id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 댓글 수정
     */
    @PutMapping("/{comment-id}")
    public ResponseEntity<Void> updateComment(
            @PathVariable("comment-id") Long commentId,
            @RequestBody CommentSaveRequest commentSaveRequest) {
        commentService.updateComment(commentId, commentSaveRequest);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 댓글 삭제
     */
    @DeleteMapping("/{comment-id}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable("comment-id") Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
