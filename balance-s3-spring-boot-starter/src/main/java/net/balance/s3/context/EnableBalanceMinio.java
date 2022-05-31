package net.balance.s3.context;

import net.balance.s3.autoconfigure.BalanceMinioAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开启Minio服务
 *
 * @author : liushuku
 * @date : 31 : 05 : 2022/5/31
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(BalanceMinioAutoConfiguration.class)
public @interface EnableBalanceMinio {
}
