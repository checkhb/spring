# springboot

#### 介绍
springboot-swagger

springboot当中，整合了swagger实现接口暴露

项目启动之后访问地址：http://${server.ip}:${server.port}/swagger-ui.html



#### Swagger介绍和使用

什么是swagger

    Swagger是一个规范和完整的框架，用于生成、描述、调用和可视化RESTful风格的 Web 服务。
	总体目标是使客户端和文件系统作为服务器以同样的速度来更新。
	文件的方法，参数和模型紧密集成到服务器端的代码，允许API来始终保持同步。
	Swagger让部署管理和使用功能强大的API变得非常简单。官方网站：http://swagger.io/。

Swagger采用OpenAPI规范，OpenAPI规范这类API定义语言能够帮助你更简单、快速的表述API，尤其是在API的设计阶段作用特别突出。

    一旦编写完成，API文档可以作为：

    需求和系统特性描述的根据
    前后台查询、讨论、自测的基础
    部分或者全部代码自动生成的根据
    其他重要的作用，比如开放平台开发者的手册

#### 如何编写API文档

   定义YAML文件，然后可以生成各种语言的代码框架，对于后台程序员来说，较少人会愿意写出一堆YAML格式。
   定义JSON格式文件，按照swagger文档书写规范编写文档，和YAML一样只是两种不同格式。
   通过swagger的各种语言的插件，可以通过配置及少量代码，生成接口文档及测试界面。
   通过yaml或json书写的是静态文档，需要书写文档中需要的内容，详细写法可参考：https://www.gitbook.com/book/huangwenchao/swagger/details，完成后可以通过可视化页面显示接口文档。
   但要完成整个项目的接口文档书写也非常耗时，如果是后台开发，可以通过简单配置实现文档的自动生成。
