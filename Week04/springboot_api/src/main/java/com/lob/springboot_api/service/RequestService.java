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

    public List<RequestInfo> findByMonths(String year, String month) {
        String findDate = year.concat(month);
        System.out.println(findDate);
        return requestApiRepository.findByMonth(findDate);
    }


    /*public List<RequestInfo> findByDays(String substring, String month, String day) {
        return requestApiRepository.findByDays();
    }

    public List<RequestInfo> findByMonths(String year, String month) {
        return requestApiRepository.findByMonth(year,month);
    }*/






}
