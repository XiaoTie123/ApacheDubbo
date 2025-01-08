package cn.swiftPass.cashBack.campaign;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "cn.swiftPass.cashBack.campaign.service")
@EnableCaching
@EnableScheduling
@EnableAsync
public class CashBackCampaignApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CashBackCampaignApplication.class, args);
		Main.main(args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CashBackCampaignApplication.class);
	}

}
