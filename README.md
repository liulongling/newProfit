# 项目结构

```
.
├── LICENSE
├── conf                                            # 配置目录
│   ├── dev.properties                              # backend服务外部配置文件(开发服)
│   └── test.properties                             # backend服务外部配置文件(测试服)
├── doc                                             # 文档目录
├── backend                                         # 后端项目主目录
│   ├── backend.iml
│   ├── pom.xml                                     # 后端 maven 项目使用的 pom 文件
│   └── src                                         # 后端代码目录
└── pom.xml                                         # 整体 maven 项目使用的 pom 文件
```

# 配置开发环境

### 后端

后端使用了 Java 语言的 Spring Boot 框架，并使用 Maven 作为项目管理工具。开发者需要先在开发环境中安装 JDK 1.8 及 Maven。

#### 初始化配置

数据库初始化，数据库系统使用的

```
# 数据库配置
spring.datasource.url=jdbc:mariadb://localhost:3306/profit?autoReconnect=false&useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false
spring.datasource.username=root
spring.datasource.password=123456
```

配置backend服务启动参数：

```
--spring.config.location=D:/work/profit/conf/dev.properties 
```

backend服务启动时会加载dev.properties配置信息，自动在配置的库中创建所需的表结构及初始化数据。示例：

```
spring.application.name=profit
server.port=8080

# 数据库配置
spring.datasource.url=jdbc:mariadb://localhost:3306/profit?autoReconnect=false&useUnicode=true&characterEncoding=UTF-8&characterSetResults=UTF-8&zeroDateTimeBehavior=convertToNull&useSSL=false
spring.datasource.username=root
spring.datasource.password=123456

#日志存放路径
logging.file.path=E:/logs/${spring.application.name}
```

注意：dev.properties最新内容进入工程profit/conf/目录下查看！