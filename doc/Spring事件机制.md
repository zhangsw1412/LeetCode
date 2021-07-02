# Spring中内置的事件

- `ContextStartedEvent`：容器启动的时候触发(start方法)
- `ContextRefreshedEvent`：容器刷新的时候触发(onRefresh，在finisRefresh中调用)
- `ContextStoppedEvent`：容器停止的时候触发(stop方法)
- `ContextClosedEvent`：容器关闭的时候触发(close方法)

# 自定义事件

Spring中自定义事件只需要继承`ApplicationEvent`即可完成一个自定义的Spring事件

```java
/**
 * 自定义事件，继承ApplicationEvent
 */
@Data
public class FirstEvent extends ApplicationEvent {
    /**
     * 需要携带的消息，可以是任意类型的数据，相当于传递数据
     */
    private String message;

    /**
     * 构造方法
     * @param source 事件发生的类
     * @param message 携带的消息
     */
    public FirstEvent(Object source,String message) {
        super(source);
        this.message=message;
    }
}
```

# 监听器

- 监听器用来监听事件触发，一旦事件触发了，监听器会执行相应的操作。

- 监听器的实现有两种方式：

- - 实现`ApplicationListener`接口
  - 使用`@EventListener`注解
  - 实现`SmartApplicationListener`接口

## 实现ApplicationListener接口

- 创建监听器需要两个条件：

- - 实现ApplicationListener接口
  - 将该自定义的监听器注入到ioc容器中

```java
/**
 * 自定义一个监听器，实现ApplicationListener，指定的泛型就是需要监听的事件
 * 监听ContextRefreshedEvent，当容器完成刷新的时候该监听器就会监听到并执行onApplicationEvent方法
 */
@Component
public class FirstListener implements ApplicationListener<ContextRefreshedEvent> {
    /**
     * 重载方法，被监听的事件触发了就会调用这个方法
     * @param event 触发事件的对象
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("容器刷新的监听器启动了........");
        System.out.println(event.getSource()+"---->"+event.getTimestamp()+"----"+event.getApplicationContext());
        System.out.println(".........................................");
    }
}
```

此时只要启动容器，自定义的监听器就会起作用，当然我们监听的是Spring内置的事件，在容器启动的时候Spring会使用事件发布器发布事件，此时才是真正的触发事件，我们自定义的事件并不能被监听，除非被事件发布器发布。

## 使用@EventListener注解

- 常见的属性：

- - `classes`：Class数组，指定需要监听的事件
  - `condition`：指定条件，默认监听

```java
/**
 * 注解方式实现事件监听器
 */
@Component
public class CustomEventListener {
    /**
     * 使用@EventListener监听事件
     * @param event 传入的事件源
     */
    @EventListener(classes = {ApplicationEvent.class})
    public void handlerContextRefreshEvent(ApplicationEvent event){
        if (event instanceof ContextRefreshedEvent) {
            ContextRefreshedEvent e=(ContextRefreshedEvent)event;
            System.out.println("ContextRefreshedEvent启动了........");
            System.out.println(event.getSource() + "---->" + event.getTimestamp() + "----" + e.getApplicationContext());
            System.out.println(".........................................");
        }else if(event instanceof ContextStartedEvent){
            ContextStartedEvent e=(ContextStartedEvent)event;
            System.out.println("ContextStartedEvent启动了........");
            System.out.println(event.getSource() + "---->" + event.getTimestamp() + "----" + e.getApplicationContext());
            System.out.println(".........................................");
        }else if(event instanceof ContextStoppedEvent){
            ContextStoppedEvent e=(ContextStoppedEvent)event;
            System.out.println("ContextStoppedEvent启动了........");
            System.out.println(event.getSource() + "---->" + event.getTimestamp() + "----" + e.getApplicationContext());
            System.out.println(".........................................");
        }else if(event instanceof ContextClosedEvent){
            ContextClosedEvent e=(ContextClosedEvent)event;
            System.out.println("ContextClosedEvent启动了........");
            System.out.println(event.getSource() + "---->" + event.getTimestamp() + "----" + e.getApplicationContext());
            System.out.println(".........................................");
        }
    }


    /**
     * 可以不指定classes，默认监听的是方法参数中的事件
     * @param event 事件源
     */
    @EventListener
    public void handleFirstEvent(FirstEvent event){
        System.out.println("firstEvent事件启动了。。。。。。。。。");
        System.out.println(event.getSource()+"---->"+event.getMessage());
    }
}
```

## 实现SmartApplicationListener接口

SmartApplicationListener接口继承了ApplicationListener 和 Ordered接口，实现了事件监听和排序的功能。

SmartApplicationListener提供了两个方法：

```java
public interface SmartApplicationListener extends ApplicationListener<ApplicationEvent>, Ordered {

	/**
	 * Determine whether this listener actually supports the given event type.
	 */
	boolean supportsEventType(Class<? extends ApplicationEvent> eventType);

	/**
	 * Determine whether this listener actually supports the given source type.
	 */
	boolean supportsSourceType(Class<?> sourceType);

}
```

# 事件发布

