package com.lss.school.web.controller.admin;

import com.lss.school.entity.TypeInfo;
import com.lss.school.service.TypeInfoService;
import com.lss.school.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Magic
 * @date 13:17 2018/4/1
 * @description
 */
@RestController
@RequestMapping("/admin")
public class TypeInfoController {

    @Autowired
    private TypeInfoService service;

    @PostMapping("/typeInfo")
    public CommonResponse save(TypeInfo typeInfo){
        return service.save(typeInfo);
    }

    @GetMapping("/typeInfo")
    public CommonResponse query(String query,int page,int limit){
        return service.query(query,page,limit);
    }

    @DeleteMapping(value="/typeInfo/{id}")
    public CommonResponse delete(@PathVariable String id) throws IOException {
        return service.delete(Arrays.asList(new String[]{id}));
    }

}
