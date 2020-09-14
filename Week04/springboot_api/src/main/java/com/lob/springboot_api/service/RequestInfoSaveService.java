package com.lob.springboot_api.service;

import com.lob.springboot_api.Repository.RequestApiRepository;
import com.lob.springboot_api.entity.RequestInfo;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RequestInfoSaveService {

    private final RequestApiRepository requestApiRepository;

    public RequestInfoSaveService(RequestApiRepository requestApiRepository) {
        this.requestApiRepository = requestApiRepository;
    }

    public RequestInfo requestForWriteBoard(String userID, String wb) {
        //날짜 입력
        Date today = new Date();
        SimpleDateFormat createDateFormat = new SimpleDateFormat("yyMMddHHmm");
        //데이터베이스에 Request log 저장
        return requestApiRepository.save(userID, wb, createDateFormat.format(today));
    }

}
