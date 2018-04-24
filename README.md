# Java高并发秒杀API Spring Boot 版本
## 访问地址
- 首页 ： http://localhost:8080/seckill/list
- druid监控地址：http://localhost:8080/druid/weburi.html

# 使用说明
1. 首先从github上把项目传到本地，可以直接下载项目的压缩包，点击Clone or download,然后Download Zip。也可以通过git，使用git clone  https://github.com/colg-cloud/seckill 命令，把项目克隆到本地
2. 然后修改数据库连接信息，在resources目录下jdbc.properties配置文件中修改
3. 使用maven tomcat7插件启动项目， 进入项目目录，打开cmd输入：`mvn tomcat7:run`