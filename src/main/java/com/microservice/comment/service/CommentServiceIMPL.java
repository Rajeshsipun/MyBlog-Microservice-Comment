package com.microservice.comment.service;

import com.microservice.comment.config.RestTemplateConfig;
import com.microservice.comment.entity.Comment;
import com.microservice.comment.payload.Post;
import com.microservice.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CommentServiceIMPL implements CommentService {


    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private RestTemplateConfig restTemplateConfig;


    @Override
    public Comment saveComment(Comment comment) {

        Post post = restTemplateConfig.getRestTemplate().getForObject
                ("http://localhost:8082/api/v1/posts/" + comment.getPostId(),
                        Post.class);

            if (post !=null){
                String cmtId = UUID.randomUUID().toString();
                comment.setCommentId(cmtId);

            Comment savedComment = commentRepository.save(comment);
            return savedComment;
        }else {

        return null;
    }
}

    @Override
    public List<Comment> getAllCommentsByPostId(String postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments;
    }
}









