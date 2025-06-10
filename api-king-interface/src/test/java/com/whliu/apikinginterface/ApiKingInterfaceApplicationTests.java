package com.whliu.apikinginterface;

import com.whliu.apikingclientsdk.client.ApiKingClient;
import com.whliu.apikingclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiKingInterfaceApplicationTests {

    @Resource
    private ApiKingClient apiKingClient;

    @Test
    void contextLoads() {
        String result = apiKingClient.getNameByGet("whliu");
        User user = new User();
        user.setUsername("whliu");
        String userNameByPost = apiKingClient.getUserNameByPost(user);
        System.out.println(result);
        System.out.println(userNameByPost);
    }

}
