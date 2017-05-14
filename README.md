基于dubbo 框架工程结构

1 data-super
	说明：data-super是mavne工程一个聚合项目
	聚合：通过pom文件配置，在该工程的pom文件添加modules标签实现模块聚合管理
2 assembly
	说明：assembly目录存储mavne构建插件配置信息
3 bin
	说明：bin目录提供linux环境下运行脚本目录，该目录的脚本为通用脚本，脚本使用java jar方式启动运行，不依赖web容器启动，所以需要provider提供main方法。
	
4 conf
	说明：conf目录提供聚合模块中dubbo服务提供方配置
5 生成po 与mapper 
	执行命令： mvn mybatis-generator:generate
6 运行服务端 http://note.youdao.com/yws/public/redirect/share?id=b32353002cec79a3c62684b09a5b7fe2&type=false

7 其他介绍
schema.sql 为表结构
urls.txt 测试地址，可以通过http_load 工具完成测试