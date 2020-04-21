package com.cardlan.spring.service;

import com.cardlan.spring.dao.HelloDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HelloService {

//    @Qualifier("helloDao2")
//    @Autowired(required = false)

    @Resource(name = "helloDao")
    private HelloDao helloDao;

    public void print(){
        System.out.println(helloDao);
    }
}
