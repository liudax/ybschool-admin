package com.lss.school.mapper;

import com.lss.school.entity.TypeInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TypeInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(TypeInfo record);

    int insertSelective(TypeInfo record);

    TypeInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TypeInfo record);

    int updateByPrimaryKey(TypeInfo record);

    List<TypeInfo> selectByConditions(@Param("key") String key);

    int deleteById(List<String> ids);
}