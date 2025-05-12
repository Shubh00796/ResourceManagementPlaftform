package com.ServiceImpl;

import com.DTOS.UserDTO;
import com.Domian.ResourceEntity;
import com.Domian.UserEntity;
import com.Mapper.UserMapper;
import com.ReposiotryServices.UserRepositoryService;
import com.Services.UserService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepositoryService userRepositoryService;
    private final UserMapper mapper;
    private final Validator validator;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepositoryService.getAllUsers()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserEntity userById = userRepositoryService.getUserById(id);
        return mapper.toDto(userById);
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        UserEntity userEntity = mapper.toEntity(user);
        validateUserEntity(userEntity);
        UserEntity savedUser = userRepositoryService.createUser(userEntity);


        return mapper.toDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        UserEntity existingUser = userRepositoryService.getUserById(user.getId());
        mapper.updateEntityFromDto(user, existingUser);
        UserEntity updatedUser = userRepositoryService.createUser(existingUser);
        return mapper.toDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepositoryService.deleteUser(id);

    }

    private void validateUserEntity(UserEntity user) {
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
