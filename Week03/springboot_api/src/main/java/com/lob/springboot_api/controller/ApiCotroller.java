package com.lob.springboot_api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lob.springboot_api.entity.RequestInfo;
import com.lob.springboot_api.entity.ResourceStatus;
import com.lob.springboot_api.entity.ResponseResource;
import com.lob.springboot_api.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/api/users")
public class ApiCotroller {

    private final RequestService requestService;

    public ApiCotroller(RequestService requestService) {
        this.requestService = requestService;
    }


    @GetMapping("/{year}")
    public ResponseEntity<Object> getMonthAccessTotal(@PathVariable String year) throws JsonProcessingException {

        if (year.length() != 4) {
            return ResponseEntity.badRequest().body("This Request {year} is incorrect Value.");
        }
        List<RequestInfo> res = requestService.findByYear(year.substring(2, 4));



        //bulider
        ResponseResource responseResource = new ResponseResource();
        responseResource.setTitle("2020년 접속자 통계");
        responseResource.setDescription("2020년 기준 접속자 통계입니다.");
        responseResource.setTotal_Count(String.valueOf(res.size()));
        responseResource.setYear(year);
        responseResource.setIs_Success(ResourceStatus.TRUE);
        responseResource.add(linkTo(ApiCotroller.class).slash(year).withSelfRel());
        responseResource.add(linkTo(ApiCotroller.class).withRel("prev-link"));

        ObjectMapper objectMapper = new ObjectMapper();
        String responseString = objectMapper.writeValueAsString(responseResource);

        // ResponseEntity.status(HttpStatus.OK).body(JSONArray.toJSONString(res));
        //System.out.println(res);정상적으로 DB의 데이터가 엔티티로 반환됨

        // http://localhost/api/users/2020

        return ResponseEntity.status(HttpStatus.OK).body(responseString);

    }

}
