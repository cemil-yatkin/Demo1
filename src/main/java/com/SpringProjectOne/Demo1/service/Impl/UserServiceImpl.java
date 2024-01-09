package com.SpringProjectOne.Demo1.service.Impl;

import com.SpringProjectOne.Demo1.dto.UserDTO;
import com.SpringProjectOne.Demo1.entity.UserEntity;
import com.SpringProjectOne.Demo1.repository.UserRepository;
import com.SpringProjectOne.Demo1.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDTO userDTO;
    @Autowired
    UserEntity userEntity;

    @Override
    public UserDTO getUserById(Long userId) {
        final List<UserEntity> allUsersById = userRepository.findUserById(userId);
        allUsersById.forEach(user -> {
                    userDTO.setName(user.getUsername());
                    userDTO.setSurname(user.getUserSurname());
                    userDTO.setEmail(user.getUserEmail());
                }
        );
        return userDTO;
    }

    @Override
    public List<UserDTO> saveAllUsers(List<UserDTO> userDTO) {
        userDTO.forEach(user -> {
            userEntity.setUsername(user.getName());
            userEntity.setUserId(user.getUserId());
            userEntity.setUserSurname(user.getSurname());
            userEntity.setUserEmail(user.getEmail());
        });
        userRepository.saveAndFlush(userEntity);
        userDTO.forEach(user -> user.setPassword(""));
        log.info("All users are saved" + userDTO);
        return userDTO;
    }
}
