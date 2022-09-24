package net.balance1;

import net.balance.common.system.error.Either;
import net.balance.common.system.error.base.BalanceExceptionUtil;
import net.balance.common.system.model.BalanceCode;
import net.balance.minio.autoconfigure.BalanceMinioAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liushuku
 */
@RestController
@SpringBootApplication(exclude = BalanceMinioAutoConfiguration.class)
public class TestApplication {

//	@Resource
//	private GeTuiAuth geTuiAuth;
//
//	@Resource
//	private GeTuiProperties geTuiProperties;


	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@GetMapping("test")
	public void test() {
		final Either either = Either.warpBalanceSupplier(() -> {
			BalanceExceptionUtil.newBalanceException("wwww", BalanceCode.CodeInternalError);
			return null;
		});

		System.out.println(either.getException());
		// return geTuiAuth.getToken();
	}

}
