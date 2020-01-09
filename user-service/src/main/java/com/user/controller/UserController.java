package com.user.controller;

import com.user.domain.exception.UserExistException;
import com.user.domain.exception.UserNotExistException;
import com.user.dto.UserDto;
import com.user.mapper.UserMapper;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/users")
public class UserController {
    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userMapper.mapToUserDtoList(userService.findAllUsers());
    }

    @GetMapping("/id/{id}")
    public UserDto getUserById(@PathVariable Long id) throws UserNotExistException {
        return userMapper.mapToUserDto(userService.findUserById(id));
    }

    @GetMapping("/email/{email}")
    public UserDto getUserByEmail(@PathVariable String email) throws UserNotExistException {
        return userMapper.mapToUserDto(userService.findUserByEmail(email));
    }

    @GetMapping("/exist/{email}")
    public boolean isUserExist(@PathVariable String email) {
        return userService.isUserExist(email);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) throws UserExistException {
        userService.createUser(userMapper.mapToUser(userDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userMapper.mapToUserDto(userService.updateUser(userMapper.mapToUser(userDto)));
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long id) throws UserNotExistException {
        userService.deleteUser(userService.findUserById(id));
    }
}