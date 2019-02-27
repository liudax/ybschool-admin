package com.lss.school.util;

import com.lss.school.entity.UserInfo;
import com.lss.school.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author Magic
 * @date 16:40 2018/4/2
 * @description
 */
@Service
public class UserInfoContext {


    @Autowired
    private UserInfoMapper mapper;

    @Cacheable(value="userCache",key = "#key")
    public UserInfo getUserInfo(String key){


//        mapper.findUserByUserNameAndPassword(key,"1");
        return new UserInfo();
    }

}
