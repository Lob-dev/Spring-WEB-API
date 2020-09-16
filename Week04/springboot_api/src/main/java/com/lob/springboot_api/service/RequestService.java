package com.lob.springboot_api.service;

import com.lob.springboot_api.Repository.RequestApiRepository;
import com.lob.springboot_api.dto.DaysTotalDto;
import com.lob.springboot_api.dto.RequestInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
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
        return requestApiRepository.findByMonth(findDate);
    }

    public List<RequestInfo> findByDays(String year, String month, String day) {
        String findDate = year.concat(month).concat(day);
        return requestApiRepository.findByDays(findDate);
    }

    public List<RequestInfo> findByOrgan(String organ) {
        return requestApiRepository.findByOrgan(organ);
    }

    public List<RequestInfo> findByMonthAndOrgan(String year, String month, String organ) {
        String findDate = year.concat(month);
        return requestApiRepository.findByMonthAndOrgan(findDate, organ);
    }


    public List<DaysTotalDto> findByDaysAverage() {
        return requestApiRepository.findByDaysAverage();
    }

    public List<DaysTotalDto> findByNotholidayAverage() {
        return requestApiRepository.findByNotholidayAverage();
    }



}
