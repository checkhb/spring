# springboot

#### 介绍

springboot-dubbo

使用springboot整合dubbo实现调用远程服务

本项目当中springboot的版本为：2.1.5.RELEASE

1、由于dubbo需要zookeeper的支持，所以需要先安装zookeeper，并在配置文件当中配置对应的zookeeper的地址

2、dubbo使用protocol作为通信协议，所以api的类需要实现Serializable接口

3、dubbo需要构建一个公共的api，方便远程调用别人写的接口

4、高版本的springboot和低版本的springboot配置文件写法不一样








