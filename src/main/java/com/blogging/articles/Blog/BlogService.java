package com.blogging.articles.Blog;

import com.blogging.articles.Exceptions.BlogNotFoundException;
import com.blogging.articles.Exceptions.UserNotFoundException;
import com.blogging.articles.User.User;
import com.blogging.articles.User.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.BadLocationException;
import java.util.List;

@Service
@AllArgsConstructor
public class BlogService {
    private BlogRepo blogRepo;
    private UserService userService;

    public Blog getBlogById(Long id){
        Blog blog = blogRepo.getReferenceById(id);
        if(blog == null){
            throw new BlogNotFoundException(id.toString());
        }
        return blog;
    }

    public Blog createBlog(CreateBlogDTO blogDTO) {
        User user = userService.getUser(blogDTO.getAuthor());
        if(user == null){
            throw new UserNotFoundException(blogDTO.getAuthor().toString());
        }
        else {
            Blog blog = Blog.builder()
                    .title(blogDTO.getTitle())
                    .blogContent(blogDTO.getBlogContent())
                    .description(blogDTO.getDescription())
                    .author(user)
                    .build();
            return blogRepo.save(blog);
        }
    }

    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }
}
