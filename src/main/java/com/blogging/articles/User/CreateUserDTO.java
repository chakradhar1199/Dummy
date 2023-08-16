package com.blogging.articles.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class CreateUserDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String  password;
    private String picLink;
    private String bio;
    @Email
    private String email;
}
