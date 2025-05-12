package com.Services;

import com.DTOS.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    UserDTO createUser(UserDTO user);

    UserDTO updateUser(UserDTO user);

    void deleteUser(Long id);
}