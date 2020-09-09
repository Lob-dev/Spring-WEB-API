package com.lob.springboot_api.service;

import com.lob.springboot_api.Repository.RequestApiRepository;
import com.lob.springboot_api.entity.RequestInfo;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RequestService {

    private final RequestApiRepository requestApiRepository;

    public RequestService(RequestApiRepository requestApiRepository) {
        this.requestApiRepository = requestApiRepository;
    }

    public List<RequestInfo> findByYear(String year) {
        return requestApiRepository.findByYear(year);
    }
}
