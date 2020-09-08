package com.lob.springboot_rest_api.request.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder @Getter @NoArgsConstructor @AllArgsConstructor
public class RequestInfo {

    private String requestCode;
    private String EXPLAIN;
}
