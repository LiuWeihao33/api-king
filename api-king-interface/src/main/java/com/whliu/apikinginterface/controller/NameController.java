package com.whliu.apikinginterface.controller;

import com.whliu.apikingclientsdk.model.User;
import com.whliu.apikingclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name){
        return "GET 你的名字是：" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name){
        return "POST 你的名字是：" + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request){
//        String accessKey = request.getHeader("accessKey");
//        String nonce = request.getHeader("nonce");
//        String timestamp = request.getHeader("timestamp");
//        String signature = request.getHeader("signature");
//        String body = request.getHeader("body");
//        if (!accessKey.equals("whliu")){
//            throw new RuntimeException("无权限");
//        }
//        // 校验随机数大小
//        if (Integer.parseInt(nonce) > 10000) {
//            throw new RuntimeException("无权限");
//        }
//
//        // todo 实际情况中是从数据库中获取secretKey
//        String serverSign = SignUtils.genSign(body, "abcdefg");
//        if (!serverSign.equals(signature)){
//            throw new RuntimeException("无权限");
//        }
        String result = "POST 用户的名字是：" + user.getUsername();
        return result;
    }
}