Spring中发布事件的接口是`ApplicationEventPublisher`，我们可以自定义自己的类，当然也可以使用spring现成的类

## Spring的事件发布类

- ApplicationContext
- AnnotationConfigApplicationContext

## 直接注入

在容器启动刷新的时候已经注入了`ApplicationEventPublisher`的实现，我们可以直接注入使用。如下：

```java
/**
 * 自定义的事件发布器
 */
@Component
public class CustomPublisher  {
    /**
     * 直接注入ApplicationEventPublisher
     */
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 发布事件
     * @param event 指定的事件
     */
    public void publishEvent(ApplicationEvent event){
        applicationEventPublisher.publishEvent(event);
    }
}
```

测试

```java
@Test
public void test1(){
    CustomPublisher customPublisher = applicationContext.getBean(CustomPublisher.class);
    customPublisher.publishEvent(new FirstEvent(this,"启动自定义事件"));
}
```

## 使用ApplicationEventPublisherAware注入

```java
/**
 * 自定义的事件发布器，实现ApplicationEventPublisherAware接口
 */
@Component
public class CustomPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * 发布事件
     * @param event 指定的事件
     */
    public void publishEvent(ApplicationEvent event){
        applicationEventPublisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher=applicationEventPublisher;
    }
}
```

# 异步事件

前面创建的事件和监听器都是同步进行，我们可以使用异步事件

## 使用@Async实现异步

Spring中可以使用`@Async`注解标注方法异步执行，不过需要在配置类上开启异步功能，使用`@EnableAsync`注解，如下：

```java
@Configuration
@ComponentScan(value = {"cn.tedu.demo"})
@EnableAsync
public class FirstConfig {
    
}
```

此时可以在监听方法上标注`@Async`注解，使得事件异步执行

```java
/**
 * 注解方式实现事件监听器
 */
@Component
public class CustomEventListener {
    /**
     * 可以不指定classes，默认监听的是方法参数中的事件
     * @Async : 指定这个方法异步执行
     * @param event 事件源
     */
    @EventListener
    @Async
    public void handleFirstEvent(FirstEvent event){
        System.out.println("firstEvent事件启动了，。。。。。。。。。");
        System.out.println(event.getSource()+"---->"+event.getMessage());
    }
}
```

# 自定义事件多播器

从源码我们可以知道，spring容器加载的时候先获取的是ioc容器中的，如果不存在，那么才会新建一个`SimpleApplicationEventMulticaster`，我们可以自己注入一个多播器直接使用即可。

源码如下：

```java
protected void initApplicationEventMulticaster() {
		ConfigurableListableBeanFactory beanFactory = getBeanFactory();
		//判断ioc容器中是否存在id为applicationEventMulticaster事件多播器
		if (beanFactory.containsLocalBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME)) {
			//直接使用ioc容器中的
			this.applicationEventMulticaster = beanFactory.getBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME,
			                                                       ApplicationEventMulticaster.class);
			if (logger.isTraceEnabled()) {
				logger.trace("Using ApplicationEventMulticaster [" + this.applicationEventMulticaster + "]");
			}
		} else {
			//新建一个，不过没有设置TaskExector
			this.applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
			beanFactory.registerSingleton(APPLICATION_EVENT_MULTICASTER_BEAN_NAME, this.applicationEventMulticaster);
			if (logger.isTraceEnabled()) {
				logger.trace("No '"
				             + APPLICATION_EVENT_MULTICASTER_BEAN_NAME
				             + "' bean, using "
				             + "["
				             + this.applicationEventMulticaster.getClass().getSimpleName()
				             + "]");
			}
		}
	}
```

从源码中【`org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(org.springframework.context.ApplicationEvent, org.springframework.core.ResolvableType)`】我们可以看出监听器的执行是先判断多播器中是否存在`Executor`,如果存在，那么就单独开启一个线程执行，否则就同步执行，我们在初始化多播器的时候，可以为其设置一个`Executor`，那么就可以异步执行了。

```java
@Override
public void multicastEvent(final ApplicationEvent event, @Nullable ResolvableType eventType) {
		ResolvableType type = (eventType != null ? eventType : resolveDefaultEventType(event));
		for (final ApplicationListener<?> listener : getApplicationListeners(event, type)) {
			Executor executor = getTaskExecutor();
			if (executor != null) {
				executor.execute(() -> invokeListener(listener, event));
			} else {
				invokeListener(listener, event);
			}
		}
}
```

实现：在配置类注入一个多播器即可，bean的id一定要是`applicationEventMulticaster`，同时为其设置一个`executor`

```java
@Bean(name = "applicationEventMulticaster")
public ApplicationEventMulticaster applicationEventMulticaster() {
		//事件多播器
		SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
		//设置executor
		SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor();
		simpleApplicationEventMulticaster.setTaskExecutor(executor);
		return simpleApplicationEventMulticaster;
}
```

# 参考文献

[https://zhuanlan.zhihu.com/p/101128672](https://zhuanlan.zhihu.com/p/101128672)

[https://zhuanlan.zhihu.com/p/71230214](https://zhuanlan.zhihu.com/p/71230214)