package com.lob.springboot_api.controller;


import com.lob.springboot_api.entity.CreateForm;
import com.lob.springboot_api.dto.UserDto;
import com.lob.springboot_api.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;

@Controller
@RequestMapping(value = "/api")
public class AccountController {

    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/account")
    public String createUserForm() {
        return "user/CreateUserForm";
    }

    @PostMapping("/account")
    public String userAccount(CreateForm createform) {
        UserDto user = new UserDto();

        user.setUserID(createform.getId());
        user.setUsername(createform.getName());
        user.setHr_Organ(createform.getOrgan());
        user.setPassword(createform.getPassword());

        String res = userService.join(user);
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
        UserDto userDto = new UserDto();
        userDto.setUserID(createform.getId());
        userDto.setPassword(createform.getPassword());
        userDto.setHr_Organ(createform.getOrgan());
        userDto.setUsername(createform.getName());
        boolean res = userService.findByUserAndPassword(createform.getId(), createform.getPassword());
        if(res){ httpSession.setAttribute("user",userDto); }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String userLogout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }


}
