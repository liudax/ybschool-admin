package com.lss.school.service;

import com.lss.school.util.CommonResponse;

import java.util.Date;
import java.util.List;

/**
 * @author Magic
 * @date 20:59 2018/4/18
 * @description
 */

public interface AppointmentService {

     CommonResponse query( int page,int limit,String stage, String timeInterval, String licenseType,Date appointmentDate,
                          String key);
     CommonResponse delete(List<String> ids);

}
