package com.lss.school.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Magic
 * @date 13:36 2018/4/8
 * @description
 */
public interface CommonDao {
    List<Map<String,Object>> findByNativeSql(String querySql);

   int updateByNativeSql(String updateSql);

   int deleteByNativeSql(String deleteSql);
}
