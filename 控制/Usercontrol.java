package com.a506.oa.web;

import com.a506.oa.common.user;

import com.a506.oa.mapper.loginmapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Usercontrol {
    public  static user user=new user();
    @Resource
    loginmapper loginmapper;

    @GetMapping("/login")
    public Object login(int id, String password){
        if (loginmapper.finduser(id)!=null){
            System.out.println("查找id成功");
            System.out.println(password);
            System.out.println(loginmapper.getpassword(id));
            if (password.equals(loginmapper.getpassword(id))){
                System.out.println("效验密码成功");
                user.setId(id);
                user.setUsername(loginmapper.getusername(id));
                user.setResult(true);
                return  user;
            }
        }

        return false;
    }
}
