package cn.colg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * Spring Boot 启动类
 *
 * @author colg
 */
@SpringBootApplication
@MapperScan("cn.colg.dao")
public class SeckillBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeckillBootApplication.class, args);
	}
}
