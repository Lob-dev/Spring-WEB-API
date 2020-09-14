package com.lob.springboot_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lob.springboot_api.entity.ResponseResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.hateoas.server.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiCotrollerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void RequestForYearEvent() throws Exception{
        ResponseResource responseResource = new ResponseResource();
        responseResource.setTitle("2020년 접속자 통계");
        responseResource.setDescription("2020년 기준 접속자 통계입니다.");
        responseResource.setTotal_Count("50");
        responseResource.setYear("2020");
        responseResource.add(linkTo(ApiCotroller.class).slash("2020").withSelfRel());
        responseResource.add(linkTo(ApiCotroller.class).withRel("prev-link"));

        mockMvc.perform(get("/api/users/2020")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(responseResource)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").exists())
                .andExpect(jsonPath("description").exists())
                .andExpect(jsonPath("year").exists())
                .andExpect(jsonPath("total_Count").exists())
                .andExpect(jsonPath("links[0].rel").exists())
                .andExpect(jsonPath("links[1].rel").exists());
    }
}