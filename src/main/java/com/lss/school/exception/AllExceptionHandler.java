package com.lss.school.exception;

import com.lss.school.util.CommonResponse;
import com.lss.school.util.SimpleResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Magic
 * @date 15:08 2018/4/1
 * @description
 */
@ControllerAdvice

public class AllExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResponse allException(Exception ex){
        ex.printStackTrace();
        return new SimpleResponse(1,ex.getMessage(),null);
    }

    @ExceptionHandler(value = NotLoggedInException.class)
    @ResponseBody
    public void noLogged(Exception ex, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println("<script>alert('你的登陆过期');window.top.location.href = '/login.html';</script>");
    }
}
