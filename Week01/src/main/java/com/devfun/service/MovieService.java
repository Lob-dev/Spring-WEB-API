package com.devfun.service;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.devfun.vo.MovieVO;
 
@Service
public interface MovieService {
    
    public List<MovieVO> selectMovie() throws Exception;
}