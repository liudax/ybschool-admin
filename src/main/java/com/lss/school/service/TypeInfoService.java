package com.lss.school.service;

import com.lss.school.entity.TypeInfo;
import com.lss.school.util.CommonResponse;

import java.util.List;

/**
 * @author Magic
 * @date 13:21 2018/4/1
 * @description
 */
public interface TypeInfoService {

    /**
     * 新增或者修改
     * @return
     */
    CommonResponse save(TypeInfo typeInfo);

    /**
     * 删除，支持批量删除
     * @param codeIds
     * @return
     */
    CommonResponse delete(List<String> codeIds);

    /**
     * 根据大类名称或者code查询
     * @param search
     * @return
     */
    CommonResponse query(String search,int page,int limit);


}
