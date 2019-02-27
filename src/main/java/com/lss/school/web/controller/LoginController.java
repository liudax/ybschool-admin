package com.lss.school.web.controller;

import com.lss.school.annotation.NoAuthentication;
import com.lss.school.entity.UserInfo;
import com.lss.school.mapper.UserInfoMapper;
import com.lss.school.util.CommonResponse;
import com.lss.school.util.DESUtil;
import com.lss.school.util.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Magic
 * @date 14:20 2018/3/30
 * @description
 */
@Api(tags = {"登录相关接口"})
@Slf4j
@NoAuthentication
@RestController
public class LoginController {


    private final static String URL = "https://api.weixin.qq.com/sns/jscode2session";
    private final static String APPID="wxfdd25808a133fc16";
    private final static String SECRET="b8da6f7116c4a39bdfdee6fe756a9cda";

    @Autowired
    private UserInfoMapper mapper;



    @ApiOperation(value="web后台登录接口",notes = "使用登录名和密码登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="loginName",value="登录名"),
            @ApiImplicitParam(name="password",value="密码")
    })
    @PostMapping("/admin-login")
    public CommonResponse loginAdmin(HttpServletRequest request,String loginName, String password){
        UserInfo userInfo = mapper.findUserByLoginNameAndPassword(loginName, DESUtil.encryptBasedDes(password));
        if(userInfo!=null){
            request.getSession().setAttribute("user",userInfo);
        }else{
            throw new RuntimeException("密码错误");
        }
        return new SimpleResponse(userInfo);
    }

//    @ApiOperation(value="小程序用户注册接口",notes = "需要用户姓名和电话号码，还有openId")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="userName",value="用户姓名"),
//            @ApiImplicitParam(name="phone",value="电话"),
//            @ApiImplicitParam(name="openId",value="微信openId"),
//            @ApiImplicitParam(name="licenseType",value="驾照类型：1-手动，2-自动")
//    })
//    @PostMapping("/app-register")
//    public CommonResponse loginApp(String openId,String userName,String phone,String licenseType){
//
//
//        return SimpleResponse.SUCCESS;
//    }
//
//    @PostMapping("/getOpenId")
//    public CommonResponse getOpenId(String code) throws IOException {
//        String params = "appid="+APPID+"&secret="+SECRET+"&js_code="+code+"&grant_type=authorization_code";
//        String result = HttpHelper.get(URL,params);
//        if(StringUtils.isEmpty(result)){
//            throw new RuntimeException("获取微信信息失败");
//        }
//        ObjectMapper objectMapper = new ObjectMapper();
//        Map map = objectMapper.readValue(result,Map.class);
//
//        //if(map.get("open_id"))
//        log.info(result);
//        return new SimpleResponse(result);
//    }

}
