package com.lss.school.web.controller.admin;

import com.lss.school.entity.UserInfo;
import com.lss.school.service.UserInfoService;
import com.lss.school.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author Magic
 * @date 17:12 2018/4/4
 * @description
 */
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService service;

    @PostMapping("/admin/user")
    public CommonResponse save(UserInfo userInfo){
        return service.save(userInfo);
    }
    @PutMapping(value = "/admin/user",produces = "application/json;charset=utf-8")
    public CommonResponse updateState(String ids,String state){
        return service.updateState(  Arrays.asList(ids.split(",")),state);
    }

    @GetMapping("/admin/user")
    public CommonResponse query(UserInfo userInfo,int page,int limit){
         return service.query(userInfo,page,limit);
    }

    @DeleteMapping("/admin/user/{id}")
    public CommonResponse delete(@PathVariable("id")String id){
        return service.delete(Arrays.asList(new String[]{id}));
    }


    @GetMapping("/")
    public void index(HttpServletResponse response) throws Exception{
        response.sendRedirect("/index.html");
    }




}
