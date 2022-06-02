package net.balance1;

import net.balance.common.system.error.base.AssertBalanceException;
import net.balance.common.system.error.base.BalanceException;
import net.balance.common.system.model.BalanceCode;
import net.balance.s3.properties.MinioProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@SpringBootApplication
public class TestApplication {

	@Resource
	private MinioProperties minioProperties;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@GetMapping("test")
	public String test() {
		try {
			AssertBalanceException.balanceException(true, BalanceCode.CodeInternalError);
		} catch (BalanceException e) {
			System.out.println(e.isNotEmpty());
			System.out.println(e.errorDetail().code());
		}
		return minioProperties.toString();
	}

}
