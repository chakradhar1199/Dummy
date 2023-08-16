package com.blogging.articles.Blog;

import com.blogging.articles.Base.BaseEntity;

import com.blogging.articles.Comments.Comment;
import com.blogging.articles.User.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "blogs")
@NoArgsConstructor
public class Blog extends BaseEntity {
    @NotEmpty
    private String title;
    private String description;
    private String blogContent;
    @OneToOne
    private User author;

    @ManyToMany
    @JoinTable(

    )
    private List<User> likes;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments;
    @Builder
    public Blog(String title, String description, String blogContent, User author) {
        this.title = title;
        this.description = description;
        this.blogContent = blogContent;
        this.author = author;
    }
}
