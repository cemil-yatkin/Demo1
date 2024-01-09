package com.SpringProjectOne.Demo1.service;

import com.SpringProjectOne.Demo1.dto.UserDTO;
import com.SpringProjectOne.Demo1.repository.UserRepository;

import java.util.List;

public interface IUserService {

    UserDTO getUserById(Long userId);
    List<UserDTO> saveAllUsers(List<UserDTO> userDTO);
}
