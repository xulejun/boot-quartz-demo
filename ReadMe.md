jar包依赖
- 
- quartz
- spring-context-support（schedule）
- spring-tx（事务）

编写
- 
- 自定义Job类，实现Job接口
- 配置Quartz
    - 创建Job对象（做什么工作）
    - 创建简单的Trigger对象 / Cron Trigger对象（什么时候工作）
    - 创建Schedule对象（搭配工作和触发器）
- 调用service报错
    -原因：JobDetailFactoryBean调用AdaptableJobFactory类中的createJobInstance方法，
    未将自定义的Job类注入到IOC容器中
    - 解决：创建类，继承AdaptableJobFactory，重写createJobInstance方法，将获取到的对象利用AutowireCapableBeanFactory的autowireBean方法进行注入

启动
- 
启动类中增加@EnableScheduling注解进行启动