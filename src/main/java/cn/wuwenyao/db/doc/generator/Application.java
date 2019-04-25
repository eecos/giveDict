package cn.wuwenyao.db.doc.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import cn.wuwenyao.db.doc.generator.config.ApplicationConfig;

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
