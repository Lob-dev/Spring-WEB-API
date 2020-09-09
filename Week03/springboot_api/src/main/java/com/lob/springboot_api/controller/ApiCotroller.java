package com.lob.springboot_api.controller;

import com.lob.springboot_api.entity.RequestInfo;
import com.lob.springboot_api.service.RequestService;
import net.minidev.json.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
public class ApiCotroller {

    private final RequestService requestService;

    public ApiCotroller(RequestService requestService) {
        this.requestService = requestService;
    }


    @GetMapping("/api/users/{year}")
    public ResponseEntity getMonthAccessTotal(@PathVariable String year) {

        List<RequestInfo> res  = requestService.findByYear(year);
        //System.out.println(res);

        return ResponseEntity.ok().body(JSONArray.toJSONString(res));
    }

}
