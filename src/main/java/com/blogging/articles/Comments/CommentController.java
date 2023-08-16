package com.blogging.articles.Comments;

import com.blogging.articles.Blog.Blog;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;
    @PostMapping("/comment")
    public ResponseEntity<Comment> createComment(@RequestBody CreateCommentDTO commentDTO){
        Comment comment = commentService.createComment(commentDTO);
        return ResponseEntity.created(URI.create("/comment/"+comment.getCommentedBy())).body(comment);
    }

    @DeleteMapping("/remove-comment/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.removeComment(id);
    }
}
