# springboot-springsession

#### 介绍
springboot-springsession

springboot当中，整合了springsession和redis进行session的管理

在面试的时候可能会经常遇到一个问题就是：分布式Session如何实现？

    我们可以把session统一放在redis服务器里面进行管理。
	可以使用springsession和redis对session进行统一的管理。

### 为什么要spring-session	

    传统的Tomcat、Jetty等web容器当中，用户的session都是由容器进行统一的管理的。
    但是这样的架构面对现在的分布式的时候有点力不从心了。因为现在的用户请求可能被负载分发到不同的服务器上面了。

### spring-session

    spring-session的核心思想在于此：将session从web容器中剥离，存储在独立的存储服务器中。
	目前支持多种形式的session存储器：Redis、Database、MogonDB等。
	session的管理责任委托给spring-session承担。
	当request进入web容器，根据request获取session时，由spring-session负责存存储器中获取session，
	如果存在则返回，如果不存在则创建并持久化至存储器中。

