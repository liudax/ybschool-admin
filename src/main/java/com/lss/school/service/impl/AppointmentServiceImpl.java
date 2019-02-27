package com.lss.school.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lss.school.mapper.AppointmentInfoMapper;
import com.lss.school.service.AppointmentService;
import com.lss.school.util.CommonResponse;
import com.lss.school.util.SimpleResponse;
import com.lss.school.util.TableResponse;
import com.lss.school.util.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Magic
 * @date 21:00 2018/4/18
 * @description
 */
@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    private AppointmentInfoMapper mapper;


    @Override
    public CommonResponse query(int page, int limit,
                                String stage, String timeInterval,
                                String licenseType, Date appointmentDate,String key) {
        Page p = PageHelper.startPage(page,limit);
        List<Map> list =  mapper.findByConditions(stage,timeInterval,licenseType,appointmentDate,key,UserHelper.getSchoolId());
        return new TableResponse(p.getTotal(),list);
    }

    @Override
    public CommonResponse delete(List<String> ids) {
        mapper.deleteByIds(ids);

        return SimpleResponse.SUCCESS;
    }
}
