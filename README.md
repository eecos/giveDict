## 数据库文档生成工具
#####  ***简单配置，就能够生成数据库文档。欢迎大家提意见***

---
使用方法  
----
    1.修改application.properties的数据库配置信息  
    2.修改application.properties中的属性 application.generator中的信息
    3.运行Application.java  
    4.生成文件的格式类似2018-03-07_05-45-453.xls

使用的框架  
----
    1.spring boot  
    2.spring jdbc  
    3.freemaker  

支持的数据库 
----
    1.mysql  

支持生成的文档类型
----
	1.word，不太好看，但是可以修改文档,v.15移除，不再支持
	2.excel，还算好看吧，可以修改文档
	3.html，最好看了，ヾ(◍°∇°◍)ﾉﾞ，但是不能修改

如何扩展已支持更多数据库
----
    1.在pom.xml加入数据库驱动包
    2.修改application.properties的数据库配置信息
    3.创建一个新的类，继承cn.mrjerryli.db.doc.generator.dao.impl.AbstractDbInfoDao
    4.在枚举类cn.mrjerryli.db.doc.generator.enums.DbType增加一个新的枚举

如何扩展已支持更多的生成文档类型
----
	1.创建一个新的类，继承cn.mrjerryli.db.doc.generator.service.impl.AbstractGeneratorServiceImpl
	2.在枚举类cn.mrjerryli.db.doc.generator.enums.TargetFileType中增加一个新的枚举
