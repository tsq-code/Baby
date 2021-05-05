基于spring boot和vue的前后端分离新生儿管理系统


后端框架结构

com.baby     

├── common            // 工具类

│       └── annotation                    // 自定义注解

│       └── config                        // 全局配置

│       └── constant                      // 通用常量

│       └── core                          // 核心控制

│       └── enums                         // 通用枚举


│       └── exception                     // 通用异常

│       └── filter                        // 过滤器处理

│       └── utils                         // 通用类处理

├── framework         // 框架核心

│       └── aspectj                       // 注解实现

│       └── config                        // 系统配置

│       └── datasource                    // 数据权限

│       └── interceptor                   // 拦截器

│       └── manager                       // 异步处理

│       └── security                      // 权限控制

│       └── web                           // 前端控制

├── baby-generator   // 代码生成（可移除）

├── baby-quartz      // 定时任务（可移除）

├── baby-system      // 系统代码

├── baby-admin       // 后台服务

├── baby-xxxxxx      // 其他模块

前端框架结构

├── build                      // 构建相关  

├── bin                        // 执行脚本

├── public                     // 公共文件

│   ├── favicon.ico            // favicon图标

│   └── index.html             // html模板

│   └── robots.txt             // 反爬虫

├── src                        // 源代码

│   ├── api                    // 所有请求

│   ├── assets                 // 主题 字体等静态资源

│   ├── components             // 全局公用组件

│   ├── directive              // 全局指令

│   ├── layout                 // 布局

│   ├── router                 // 路由

│   ├── store                  // 全局 store管理

│   ├── utils                  // 全局公用方法

│   ├── views                  // view

│   ├── App.vue                // 入口页面

│   ├── main.js                // 入口 加载组件 初始化等

│   ├── permission.js          // 权限管理

│   └── settings.js            // 系统配置

├── .editorconfig              // 编码格式

├── .env.development           // 开发环境配置

├── .env.production            // 生产环境配置

├── .env.staging               // 测试环境配置

├── .eslintignore              // 忽略语法检查

├── .eslintrc.js               // eslint 配置项

├── .gitignore                 // git 忽略项

├── babel.config.js            // babel.config.js

├── package.json               // package.json

└── vue.config.js              // vue.config.js
