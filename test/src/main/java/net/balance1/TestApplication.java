package net.balance1;

import net.balance.s3.autoconfigure.BalanceMinioAutoConfiguration;
import net.balance.s3.operate.ObsOperate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author liushuku
 */
@RestController
@SpringBootApplication(exclude = BalanceMinioAutoConfiguration.class, scanBasePackages = "net.balance.s3")
public class TestApplication {

	@Resource
	private ObsOperate obsOperate;

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@GetMapping("test")
	public String test() {
		boolean testcqt = obsOperate.makeBucket("testcqt");
		System.out.println(testcqt);
		return "";
	}

}
