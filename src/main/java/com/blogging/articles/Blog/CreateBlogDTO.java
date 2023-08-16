package com.blogging.articles.Blog;


import com.blogging.articles.User.User;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CreateBlogDTO {
    @NotEmpty
    private String title;
    private String description;
    private String blogContent;

    private Long author;
}
