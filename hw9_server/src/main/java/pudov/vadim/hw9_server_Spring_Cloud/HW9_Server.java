package pudov.vadim.hw9_server_Spring_Cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HW9_Server {

	public static void main(String[] args) {
		SpringApplication.run(HW9_Server.class, args);
	}

}
