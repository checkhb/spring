# springboot-ehcache

#### 介绍

springboot-ehcache  使用ehcache作为数据缓存

    使用ehcache作为缓存框架

    项目当中使用了mybatis-plus操作数据库进行单标的增删改查(因为快速)
	
	配置了在控制台打印sql语句来验证缓存是否生效(看sql是否多次打印)
	
	使用hikari作为数据库连接池
	

### ehcache介绍

     Ehcache是一种广泛使用的开源Java分布式缓存。主要面向通用缓存,Java EE和轻量级容器。
	 它具有内存和磁盘存储，缓存加载器,缓存扩展,缓存异常处理程序,一个gzip缓存servlet过滤器,支持REST和SOAP api等特点。
	 
	 主要的特性有：
     1. 快速
     2. 简单
     3. 多种缓存策略
     4. 缓存数据有两级：内存和磁盘，因此无需担心容量问题
     5. 缓存数据会在虚拟机重启的过程中写入磁盘
     6. 可以通过RMI、可插入API等方式进行分布式缓存
     7. 具有缓存和缓存管理器的侦听接口
     8. 支持多缓存管理器实例，以及一个实例的多个缓存区域
     9. 提供Hibernate的缓存实现
	
### ehcache使用步骤

第一步：引入下面的maven依赖

     <!--开启 cache 缓存-->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-cache</artifactId>
      </dependency>
      <!-- ehcache 缓存 -->
      <dependency>
          <groupId>net.sf.ehcache</groupId>
          <artifactId>ehcache</artifactId>
      </dependency>

第二步：编写ehcache.xml

第三步：在配置文件当中作如下配置
   
     # 指定ehcahce 配置文件路径 不能写成：classpath:cache/ehcache.xml
     spring.cache.ehcache.config=cache/ehcache.xml

第四步：编写对应的CacheManagerConfig类文件

第五步：使用下面介绍的注解进行相关的无侵入配置


	 
	 
### 几大注解

主要使用如下五个注解

     @Cacheable:标注该方法或者类是支持缓存的
	 
	     @Cacheable可以标记在一个方法上，也可以标记在一个类上。
		 
		     当标记在一个方法上时表示该方法是支持缓存的，当标记在一个类上时则表示该类所有的方法都是支持缓存的。
             如果一个方法上添加了@Cacheable标记，Spring会在其被调用后将其返回值缓存起来，
		     以保证下次利用同样的参数来执行该方法时可以直接从缓存中获取结果，而不需要再次执行该方法。

	     @Cacheable可以指定三个属性，value、key和condition
		     
			 value：cacheNames，可以指定多个，用逗号隔开
			 key：缓存的key，支持SpringEL表达式，#id或者#student.id
			 condition:判定条件，符合条件的才会假如缓存
			 例如：@Cacheable(value={"users"}, key="#user.id", condition="#user.id%2==0")
		  
     @CacheEvict:注解用来清除缓存
	 
	    有以下五个属性：value，key，condition，allentries，beforeInvocation 
		value，key，condition：同上
		allentries：默认为false，假如设置为true，就删除value下面的所有的缓存
		beforeInvocation：默认为fasle，是在方法执行之前还是之后删除缓存。假如设置为true，那么就算方法执行出错，也会执行删除缓存。
	 
     @CachePut:每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中
	 
	     @CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，
		 而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
	 
     @CacheConfig:类级别的注解
	 
	     这是一个类级别的注解，比如一个类里所有的缓存都是放在cachename为mycache的缓存中，那么每个@Cacheable中都要写value=”mycache”。
		 现在可以直接在类上面加上这个注解@CacheConfig(value="mycache")，那么下面的每个方法就都相当于在mycache缓存下面
	 
     @Caching:组合多个Cache注解使用
	 
	     在一个方法上面假如同时需要执行多个操作可以用这个进行注解组合。
		 比如下面的一个例子：保存一个用户，之后可能查询的时候会根据id，username，email查询出对应的用户数据。
		 那么就需要把这三个属性分别对应缓存数据保存起来。
	     @Caching(put = {
                @CachePut(value = "user", key = "#user.id"),
                @CachePut(value = "user", key = "#user.username"),
                @CachePut(value = "user", key = "#user.email")
               })

	
	









