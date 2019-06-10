package cn.mrjerryli.db.doc.generator;

import cn.mrjerryli.db.doc.generator.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/***
 * 应用启动
 * 
 * @author wwy
 *
 */
@EnableConfigurationProperties({ ApplicationConfig.class })
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
