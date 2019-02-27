package com.lss.school.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lss.school.entity.UserInfo;
import com.lss.school.mapper.CommonDao;
import com.lss.school.mapper.UserInfoMapper;
import com.lss.school.service.UserInfoService;
import com.lss.school.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Magic
 * @date 12:20 2018/4/4
 * @description
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper mapper;

    @Autowired
    private CommonDao dao;

    @Override
    public UserInfo getUserByLoginNameAndPassword(String loginName, String password) {
        return mapper.findUserByLoginNameAndPassword(loginName,password);
    }

    @Override
    public CommonResponse save(UserInfo userInfo) {
        if(StringUtils.isEmpty(userInfo.getId())){
            userInfo.setId(IDUtil.createId());
            userInfo.setSchoolId(UserHelper.getSchoolId());
            mapper.insertSelective(userInfo);
        }else{
            mapper.updateByPrimaryKeySelective(userInfo);
        }
        return SimpleResponse.SUCCESS;
    }

    @Transactional
    @Override
    public CommonResponse updateState(List<String> ids, String state) {
        mapper.updateState(ids,state);
        if("101".equals(state)){// 启用时，默认为科目二
            mapper.updateStage(ids,"102");
        }
        return SimpleResponse.SUCCESS;
    }

    @Override
    public CommonResponse updateStage(List<String> ids , String stage) {
        mapper.updateStage(ids,stage);
        return SimpleResponse.SUCCESS;
    }

    @Override
    public CommonResponse query(UserInfo userInfo,int page,int limit) {
        userInfo.setSchoolId(UserHelper.getSchoolId());
        Page p = PageHelper.startPage(page,limit);
        List<Map> userInfos =  mapper.findByFields(userInfo);
        return new TableResponse(p.getTotal(),userInfos);
    }

    @Override
    public CommonResponse delete(List<String> ids) {
        mapper.deleteByIds(ids);
        return SimpleResponse.SUCCESS;
    }
}
