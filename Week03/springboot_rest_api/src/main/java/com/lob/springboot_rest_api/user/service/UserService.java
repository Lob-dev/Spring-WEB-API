package com.lob.springboot_rest_api.user.service;

import com.lob.springboot_rest_api.user.Repository.UserRepository;
import com.lob.springboot_rest_api.user.domain.User;
import com.lob.springboot_rest_api.user.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String join(UserDTO userDTO) {
        findLocalMember(userDTO);
        User user = User.builder()
                .id(userDTO.getId())
                .name(userDTO.getName())
                .hr_Organ(userDTO.getHr_Organ())
                .build();

        userRepository.save(user);
        return user.getId();
    }

    private void findLocalMember(UserDTO userDTO) {
        userRepository.findById(userDTO.getId()).ifPresent(u -> {
            throw new IllegalStateException("이미 존재하는 유저입니다.");
        });
    }
}
