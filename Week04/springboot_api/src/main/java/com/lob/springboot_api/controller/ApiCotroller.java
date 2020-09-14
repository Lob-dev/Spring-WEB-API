package com.lob.springboot_api.controller;

import com.lob.springboot_api.entity.RequestInfo;
import com.lob.springboot_api.entity.ResponseResource;
import com.lob.springboot_api.entity.UserDto;

import com.lob.springboot_api.service.RequestInfoSaveService;
import com.lob.springboot_api.service.RequestService;
import com.lob.springboot_api.service.UserService;
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
    // API 요청 컨트롤러
    // request code = WB / code_explain = WRITEBOARD
    // requestID Generate value +1 / userID userID / requestCode = requestcode.requestCode / createDate = dateTime
    // requestService.requestForWriteBoard(UserDTO.getUserID,"WB") Logic을 진행할 때 DATE 생성 (datetime format YYMMDDhhmm)

    private final RequestService requestService;
    private final RequestInfoSaveService requestInfoSaveService;
    private final UserService userService;

    public ApiCotroller(RequestService requestService, RequestInfoSaveService requestInfoSaveService, UserService userService) {
        this.requestService = requestService;
        this.requestInfoSaveService = requestInfoSaveService;
        this.userService = userService;
    }

    /**
     * get 요청된 URL Resource (year)를 기준으로 DB 데이터의 통계를 뽑아오는 메서드
     * @author lob
     * @param year 검색 기준 (년도)
     * @return ResponseEntity에 responseResource에 setting한 결과값을 json 형태로 반환한다.
     */
    @GetMapping("/{year}")
    public ResponseEntity<Object> getYearAccessTotal(@PathVariable String year){
        if (year.length() != 4) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This Request {year} is incorrect Value.");
        }
        //검색한 대상의 정보를 저장
        UserDto user = new UserDto();
        //Path Variable이 없으므로 (user id, name 등) guest 로 작성
        user.setUserID("guest");
        user.setUsername("Guest");
        user.setHr_Organ("None");
        requestInfoSaveService.requestForWriteBoard(user.getUserID(),"WB");

        //DB 검색 결과
        List<RequestInfo> res = requestService.findByYear(year.substring(2, 4));

        //Event Resource bulider (set)
        ResponseResource responseResource = new ResponseResource();
        responseResource.setTitle("2020년 접속자 통계");
        responseResource.setDescription("2020년 기준 접속자 통계입니다.");
        responseResource.setTotal_Count(String.valueOf(res.size()));
        responseResource.setYear(year);
        responseResource.add(linkTo(ApiCotroller.class).slash(year).withSelfRel());
        responseResource.add(linkTo(ApiCotroller.class).withRel("prev-link"));

        //Event Resource send
        return ResponseEntity.status(HttpStatus.OK).body(responseResource);
    }


    /**
     * get 요청된 URL Resource (year 과 month )를 기준으로 DB 데이터의 통계를 뽑아오는 메서드
     * @author lob
     * @param year,month 검색 기준 (년도, 달)
     * @return ResponseEntity에 responseResource에 setting한 결과값을 json 형태로 반환한다.
     */
    @GetMapping("/{id}/{year}/{month}")
    public ResponseEntity<Object> getMonthAccessTotal(@PathVariable String id,@PathVariable String year,@PathVariable String month) {
        UserDto user = new UserDto();
        user.setUserID(id);
        //id 값을 이용해서 해당 유저 정보를 가져오고 (request info에 저장될 user id)
        //id 값이 없으면 bad request를 반환.
        List<UserDto> userRes = userService.findUser(user.getUserID());
        if(userRes.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist..");
        }
        requestInfoSaveService.requestForWriteBoard(id,"WB");

        List<RequestInfo> res = requestService.findByMonths(year.substring(2, 4), month);

        ResponseResource responseResource = new ResponseResource();
        responseResource.setTitle("2020년 접속자 통계");
        responseResource.setDescription("2020년 기준 접속자 통계입니다.");
        responseResource.setTotal_Count(String.valueOf(res.size()));
        responseResource.setYear(year);
        responseResource.add(linkTo(ApiCotroller.class).slash(year).withSelfRel());
        responseResource.add(linkTo(ApiCotroller.class).withRel("prev-link"));

        return ResponseEntity.status(HttpStatus.OK).body(responseResource);
    }


    /**
     * get 요청된 URL Resource (년도)를 기준으로 DB 데이터의 통계를 뽑아오는 메서드
     * @author lob
     * @param year,month,day 검색 기준 (년도, 달, 일)
     * @return ResponseEntity에 responseResource에 setting한 결과값을 json 형태로 반환한다.
     */
    /*@GetMapping("{id}/{year}/{month}/{day}")
    public ResponseEntity<Object> getDaysAccessTotal(@PathVariable String id, String year, String month, String day ) {
        UserDto user = new UserDto();
        user.setUserID(id);

        List<UserDto> userRes = userService.findUser(user.getUserID());
        if(userRes.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist..");
        }
        requestInfoSaveService.requestForWriteBoard(id,"WB");


        List<RequestInfo> res = requestService.findByDays(year.substring(2, 4), month, day);

        ResponseResource responseResource = new ResponseResource();
        responseResource.setTitle("2020년 접속자 통계");
        responseResource.setDescription("2020년 기준 접속자 통계입니다.");
        responseResource.setTotal_Count(String.valueOf(res.size()));
        responseResource.setYear(year);
        responseResource.setIs_Success(ResourceStatus.TRUE);
        responseResource.add(linkTo(ApiCotroller.class).slash(year).withSelfRel());
        responseResource.add(linkTo(ApiCotroller.class).withRel("prev-link"));




        return null;
    }

    @GetMapping("{id}/day/average")
    public ResponseEntity<Object> getDaysAverageTotal(@PathVariable String id){
        UserDto user = new UserDto();
        user.setUserID(id);

        List<UserDto> userRes = userService.findUser(user.getUserID());
        if(userRes.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist..");
        }
        requestInfoSaveService.requestForWriteBoard(id,"WB");

        return null;
    }

    @GetMapping("{id}/day/average/not-holiday")
    public ResponseEntity<Object> getDaysIsNotHolidayAverageTotal(@PathVariable String id){
        UserDto user = new UserDto();
        user.setUserID(id);

        List<UserDto> userRes = userService.findUser(user.getUserID());
        if(userRes.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist..");
        }
        requestInfoSaveService.requestForWriteBoard(id,"WB");

        return null;
    }

    @GetMapping("{id}/{year}/{month}/{Organ}")
    public ResponseEntity<Object> getMonthIsOrganTotal(@PathVariable String id, String year, String Month, String Organ ){
        UserDto user = new UserDto();
        user.setUserID(id);

        List<UserDto> userRes = userService.findUser(user.getUserID());
        if(userRes.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User does not exist..");
        }
        requestInfoSaveService.requestForWriteBoard(id,"WB");

        return null;
    }*/


}
