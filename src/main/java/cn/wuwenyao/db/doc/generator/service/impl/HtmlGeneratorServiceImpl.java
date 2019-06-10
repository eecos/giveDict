package cn.wuwenyao.db.doc.generator.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import cn.wuwenyao.db.doc.generator.entity.TableInfo;
import cn.wuwenyao.db.doc.generator.utils.FreemarkerUtils;
import freemarker.template.Template;

/***
 * 生成文档服务-html实现
 * 
 * @author wwy
 *
 */
public final class HtmlGeneratorServiceImpl extends AbstractGeneratorServiceImpl {
	
	/** 模板名称 */
	private String templateFileName = "htmlTemplate.html";
	
	@Override
	public void generateDbDoc() throws Exception {
		String databaseName = dbInfoDao.databaseName();
		List<TableInfo> tableInfos = dbInfoDao.tableInfoList();
		templateFileName = StringUtils.defaultIfBlank(generatorConfig.getTemplateFilePath(), templateFileName);
		// 获取模板
		Template template = FreemarkerUtils.getTemplate(templateFileName);
		File dir = new File(generatorConfig.getTargetFileDir());
		FileUtils.forceMkdir(dir);
		Random random = new Random();
		String filename = DateFormatUtils.format(new Date(), "yyyy-MM-dd_hh-mm-ss") + random.nextInt(10) + ".html";
		File file = new File(dir, filename);
		Map<String, Object> map = new HashMap<>(2);
		map.put("tableInfos", tableInfos);
		map.put("databaseName", databaseName);
		// 根据模板生成文件
		template.process(map, new FileWriter(file));
		// 弹出目标文件夹
		String targetFileDir = generatorConfig.getTargetFileDir();
		//Runtime.getRuntime().exec("explorer "+ generatorConfig.getTargetFileDir());
        Runtime.getRuntime().exec("open "+ generatorConfig.getTargetFileDir());

    }
	
}
