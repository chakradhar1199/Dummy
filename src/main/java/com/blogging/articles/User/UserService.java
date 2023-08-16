package com.blogging.articles.User;

import com.blogging.articles.Exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepo userRepo;

    public User createUSer(CreateUserDTO userDTO){
        User user = User.builder()
                .bio(userDTO.getBio())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .picLink(userDTO.getPicLink())
                .build();
        return userRepo.save(user);

    }

    public User getUser(Long id) {
        return userRepo.getReferenceById(id);
    }

    public void deleteUser(Long id) {
        User user = userRepo.getReferenceById(id);
        if(user == null)
        {
            throw new UserNotFoundException(id.toString());
        }
        userRepo.delete(user);
    }

    public List<User> getAllUsers() {

        return userRepo.findAll();
    }
}
