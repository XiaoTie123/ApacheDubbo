package cn.swiftPass.point.engine;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.apache.dubbo.container.Main;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "cn.swiftPass.point.engine.service")
@EnableCaching
@EnableScheduling
@EnableAsync
public class PointEngineApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PointEngineApplication.class, args);
		Main.main(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PointEngineApplication.class);
	}
}

