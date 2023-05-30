package com.example.tapaz.controller;

import com.example.tapaz.dto.UserDto;
import com.example.tapaz.entity.User;
import com.example.tapaz.manager.UserManager;
import com.example.tapaz.pagenation.UserPageResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")

public class UserController {
    public final UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping
    public UserPageResponse getAll(int page, int count){
        return userManager.getAll(page,count);
    }
    @GetMapping("/{id}")
    public UserDto getById(@PathVariable int id){
        return userManager.getById(id);
    }
    @PostMapping("/post")
    public void saveUser(@RequestBody @Valid User user){
        userManager.saveUser(new UserDto(user.getName(), user.getMail()));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        userManager.deleteById(id);
    }
}
