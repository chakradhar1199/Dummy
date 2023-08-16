package com.blogging.articles.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository< User, Long> {
    //ToDo:
    // 1. Pagination
}
