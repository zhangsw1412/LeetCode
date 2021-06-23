# 什么是MDC

MDC 全称是 Mapped Diagnostic Context，可以粗略的理解成是一个线程安全的存放诊断日志的容器。

# 用法

a）MDC 提供的 put 方法，可以将一个 K-V 的键值对放到容器中，并且能保证同一个线程内，Key 是唯一的，不同的线程 MDC 的值互不影响；

b)  在 logback.xml 中，在 layout 中可以通过声明 %X{REQ_ID} 来输出 MDC 中 REQ_ID 的信息；

c）MDC 提供的 remove 方法，可以清除 MDC 中指定 key 对应的键值对信息。

# 源码相关

解读源码之前，要提提 SLF4J，全称是 Simple Logging Facade for Java，翻译过来就是「一套简单的日志门面」。是为了让研发人员在项目中切换日志组件的方便，特意抽象出的一层。

**项目开发中经常这么定义日志对象：**

```java
Logger logger = LoggerFactory.getLogger(SimpleMDC.class)
```

其中 Logger 就来自于 SLF4J 的规范包，项目中一旦这样定义 Logger，在底层就可以无缝切换 logback、log4j 等日志组件啦，这或许就是 Java 为什么要提倡要面向接口编程的好处。

首先通过 org.slf4j.MDC 的源码，可以很清楚的知道 MDC 主要是通过 MDCAdapter 来完成 put、get、remove 等操作。

MDCAdapter 也是个接口。在 Java 的世界里，应该都知道定义接口的目的：就是为了定义规范，让子类去实现。

MDCAdapter 就和 JDBC 的规范类似，专门用于定义操作规范。JDBC 是为了定义数据库操作规范，让数据库厂商（MySQL、DB2、Oracle 等）去实现；而 MDCAdapter 则是让具体的日志组件（logback、log4j等）去实现。

MDCAdapter 接口的实现类，有 NOPMDCAdapter、BasicMDCAdapter、LogbackMDCAdapter 以及 Log4jMDCAdapter 等等几种，其中 log4j 使用的是 Log4jMDCAdapter，而 Logback 使用的是 LogbackMDCAdapter。

# 参考文献

[https://www.cnblogs.com/socoool/p/12742503.html](https://www.cnblogs.com/socoool/p/12742503.html)