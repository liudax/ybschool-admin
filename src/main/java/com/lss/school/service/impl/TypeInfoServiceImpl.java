package com.lss.school.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lss.school.entity.TypeInfo;
import com.lss.school.mapper.TypeInfoMapper;
import com.lss.school.service.TypeInfoService;
import com.lss.school.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Magic
 * @date 13:32 2018/4/1
 * @description
 */
@Service
public class TypeInfoServiceImpl implements TypeInfoService {

    @Autowired
    private TypeInfoMapper mapper;

    @Override
    public CommonResponse save(TypeInfo typeInfo) {
        if(StringUtils.isEmpty(typeInfo.getId())){
            typeInfo.setId(IDUtil.createId());
           // typeInfo.setSchoolId(UserHelper.getSchoolId());
            mapper.insertSelective(typeInfo);
        }else{
            mapper.updateByPrimaryKeySelective(typeInfo);
        }
        return new SimpleResponse();
    }

    @Override
    public CommonResponse delete(List<String> codeIds) {
//        mapper.deleteByKeys(codeIds);
        return new SimpleResponse();
    }

    @Override
    public CommonResponse query(String search,int page,int limit) {

        Page page1 = PageHelper.startPage(page,limit);
       List list = mapper.selectByConditions(search);

        return new TableResponse(page1.getTotal(),list);
    }
}
