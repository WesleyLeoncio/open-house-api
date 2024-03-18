package wl.open_house_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OpenHouseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenHouseApiApplication.class, args);
	}

}
