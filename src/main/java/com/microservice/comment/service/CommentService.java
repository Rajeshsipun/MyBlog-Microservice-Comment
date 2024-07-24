package com.microservice.comment.service;

import com.microservice.comment.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);

    List<Comment> getAllCommentsByPostId(String postId);
}
