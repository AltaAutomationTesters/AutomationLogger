package alta.automation.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.controllers.service.entity.CurrentTimeBeans;

@SpringBootApplication
public class AutomationLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomationLoggerApplication.class, args);
		
		CurrentTimeBeans.getInstance().run();
		
	}
}
