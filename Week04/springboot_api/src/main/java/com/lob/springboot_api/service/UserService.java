package com.lob.springboot_api.service;

import com.lob.springboot_api.Repository.UserRepository;
import com.lob.springboot_api.entity.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findUser(String userID) {
         return userRepository.findByUser(userID);
    }

    public String join(UserDto userDto) {

        List<UserDto> user = userRepository.findByUser(userDto.getUserID());
        if(user.isEmpty()){
            userRepository.save(userDto);
            return userDto.getUserID();
        }

        return "이미 있는 유저입니다.";
    }
}
