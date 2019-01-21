package com.fontend.fontendlearn.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author lulu
 * @since 2019.01.21
 * 使用http流的形式多次向前端发送数据
 */
@RestController
@RequestMapping("httpFlowService")
public class HttpFlowService {

    @RequestMapping(value = "responseAndRequest",method = RequestMethod.POST ,produces = { "application/json;charset=UTF-8" })
    public String responseAndRequest(HttpServletRequest request,HttpServletResponse response){
        boolean inLoop = true;
        PrintWriter out = null;
        String name = null;
        while(inLoop){
            String param = request.getParameter("param");
            if(param != null){
                JSONObject paramObject = JSON.parseObject(param);
                 name = paramObject.getString("name");
            }

            String end = request.getParameter("endObject");

            if(end != null){
                if(out != null){
                    out.close();
                }
                return "结束请求";
            }
            try {
                out = response.getWriter();
                out.write(name + Math.random());
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "结束请求";
    }

}
