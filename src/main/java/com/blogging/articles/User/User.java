package com.blogging.articles.User;

import com.blogging.articles.Base.BaseEntity;
import com.blogging.articles.Blog.Blog;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity(name = "users")
@NoArgsConstructor
@Getter
public class User extends BaseEntity {
    @NotBlank
    private String name;
    @NotBlank
    private String  password;
    private String picLink;
    private String bio;
    @Email
    private String email;
    @OneToMany
    private  List<Blog> myBlogs;
    @ManyToMany
    @JoinTable(
            name = "followers",
            joinColumns = @JoinColumn(name = "following_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private List<User> followers;
    @ManyToMany(mappedBy = "followers")
    private List<User> following;
    @Builder
    public User(String name, String password, String picLink, String bio, String email) {
        this.name = name;
        this.password = password;
        this.picLink = picLink;
        this.bio = bio;
        this.email = email;
    }

    //    constructor

}
