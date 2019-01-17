package com.fontend.fontendlearn.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lulu
 * @since 2019.01.17
 * 用于测试ajax
 */
@RestController
@RequestMapping("xmlHttpRequestAttr")
public class XmlHttpRequestAttr {

    @RequestMapping(value = "xmlHttpRequestAttr",method = RequestMethod.POST)
    public String xmlHttpRequestAttr(@RequestParam(required = false) String param){
        JSONObject jsonObject = JSON.parseObject(param);
        return jsonObject.getString("name");
    }

    @RequestMapping(value = "xmlHttpRequestGet",method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    public String xmlHttpRequestGet(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        return name + "??";
    }
}
