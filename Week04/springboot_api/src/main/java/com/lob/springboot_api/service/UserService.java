package com.lob.springboot_api.service;

import com.lob.springboot_api.Repository.UserRepository;
import com.lob.springboot_api.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findByUser(String userID) {
         return userRepository.findByUser(userID);
    }

    public void findByUserAndPassword(String userID, String password) {
        userRepository.findByUserAndPassword(userID, password)
                .orElseThrow(RuntimeException::new);
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
