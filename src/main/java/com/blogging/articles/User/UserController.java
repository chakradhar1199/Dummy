package com.blogging.articles.User;

import com.blogging.articles.Exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    //TODo:
    // 1. Security
    // 2. JWT Authentication
    // 3. Password Encoding
    // 4. Test cases (junit)
    // 5. pagination for all the api calls
    private UserService userService;


    @PostMapping("/user")
    public ResponseEntity<User> createUser(@Valid @RequestBody CreateUserDTO userDTO){
        User user = userService.createUSer(userDTO);
        return ResponseEntity.created(URI.create("/user/"+user.getId())).body(user);
    }

    //get particular user
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUser(id);
        if (user == null) {
            throw new UserNotFoundException(id.toString());
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete-user/{id}")
    public void deleteUser(Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
