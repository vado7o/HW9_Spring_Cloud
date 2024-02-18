package pudov.vadim.hw9_products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HW9_products {

	public static void main(String[] args) {
		SpringApplication.run(HW9_products.class, args);
	}

}
