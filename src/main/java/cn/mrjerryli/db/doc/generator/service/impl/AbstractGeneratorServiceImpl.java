package cn.mrjerryli.db.doc.generator.service.impl;

import cn.mrjerryli.db.doc.generator.config.GeneratorConfig;
import cn.mrjerryli.db.doc.generator.dao.DbInfoDao;
import cn.mrjerryli.db.doc.generator.service.GeneratorService;

/***
 * 文档生成服务-抽象基类
 *
 * @author wwy shiqiyue.github.com
 *
 */
public abstract class AbstractGeneratorServiceImpl implements GeneratorService {

    protected DbInfoDao dbInfoDao;

    protected GeneratorConfig generatorConfig;

    @Override
    public void generateDbDoc() throws Exception {
    }

    @Override
    public void setDbInfoDao(DbInfoDao dbInfoDao) {
        this.dbInfoDao = dbInfoDao;
    }

    @Override
    public void setGeneratorConfig(GeneratorConfig generatorConfig) {
        this.generatorConfig = generatorConfig;
    }


}
