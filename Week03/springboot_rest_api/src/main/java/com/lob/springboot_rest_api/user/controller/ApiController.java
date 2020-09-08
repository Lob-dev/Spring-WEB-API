package com.lob.springboot_rest_api.user.controller;

import com.lob.springboot_rest_api.user.dto.UserDTO;
import com.lob.springboot_rest_api.user.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private final UserService userService;

    public ApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/account")
    public String create(createUserForm formdata, Model model) {
        UserDTO userDTO = UserDTO.builder()
                .id(formdata.getId())
                .name(formdata.getName())
                .hr_Organ(formdata.getHr_Organ())
                .build();
        userService.join(userDTO);

        model.addAttribute("user-ID", userDTO.getId());
        return "templates/sucess";
    }

  /*  @GetMapping("/api/users/{id}/{year}/{month}")
    public String getMonthAccessTotal(@PathVariable String id, String year, String Month) {

        return ;
    }

    @GetMapping("/api/users/{id}/{year}/{month}/{day}")
    public String getDaysAccessTotal(@PathVariable String id, String year, String Month, String day ) {

        return null;
    }

    @GetMapping("/api/users/{id}/day/average")
    public String getDaysAverageTotal(@PathVariable String id){

        return null;
    }

    @GetMapping("/api/users/{id}/day/average/not-holiday")
    public String getDaysIsNotHolidayAverageTotal(@PathVariable String id){

        return null;
    }

    @GetMapping("/api/users/{id}/{year}/{month}/{Organ}")
    public String getMonthIsOrganTotal(@PathVariable String id, String year, String Month, String Organ ){

        return null;
    }*/


}
