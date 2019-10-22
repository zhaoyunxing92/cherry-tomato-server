# mybatis

## 参考文档

* [SpringBoot之整合Mybatis](https://www.jianshu.com/p/c44dc639cb93)

## yml配置

```yaml
mybatis:
  mapper-locations: classpath:io/github/sunny/cherry/tomato/account/mapper/xml/*.xml
  type-aliases-package: io.github.sunny.cherry.tomato.account.model
  type-handlers-package: io.github.sunny.cherry.tomato.dubbo.mysql.handler
```