package com.lss.school.service;

import com.lss.school.entity.UserInfo;
import com.lss.school.util.CommonResponse;

import java.util.List;

/**
 * @author Magic
 * @date 12:19 2018/4/4
 * @description
 */
public interface UserInfoService {




    /**
     * 根据用户名和密码查找用户
     * @param loginName
     * @param password
     * @return
     */
    UserInfo getUserByLoginNameAndPassword(String loginName,String password);

    /**
     * 新增用户信息
     * @param userInfo
     * @return
     */
    CommonResponse save(UserInfo userInfo);


    /**
     * 修改用户账户是否启用
     * @param userId
     * @param isEnabled
     * @return
     */
    CommonResponse updateState(List<String> userId,String isEnabled);

    /**
     * 修改学员或者教练的当前阶段
     * @param ids
     * @param stage
     * @return
     */
    CommonResponse updateStage(List<String> ids , String stage);

    CommonResponse query(UserInfo userInfo,int page,int limit);

    CommonResponse delete(List<String> ids);
}
