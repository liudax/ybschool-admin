package com.lss.school.util;

/**
 * @author Magic
 * @date 16:51 2018/4/2
 * @description
 */
public class UserHelper {

    private static UserThreadLocal u = UserThreadLocal.getInstance();

    public static String getId() {
        return u.get().getId();
    }

    public static String getUserName() {
        return u.get().getUserName();
    }

    public static String getLoginName() {
        return u.get().getLoginName();
    }

    public static String getPassword() {
        return u.get().getPassword();
    }

    public static String getUserPhone() {
        return u.get().getUserPhone();
    }

    public static  String getWxOpenId() {
        return u.get().getWxOpenId();
    }

    public static String getSchoolId() {
        //return "10001";
        return u.get().getSchoolId();
    }

    public static String getStage() {
        return u.get().getStage();
    }

    public static String getIsEnabled() {
        return u.get().getIsEnabled();
    }

    public String getBackup1() {
        return u.get().getBackup1();
    }

    public String getBackup2() {
        return u.get().getBackup2();
    }
}
