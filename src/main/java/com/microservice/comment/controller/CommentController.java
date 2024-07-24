package com.microservice.comment.controller;


import com.microservice.comment.entity.Comment;
import com.microservice.comment.service.CommentService;
import com.microservice.comment.service.CommentServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    @Autowired
    private CommentService commentService ;

    //http://localhost:8083/api/v1/comment
    @PostMapping
  public ResponseEntity<Comment> saveComment(@RequestBody Comment comment ){
        Comment comment1 = commentService.saveComment(comment);
        return new ResponseEntity<>(comment1, HttpStatus.OK);
  }


//http://localhost:8083/api/ v1/comment/{postId}
  @GetMapping("{postId}")
  public List<Comment>getAllCommentsByPostId(@PathVariable String postId){
       List<Comment>comments = commentService.getAllCommentsByPostId(postId);
       return comments;
  }
}
