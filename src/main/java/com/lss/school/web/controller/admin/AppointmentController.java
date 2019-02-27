package com.lss.school.web.controller.admin;

import com.lss.school.service.AppointmentService;
import com.lss.school.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Magic
 * @date 20:32 2018/4/18
 * @description
 */
@RestController
@RequestMapping("/admin")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping("/appointments")
    public CommonResponse query(int page, int limit,
                                String stage, String timeInterval,
                                String licenseType, String key, Date appointmentDate){

        return service.query(page,limit,stage,timeInterval,licenseType,appointmentDate,key);
    }
    @PutMapping(value = "/appointment",produces = "application/json;charset=utf-8")
    public CommonResponse delete( String ids){
        return service.delete(Arrays.asList(ids.split(",")));
    }

}
