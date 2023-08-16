package com.blogging.articles.Comments;

import com.blogging.articles.Base.BaseEntity;
import com.blogging.articles.Blog.Blog;
import com.blogging.articles.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Comment")
@Data
@NoArgsConstructor

public class Comment extends BaseEntity {
    private String comment;

    @ManyToOne
    private User commentedBy;

    @ManyToOne
    private Blog blog;
    @Builder
    public Comment(String comment, User commentedBy, Blog blog) {
        this.comment = comment;
        this.commentedBy = commentedBy;
        this.blog = blog;
    }
}
