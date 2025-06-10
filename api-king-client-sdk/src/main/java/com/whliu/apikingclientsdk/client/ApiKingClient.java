package com.whliu.apikingclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.whliu.apikingclientsdk.model.User;
import com.whliu.apikingclientsdk.utils.SignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 调用第三方接口的客户端
 */
public class ApiKingClient {

    public static final String GATEWAY_HOST = "http://localhost:8090";

    private String accessKey;

    private String secretKey;

    public ApiKingClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    /**
     * GET 方法从服务器获取信息
     * @param name
     * @return
     */
    public String getNameByGet(String name){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/", map);
        System.out.println(result);
        return result;
    }

    /**
     * POST 方法从服务器获取信息
     * @param name
     * @return
     */
    public String getNameByPost(String name){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/", map);
        System.out.println(result);
        return result;
    }


    /**
     * 使用POST方法向服务器发送User对象，并获取服务器返回的结果
     * @param user
     * @return
     */
    /**
     * @RequestBody 是Spring MVC的服务端注解，用于接收HTTP请求
     * 你的SDK 是客户端工具，通过普通Java方法调用接收参数
     * 序列化过程 是你手动控制的，不依赖Spring的自动转换
     * 这种设计 让你的SDK可以在任何Java项目中使用，不仅仅是Spring Boot项目
     * @param user
     * @return
     */
    public String getUserNameByPost(User user){
        String jsonStr = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/")
                .addHeaders(this.getHeaderMap(jsonStr))
                .body(jsonStr)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> map = new HashMap<>();
        map.put("accessKey", this.accessKey);
        // 不能直接发送密钥
//        map.put("secretKey", this.secretKey);
        map.put("nonce", RandomUtil.randomNumbers(4));
        map.put("body", body);
        map.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        map.put("signature", SignUtils.genSign(body, this.secretKey));
        return map;
    }
}
