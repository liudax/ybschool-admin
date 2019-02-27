package com.lss.school.mapper;

import com.lss.school.entity.AppointmentInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AppointmentInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(AppointmentInfo record);

    int insertSelective(AppointmentInfo record);

    AppointmentInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppointmentInfo record);

    int updateByPrimaryKey(AppointmentInfo record);

    List<Map> findByConditions(@Param("stage") String stage, @Param("timeInterval") String timeInterval, @Param("licenseType")  String licenseType,
                               @Param("AppointmentDate") Date AppointmentDate, @Param("key") String key, @Param("schoolId") String schoolId);


    int deleteByIds(@Param("ids")List<String> ids);
}