package com.A506.oa.web;

import com.A506.oa.mapper.registerMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 凉风
 * @create 2022-05-03 19:11
 */
@RestController
public class UserController {
    @Resource
    registerMapper reMa;
    @GetMapping("/register")
    public boolean register(int id,String username,String password){
        if(reMa.findById(id)==null){
            return reMa.insertData(id,username,password);
        }
        return false;
    }
}
