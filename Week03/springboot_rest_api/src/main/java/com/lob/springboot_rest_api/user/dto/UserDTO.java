package com.lob.springboot_rest_api.user.dto;

import lombok.*;

@Builder
@Getter @NoArgsConstructor @AllArgsConstructor
public class UserDTO {

    private String id;
    private String name;
    private String hr_Organ;

}
