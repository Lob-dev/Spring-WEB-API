package com.lob.springboot_rest_api.request.domain;

import lombok.*;

@Builder @Getter @NoArgsConstructor @AllArgsConstructor
public class RequestCode {

    private String requestCode;
    private Long userId;
    private String create_Date;
}
