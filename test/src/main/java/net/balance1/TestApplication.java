package net.balance1;

import net.balance.minio.properties.MinioProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liushuku
 */
@RestController
@SpringBootApplication(scanBasePackages = {"net.balance.minio"})
public class TestApplication {

//	@Resource
//	private GeTuiAuth geTuiAuth;
//
//	@Resource
//	private GeTuiProperties geTuiProperties;

	@Resource
	private MinioProperties minioProperties;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@GetMapping("test")
	public String test() {
		return minioProperties.getAccessKey();
		// return geTuiAuth.getToken();
	}

}
