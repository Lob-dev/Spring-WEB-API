package com.lob.springboot_rest_api.user.domain;

import lombok.*;

@Builder @Getter @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of = "userId")
public class User {

    private String id;
    private String name;
    private String hr_Organ;


}
