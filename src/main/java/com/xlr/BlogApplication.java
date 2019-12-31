package com.xlr;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 青铜骑士
 * @ClassName: BlogApplication
 * @ProjectName springboot-es
 * @Description: TODO
 * @date 2019/12/2920:35
 */
@SpringBootApplication
@Slf4j
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class);
        log.info("项目启动成功，访问地址：http://localhost:8081/");
    }
}
