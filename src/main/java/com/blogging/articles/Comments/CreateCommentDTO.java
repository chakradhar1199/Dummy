package com.blogging.articles.Comments;

import com.blogging.articles.Blog.Blog;
import com.blogging.articles.User.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Getter
public class CreateCommentDTO {
    private String comment;

    private Long commentedByUser;

    private Long blogId;
}
