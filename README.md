# cherry-tomato-server
小番茄服务。

## 使用的工具

* [ASCLL转换](http://tool.oschina.net/encode?type=3)

  参数验证用到的国际化，中文转码

## spring boot 整合 security

* [基于springboot的security机制](https://segmentfault.com/a/1190000013057238)

* [spring security开启注解](https://blog.csdn.net/l18767118724/article/details/72934564)

* [spring security前后端分离](https://www.jianshu.com/p/650a497b3a40)

* [spring security获取当前上下文](https://blog.csdn.net/cloume/article/details/84983006)

## 遇到问题

### dubbo开启参数验证遇到问题

 * `Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'defaultValidator' defined in class path resource [org/springframework/boot/autoconfigure/validation/ValidationAutoConfiguration.class]: Invocation of init method failed; nested exception is java.lang.AbstractMethodError: org.hibernate.validator.engine.ConfigurationImpl.getDefaultParameterNameProvider()Ljavax/validation/ParameterNameProvider` 
 
 > 原因：Hibernate validator 4.3.0.Final版本校验框架是JSR-303，而Hibernate validator 5.1.0.Final版本校验框架是JSR-349，spring-context-5.0.X.RELEASE.jar框架采用新的校验框架JSR-349。
 
 解决： 将hibernate-validator 版本改为5.1.0.Final
 
```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>5.1.0.Final</version>
</dependency>
```

  * `Caused by: javax.validation.ValidationException: HV000183: Unable to load 'javax.el.ExpressionFactory'. Check that you have the EL dependencies on the classpath`
  
  > 原因：使用hibernate bean validator ,但是beanvalidator是依赖于与javax validator和javax.el的。说的更加直白一点就是依赖于servlet容器，如果dubbo是交给tomcat或者jetty服务器去管理的，那么OK，没有这个问题，但是我们现在不是，所以我们需要提供错误所提示的jar。

  解决：添加对应的jar
  
```xml
<dependency>
   <groupId>javax.el</groupId>
   <artifactId>javax.el-api</artifactId>
   <version>2.2.4</version>
</dependency>
<dependency>
   <groupId>org.glassfish.web</groupId>
   <artifactId>javax.el</artifactId>
   <version>2.2.4</version>
</dependency>
```
 
 
