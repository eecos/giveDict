package cn.mrjerryli.db.doc.generator.enums;

import cn.mrjerryli.db.doc.generator.service.impl.ExcelGeneratorServiceImpl;
import cn.mrjerryli.db.doc.generator.service.impl.HtmlGeneratorServiceImpl;
import cn.mrjerryli.db.doc.generator.service.impl.WordGeneratorServiceImpl;

/***
 * 生成文件类型
 * 
 * @author wwy shiqiyue.github.com
 *
 */
public enum TargetFileType {
	
	/** word文档 */
	WORD(WordGeneratorServiceImpl.class),
	/** excel文档 */
	EXCEL(ExcelGeneratorServiceImpl.class),
	/** html文档 */
	HTML(HtmlGeneratorServiceImpl.class)

	;
	
	private Class generatorServiceImpl;
	
	private TargetFileType(Class generatorServiceImpl) {
		this.generatorServiceImpl = generatorServiceImpl;
	}
	
	public Class getGeneratorServiceImpl() {
		return generatorServiceImpl;
	}
	
}
