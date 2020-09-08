package com.lob.springboot_rest_api.user.service;

import com.lob.springboot_rest_api.user.Repository.JdbcTemplateUserRepository;
import com.lob.springboot_rest_api.user.domain.User;
import com.lob.springboot_rest_api.user.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final JdbcTemplateUserRepository userRepository;

    public UserService(JdbcTemplateUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long join(UserDTO userDTO) {
        validateDuplicateMember(userDTO);
        User user = User.builder()
                .name(userDTO.getName())
                .hr_Organ(userDTO.getHr_Organ())
                .build();

        userRepository.save(user);
        return user.getId();
    }

    private void validateDuplicateMember(UserDTO userDTO) {
        userRepository.findByName(userDTO.getName()).ifPresent(u -> {
            throw new IllegalStateException("이미 존재하는 유저입니다.");
        })



    }

}
