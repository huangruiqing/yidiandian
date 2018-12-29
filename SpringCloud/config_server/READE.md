```
#spring.application.name=config-server
#server.port=8079

# git管理配置
#https://github.com/huangruiqing/yidiandian/tree/master/SpringCloud/config-files/consumer
#spring.cloud.config.server.git.uri=https://github.com/huangruiqing/yidiandian
#spring.cloud.config.server.git.searchPaths=SpringCloud/config-files/consumer,SpringCloud/config-files/product
#spring.cloud.config.server.git.username=${git.useranme}
#spring.cloud.config.server.git.password=${git.password}
#修改temp 文件地址
#spring.cloud.config.server.git.basedir=C:/My_Space/CVS_Config
#spring.cloud.config.server.svn.basedir
#测试 访问配文件 http://127.0.0.1:8080/consumere/dev/master  协议：//ip:port/应用/dev/分支
###########################本地
## 本地配置文件
#spring.profiles.active=native
#spring.cloud.config.server.native.searchLocations=file://C:/test
#file:C:/My_Space/YIDIANDIAN/yidiandian/SpringCloud/config-files/consumer
##,file://C:/My_Space/YIDIANDIAN/yidiandian/SpringCloud/config-files/product

#eureka.client.service-url.defaultZone=http://127.0.0.1:8761/eureka/
```