package com.blogging.articles.Blog;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class BlogController {

    private BlogService blogService;
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id){
        Blog blog = blogService.getBlogById(id);
        return ResponseEntity.ok(blog);
    }

    @PostMapping("/blog")
    public ResponseEntity<Blog> createBlog(@Valid @RequestBody CreateBlogDTO blogDTO){
        Blog blog = blogService.createBlog(blogDTO);
        return ResponseEntity.created(URI.create("/blog/"+blog.getId())).body(blog);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getAllBlogs(){
        List<Blog> blogList = blogService.getAllBlogs();
        return ResponseEntity.ok(blogList);
    }
}
