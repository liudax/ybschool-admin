package com.lss.school.mapper;

import com.lss.school.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<Map> findByFields(UserInfo info);

    UserInfo findUserByLoginNameAndPassword(@Param("loginName") String loginName,@Param("password") String password);

    int updateState(@Param("ids") List<String> ids, @Param("state") String state);

    int updateStage(@Param("ids")List<String> ids, @Param("stage")String stage);

    int deleteByIds(@Param("ids")List<String> ids);
}