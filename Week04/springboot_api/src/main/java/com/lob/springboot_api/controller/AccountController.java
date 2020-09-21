package com.lob.springboot_api.controller;


import com.lob.springboot_api.dto.CreateForm;
import com.lob.springboot_api.dto.UserDto;
import com.lob.springboot_api.service.UserAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;

@Controller
@RequestMapping(value = "/api")
public class AccountController {

    private final UserAccountService userAccountService;

    public AccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/account")
    public String createUserForm() {
        return "user/CreateUserForm";
    }

    @PostMapping("/account")
    public String userAccount(CreateForm createform) {

        UserDto userDto = new UserDto.Builder()
                .userId(createform.getId())
                .password(createform.getPassword())
                .hr_Organ(createform.getOrgan())
                .username(createform.getName())
                .build();

        String res = userAccountService.join(userDto);
        if(res.equals("이미 있는 유저입니다.")){
            return res;
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginUserForm() {
        return "user/LoginUserForm";
    }

    @PostMapping("/login")
    public String userLogin(HttpSession httpSession, CreateForm createform, Errors errors){

        UserDto userDto = new UserDto.Builder()
                .userId(createform.getId())
                .password(createform.getPassword())
                .hr_Organ(createform.getOrgan())
                .username(createform.getName())
                .build();

        boolean res = userAccountService.findByUserAndPassword(createform.getId(), createform.getPassword());
        if(res){ httpSession.setAttribute("user",userDto); }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String userLogout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }


}
