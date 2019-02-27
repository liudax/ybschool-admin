package com.lss.school;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Magic
 */
@EnableSwagger2
@SpringBootApplication
@MapperScan("com.lss.school.mapper")
@EnableCaching
//public class YbschoolApiApplication extends SpringBootServletInitializer {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(YbschoolApiApplication.class);
//	}
//
//
//	public static void main(String[] args) {
//		SpringApplication.run(YbschoolApiApplication.class, args);
//	}
//}

//jar运行
public class YbschoolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(YbschoolApiApplication.class, args);
	}
}
