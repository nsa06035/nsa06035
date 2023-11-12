package com.example.jpa_bulletin_board.dto.request;

import com.example.jpa_bulletin_board.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class CommentSaveRequest {
    private String content;
    private String author;

    public Comment toEntity() {
        return new Comment(content, author);
    }
}
