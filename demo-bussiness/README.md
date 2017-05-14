基于dubbo 框架工程结构

说明： 接口实现，与数据交互 

1 依赖 xxx-provider.jar 
2 生成po 与mapper 
	执行命令： mvn mybatis-generator:generate
	说明： 在生成数据库映射与查询mapper 需要 /demo-manage/src/main/resources/generator/generatorConfig.xml
	