package com.whliu.apikinggateway;

import com.whliu.project.provider.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
@EnableDubbo
@Service
public class ApiKingGatewayApplication {

    // 用这个注解就可以注册到api-king项目中的DomeService了
    @DubboReference
    private DemoService demoService;

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ApiKingGatewayApplication.class, args);
        ApiKingGatewayApplication application = context.getBean(ApiKingGatewayApplication.class);
        String result = application.doSayHello("world");
        String result2 = application.doSayHello2("world");
        System.out.println("result: " + result);
        System.out.println("result: " + result2);
    }

    public String doSayHello(String name) {
        // 这里会直接调用api-king项目中的实现类的方法
        return demoService.sayHello(name);
    }

    public String doSayHello2(String name) {
        return demoService.sayHello2(name);
    }

    //    @Bean
    //    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    //        return builder.routes()
    //                .route("tobaidu", r -> r.path("/baidu")
    //                        .uri("https://www.baidu.com"))
    //                .route("toyupiicu", r -> r.path("/yupiicu")
    //                        .uri("http://yupi.icu"))
    //                .build();
    //    }

}
