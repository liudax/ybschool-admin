package com.lss.school.web.controller;

import com.lss.school.annotation.NoAuthentication;
import com.lss.school.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Magic
 * @date 20:26 2018/3/26
 * @description
 */
@Slf4j
@NoAuthentication
@RestController
public class TestController {

//    @Autowired
//    private UserInfoMapper mapper;
//
//    @Autowired
//    private TypeInfoMapper typeInfoMapper;


    @GetMapping("/save")
    public String save(){

        log.info("/save");
        UserInfo info = new UserInfo();
        info.setId("111");
        info.setUserName("张三");
        //mapper.save(info);
        return "success";
    }

    @GetMapping("/demo/table/user/")
    public Map tableTest(int limit,int page,String studentName,Integer type){


        log.info(limit+","+page);
        log.info(studentName+","+type);
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i=0;i<50;i++){
            Map mp = new HashMap();
            mp.put("id","1");
            mp.put("username","张三");
            mp.put("sex","男");
            mp.put("city","重庆");
            mp.put("sign","做自信的人");
            mp.put("experience","23232");
            mp.put("score","80");
            mp.put("classify","工程师");
            mp.put("wealth","良好");

            list.add(mp);
        }
        Map out = new HashMap<>();
        out.put("data",list);
        out.put("count",50);
        out.put("code",0);
        out.put("mss","加载成功");
        return out;

    }

//    @GetMapping("/saveTest")
//    public String mapperTest(){

//        int c = 0;
//        for(int i =0;i<50;i++){
//            UserInfo info = new UserInfo();
//            info.setId(IDUtil.createId());
//            info.setUserName("张三"+i);
//            int count = mapper.insert(info);
//            c +=count;
//        }
//        return String.valueOf(c);

//    }
//
//    @GetMapping("/pageTest")
//    public Map pageTest(int page, int limit){
//


//        Page p = PageHelper.startPage(page,limit);
//        List<UserInfo> userInfos = mapper.findAll();
//        Map out = new HashMap<>();
//        out.put("data",userInfos);
//        out.put("count",p.getTotal());
//        out.put("code",0);
//        out.put("mss","加载成功");
//        return out;
//
//    }
//
//    @PostMapping("/type")
//    public MyResponse addType(TypeInfo typeInfo){
//        typeInfo.setId(IDUtil.createId());
//       int c = typeInfoMapper.insert(typeInfo);
//       return new MyResponse(0,"成功");
//    }



}
