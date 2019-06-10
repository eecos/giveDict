package cn.mrjerryli.db.doc.generator.enums;

import cn.mrjerryli.db.doc.generator.dao.impl.MysqlDbInfoDao;

/***
 * 数据库类型
 * 
 * @author wwy shiqiyue.github.com
 *
 */
public enum DbType {
	/** mysql */
	MYSQL(MysqlDbInfoDao.class);
	
	private Class dbInfoDaoImpl;
	
	private DbType(Class dbInfoDaoImpl) {
		this.dbInfoDaoImpl = dbInfoDaoImpl;
	}
	
	public Class getDbInfoDaoImpl() {
		return dbInfoDaoImpl;
	}
	
}
