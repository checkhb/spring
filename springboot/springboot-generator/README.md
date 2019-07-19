# springboot

#### 介绍
springboot-generator

使用mybatis-plus生成对应的controller service impl mapper mapper.xml文件

并且继承基础的mybatis-plus的IService接口和BaseMapper接口实现单表的增删改查

使用很简单，你只需要修改一下配置文件的数据库访问地址、用户名和密码即可

然后运行项目，访问localhost:8086/index即可。

生成主页截图如下：

![输入图片说明](https://images.gitee.com/uploads/images/2019/0708/140351_8f010020_1311479.png "截图.png")

访问主页之后，填写项目路径、包父路径和包路径，选择要生成的表就可以生成对应的文件。

主键策略和是否创建覆盖暂时无效。
