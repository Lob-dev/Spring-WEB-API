package com.devfun.dao;
 
import java.util.List;

import org.springframework.stereotype.Repository;

import com.devfun.vo.MovieVO;
 
@Repository
public interface MovieDAO {
    
    public List<MovieVO> selectMovie() throws Exception;
}