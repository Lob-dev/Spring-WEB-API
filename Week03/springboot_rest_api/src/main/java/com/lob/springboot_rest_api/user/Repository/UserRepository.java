package com.lob.springboot_rest_api.user.Repository;

import com.lob.springboot_rest_api.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
}
