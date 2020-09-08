package com.lob.springboot_rest_api.user.Repository;

import com.lob.springboot_rest_api.user.domain.User;


import java.util.Optional;

public interface UserRepository {
    //유저 정보 저장
    User save(User user);
    
    //유저 회원 가입 시 중복 체크
    //Optional을 통하여서 Null 예외 발생 시 오류를 서비스로 넘겨줌
    Optional<User> findByName(String name);





}
