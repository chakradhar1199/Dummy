package com.blogging.articles.Comments;

import com.blogging.articles.Blog.Blog;
import com.blogging.articles.Blog.BlogService;
import com.blogging.articles.Exceptions.BlogNotFoundException;
import com.blogging.articles.Exceptions.CommentNotFoundException;
import com.blogging.articles.Exceptions.UserNotFoundException;
import com.blogging.articles.User.User;
import com.blogging.articles.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    private CommentRepo commentRepo;
    private UserService userService;
    private BlogService blogService;

    public Comment createComment(CreateCommentDTO commentDTO) {
//        fetch the user and blog for the comment posted.
        User user = userService.getUser(commentDTO.getCommentedByUser());
        if(user == null){throw new UserNotFoundException(commentDTO.getCommentedByUser().toString());
        }
        Blog blog = blogService.getBlogById(commentDTO.getBlogId());
        if(blog == null){throw new BlogNotFoundException(commentDTO.getBlogId().toString());
        }

        Comment comment = Comment.builder()
                .comment(commentDTO.getComment())
                .commentedBy(user)
                .blog(blog)
                .build();
        return commentRepo.save(comment);
    }

    public void removeComment(Long id) {
        Comment comment = commentRepo.getReferenceById(id);
        if(comment == null){
            throw new CommentNotFoundException(id.toString());
        }
        commentRepo.delete(comment);
    }
}
