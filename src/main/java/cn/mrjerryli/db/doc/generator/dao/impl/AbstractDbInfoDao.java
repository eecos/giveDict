package cn.mrjerryli.db.doc.generator.dao.impl;

import cn.mrjerryli.db.doc.generator.config.ApplicationConfig;
import cn.mrjerryli.db.doc.generator.entity.TableInfo;
import cn.mrjerryli.db.doc.generator.dao.DbInfoDao;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/***
 * 获取数据库信息的dao实现-抽象基类
 *
 * @author wwy shiqiyue.github.com
 *
 */
public abstract class AbstractDbInfoDao implements DbInfoDao {

    protected JdbcTemplate jdbcTemplate;

    protected ApplicationConfig applicationConfig;

    @Override
    public String databaseName() {
        return null;
    }

    @Override
    public List<TableInfo> tableInfoList() {
        return null;
    }

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void setApplicationConfig(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    /***
     * 判断表是否可以生成
     * @param tableName
     * @return
     */
    public boolean isTableGenerate(String tableName) {
        List<String> blackList = applicationConfig.getGenerator().getBlacklist();
        List<String> whiteList = applicationConfig.getGenerator().getWhitelist();
        if (CollectionUtils.isNotEmpty(whiteList)) {
            for (String whiteItem : whiteList) {
                if (tableName.matches(whiteItem)) {
                    return true;
                }
            }
        }
        if (CollectionUtils.isEmpty(blackList)) {
            return true;
        }
        for (String blackItem : blackList) {
            if (tableName.matches(blackItem)) {
                return false;
            }
        }
        return true;

    }
}
