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

    public void requestForWriteBoard(String userID, String wb) {
        // request code = WB / code_explain = WRITEBOARD
        // requestID Generate value +1 / userID userID / requestCode = requestcode.requestCode / createDate = dateTime
        // requestService.requestForWriteBoard(UserDTO.getUserID,"WB") Logic을 진행할 때 DATE 생성 (datetime format YYMMDDhhmm)


        //날짜 입력
        Date today = new Date();
        SimpleDateFormat createDateFormat = new SimpleDateFormat("yyMMddHHmm");


        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setUserID(userID);
        requestInfo.setRequestCode(wb);
        requestInfo.setCreateDate(createDateFormat.format(today));
        requestApiRepository.save(requestInfo);
    }

    public List<RequestInfo> findByYear(String year) {
        return requestApiRepository.findByYear(year);
    }
}
