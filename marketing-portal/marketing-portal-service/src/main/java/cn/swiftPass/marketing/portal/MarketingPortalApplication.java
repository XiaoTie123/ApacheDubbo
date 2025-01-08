package cn.swiftPass.marketing.portal;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {
		"cn.swiftPass.marketing.portal",
		"cn.swiftPass.marketing.portal.dto"
})
@EnableDubbo(scanBasePackages = "cn.swiftPass.marketing.portal.service")
@EnableCaching
@EnableScheduling
@EnableAsync
public class MarketingPortalApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MarketingPortalApplication.class, args);
		Main.main(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MarketingPortalApplication.class);
	}
}

