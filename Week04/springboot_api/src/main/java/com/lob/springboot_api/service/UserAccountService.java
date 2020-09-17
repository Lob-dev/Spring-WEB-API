package com.lob.springboot_api.service;

import com.lob.springboot_api.Repository.UserAccountRepository;
import com.lob.springboot_api.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {

    private final UserAccountRepository userAccountRepository;

    public UserService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public List<UserDto> findByUser(String userID) {
         return userAccountRepository.findByUser(userID);
    }

    public boolean findByUserAndPassword(String userID, String password) {
        boolean res = userAccountRepository.findByUserAndPassword(userID, password);
        return res;
    }

    public String join(UserDto userDto) {

        List<UserDto> user = userAccountRepository.findByUser(userDto.getUserID());
        if(user.isEmpty()){
            userAccountRepository.save(userDto);
            return userDto.getUserID();
        }

        return "이미 있는 유저입니다.";
    }
}
