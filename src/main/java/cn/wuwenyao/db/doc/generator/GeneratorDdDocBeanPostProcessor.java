package cn.wuwenyao.db.doc.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import cn.wuwenyao.db.doc.generator.service.GeneratorService;

/***
 * spring上下文初始化完成后-执行生成文档操作
 * 
 * @author wwy
 *
 */
@Component
public class GeneratorDdDocBeanPostProcessor implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private GeneratorService generatorService;
	
	private static final Logger LOG = LoggerFactory.getLogger(GeneratorDdDocBeanPostProcessor.class);
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		// 生成doc
		try {
			generatorService.generateDbDoc();
		} catch (Exception e) {
			LOG.error("生成数据库文档错误", e);
			return;
		}
		LOG.info("生成数据库文档成功");
	}
}