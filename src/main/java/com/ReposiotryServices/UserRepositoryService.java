package com.ReposiotryServices;

import com.DTOS.UserDTO;
import com.Domian.UserEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Reposiotry.UserRepository;
import com.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserRepositoryService {
    private final UserRepository userRepository;

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return getUserEntityByIdOrElseThrow(id);
    }


    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    private UserEntity getUserEntityByIdOrElseThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with give id :" + id));
    }
}
