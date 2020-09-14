package com.lob.springboot_api.controller;


import com.lob.springboot_api.entity.AccountResource;
import com.lob.springboot_api.entity.CreateForm;
import com.lob.springboot_api.entity.UserDto;
import com.lob.springboot_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;

@Controller
public class AccountController {

    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/account")
    public String createUserForm() {
        return "user/CreateUserForm";
    }

    @PostMapping("/api/account")
    public String userAccount(CreateForm createform) {
        UserDto user = new UserDto();

        System.out.println(createform.getId());
        System.out.println(createform.getName());
        System.out.println(createform.getOrgan());

        user.setUserID(createform.getId());
        user.setUsername(createform.getName());
        user.setHr_Organ(createform.getOrgan());

        System.out.println("form 데이터 확인");


        String res = userService.join(user);
        if(res.equals("이미 있는 유저입니다.")){
        }

        return "redirect:/";
    }
}
