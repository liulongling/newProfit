# 项目结构

```
.
├── LICENSE
├── backend                                         # 后端web层
│   ├── application.yml                             # backend服务外部配置文件
│   └── logback.xml                                 # 日志配置文件
├── doc                                             # 文档目录76
├── common                                          # 通用模块
├── framework                                       # 后端底仓框架
├── generator                                       # 数据库表结构代码生成
├── quartz                                          # 定时任务
└── pom.xml                                         # 整体 maven 项目使用的 pom 文件
```

# 配置开发环境

### 后端

后端使用了 Java 语言的 Spring Boot 框架，前端用的Ruoyi框架 并使用 Maven 作为项目管理工具。开发者需要先在开发环境中安装 JDK 17 及 Maven。

#### 编码风格与辅助
遵循[阿里巴巴Java开发手册规约在线文档](https://kangroo.gitee.io/ajcg/#/)
