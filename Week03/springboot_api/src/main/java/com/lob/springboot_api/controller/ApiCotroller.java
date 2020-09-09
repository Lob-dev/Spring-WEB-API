package com.lob.springboot_api.controller;

import com.lob.springboot_api.entity.RequestInfo;
import com.lob.springboot_api.service.RequestService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONValue;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ApiCotroller {

    private final RequestService requestService;

    public ApiCotroller(RequestService requestService) {
        this.requestService = requestService;
    }


    @GetMapping("/api/users/{year}")
    public ResponseEntity<Object> getMonthAccessTotal(@PathVariable String year) {

        if (year.length() != 4) {
            return ResponseEntity.badRequest().body("This Request {year} is incorrect Value.");
        }
            List<RequestInfo> res = requestService.findByYear(year.substring(2, 4));

        // http://localhost/api/users/2020

        //System.out.println(res);정상적으로 DB의 데이터가 엔티티로 반환됨
        return ResponseEntity.status(HttpStatus.OK).body(JSONArray.toJSONString(res));

    }

}
