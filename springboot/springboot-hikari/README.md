# springboot

#### 介绍
springboot-hikari

HiKariCP是数据库连接池的一个后起之秀，号称性能最好，可以完美地PK掉其他连接池，是一个高性能的JDBC连接池，基于BoneCP做了不少的改进和优化。

spring boot 2 默认数据库连接池选择了HikariCP。


HikariCP为什么这么受欢迎，甚至傍上大腿springboot成为默认数据库连接池
    1、代码量非常小:
        要知道对于连接池来讲,代码越少,占用cpu和内存越少,Bug出现几率也是越小,那么代表他的执行率高,这就是为什么HikariCP受欢迎的原因之一
    2、稳定性,可靠性强:
        HikariCP是经受了市场的考验,走过太上老君的丹炉,现如今拿到SpringBoot的入场证,走上了人生巅峰.
    3、速度奇快:
        光有健壮性可不行,坦克很健壮,却跑不过飞机,但是HikariCP却依靠自己的代码少,重写数据结构等特点,成功晋级速度最快连接池冠军宝座.
		
 
HikariCP快得益于
    1、 优化并精简字节码
    2、 使用FastList替代ArrayList
    3、 ConcurrentBag：更好的并发集合类实现