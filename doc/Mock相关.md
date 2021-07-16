# 为什么要用Mock

**一种解释**

1. 创建所需的DB数据可能需要很长时间，如：调用别的接口，模拟很多数据
2. 调用第三方API接口，测试很慢
3. 编写满足所有外部依赖的测试可能很复杂，复杂到不值得编写，Mock模拟内部或外部依赖可以帮助我们解决这些问题

**另一种解释**

1. 对象的结果不确定，如每获取当前时间，得到的结果都不一样，无法符合我们的预期
2. 实现这个接口的对象不存在
3. 对象速度缓慢

对于TDD还有一个更重要原因:通过模拟可以隔离当前方法使用的的所有依赖，让我们更加专注于单个单元，忽略其调用的代码的内部工作原理

**又一种解释**

1. Mock可以用来解除测试对象对外部服务的依赖（比如数据库，第三方接口等），使得测试用例可以独立运行。不管是传统的单体应用，还是现在流行的微服务，这点都特别重要，因为任何外部依赖的存在都会极大的限制测试用例的可迁移性和稳定性
2. Mock的第二个好处是替换外部服务调用，提升测试用例的运行速度。任何外部服务调用至少是跨进程级别的消耗，甚至是跨系统、跨网络的消耗，而Mock可以把消耗降低到进程内。比如原来一次秒级的网络请求，通过Mock可以降至毫秒级，整整3个数量级的差别
3. Mock的第三个好处是提升测试效率。这里说的测试效率有两层含义。第一层含义是单位时间运行的测试用例数，这是运行速度提升带来的直接好处。而第二层含义是一个测试人员单位时间创建的测试用例数

# Mock的使用方法

## 入门

Mockito 是一个模拟测试框架。主要功能是模拟类/对象的行为。

Mockito 一般用于控制调用外部的返回值，让我们只关心和测试自己的业务逻辑。

## 使用mock方法模拟类和接口

org.mockito.Mockito 的 mock 方法可以模拟类和接口

### mock类

```java
import org.junit.Assert;
import org.junit.Test;
import java.util.Random;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    @Test
    public void test() {
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt()).thenReturn(100);  // 指定调用 nextInt 方法时，永远返回 100

        Assert.assertEquals(100, mockRandom.nextInt());
        Assert.assertEquals(100, mockRandom.nextInt());
    }
}
```

注意，`mock 对象的方法的返回值默认都是返回类型的默认值`。例如，返回类型是 int，默认返回值是 0；返回类型是一个类，默认返回值是 null。

```java
import org.junit.Assert;
import org.junit.Test;
import java.util.Random;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    @Test
    public void test() {
        Random mockRandom = mock(Random.class);

        System.out.println( mockRandom.nextBoolean() );
        System.out.println( mockRandom.nextInt() );
        System.out.println( mockRandom.nextDouble() );
    }
}
```

运行test方法，输出：

```java
false
0
0.0
```

### mock接口

```java
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    @Test
    public void test() {
        List mockList = mock(List.class);

        Assert.assertEquals(0, mockList.size());
        Assert.assertEquals(null, mockList.get(0));

        mockList.add("a");  // 调用 mock 对象的写方法，是没有效果的

        Assert.assertEquals(0, mockList.size());      // 没有指定 size() 方法返回值，这里结果是默认值
        Assert.assertEquals(null, mockList.get(0));   // 没有指定 get(0) 返回值，这里结果是默认值

        when(mockList.get(0)).thenReturn("a");          // 指定 get(0)时返回 a

        Assert.assertEquals(0, mockList.size());        // 没有指定 size() 方法返回值，这里结果是默认值
        Assert.assertEquals("a", mockList.get(0));      // 因为上面指定了 get(0) 返回 a，所以这里会返回 a

        Assert.assertEquals(null, mockList.get(1));     // 没有指定 get(1) 返回值，这里结果是默认值
    }
}
```

## 使用@Mock注解 {#4}

@Mock 注解可以理解为对 mock 方法的一个替代。

使用该注解时，要使用`MockitoAnnotations.initMocks` 方法，让注解生效。

```java
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    @Mock
    private Random random;

    @Test
    public void test() {
        // 让注解生效
        MockitoAnnotations.initMocks(this);

        when(random.nextInt()).thenReturn(100);

        Assert.assertEquals(100, random.nextInt());
    }
}
```

`MockitoAnnotations.initMocks` 放在 junit 的 `@Before` 注解修饰的函数中更合适。

```java
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    @Mock
    private Random random;

    @Before
    public void before() {
        // 让注解生效
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        when(random.nextInt()).thenReturn(100);

        Assert.assertEquals(100, random.nextInt());
    }
}
```

MockitoAnnotations.initMocks 的一个替代方案是使用 MockitoJUnitRunner 。

```java
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoDemo {
    @Mock
    private Random random;

    @Test
    public void test() {
        when(random.nextInt()).thenReturn(100);
        Assert.assertEquals(100, random.nextInt());
    }
}
```

## 参数匹配

目前 mockito 有多种匹配函数，部分如下

| 函数名               | 匹配类型                                  |
| :------------------- | :---------------------------------------- |
| any()                | 所有对象类型                              |
| anyInt()             | 基本类型 int、非 null 的 Integer 类型     |
| anyChar()            | 基本类型 char、非 null 的 Character 类型  |
| anyShort()           | 基本类型 short、非 null 的 Short 类型     |
| anyBoolean()         | 基本类型 boolean、非 null 的 Boolean 类型 |
| anyDouble()          | 基本类型 double、非 null 的 Double 类型   |
| anyFloat()           | 基本类型 float、非 null 的 Float 类型     |
| anyLong()            | 基本类型 long、非 null 的 Long 类型       |
| anyByte()            | 基本类型 byte、非 null 的 Byte 类型       |
| anyString()          | String 类型(不能是 null)                  |
| anyList()            | `List<T>` 类型(不能是 null)               |
| anyMap()             | `Map<K, V>`类型(不能是 null)              |
| anyCollection()      | `Collection<T>`类型(不能是 null)          |
| anySet()             | `Set<T>`类型(不能是 null)                 |
| `any(Class<T> type)` | type类型的对象(不能是 null)               |
| isNull()             | null                                      |
| notNull()            | 非 null                                   |
| isNotNull()          | 非 null                                   |

## spy和@Spy注解

spy 和 mock不同，不同点是：

- spy 的参数是对象示例，mock 的参数是 class。
- 被 spy 的对象，调用其方法时默认会走真实方法。mock 对象不会。

下面是一个对比：

```java
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

class ExampleService {
    int add(int a, int b) {
        return a+b;
    }
}

public class MockitoDemo {
    // 测试 spy
    @Test
    public void test_spy() {
        ExampleService spyExampleService = spy(new ExampleService());

        // 默认会走真实方法
        Assert.assertEquals(3, spyExampleService.add(1, 2));

        // 打桩后，不会走了
        when(spyExampleService.add(1, 2)).thenReturn(10);
        Assert.assertEquals(10, spyExampleService.add(1, 2));

        // 但是参数不匹配的调用，依然走真实方法
        Assert.assertEquals(3, spyExampleService.add(2, 1));
    }

    // 测试 mock
    @Test
    public void test_mock() {
        ExampleService mockExampleService = mock(ExampleService.class);

        // 默认返回结果是返回类型int的默认值
        Assert.assertEquals(0, mockExampleService.add(1, 2));
    }
}
```

spy 对应注解 @Spy，和 @Mock 是一样用的。

```java
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.*;

class ExampleService {
    int add(int a, int b) {
        return a+b;
    }
}

public class MockitoDemo {
    @Spy
    private ExampleService spyExampleService;

    @Test
    public void test_spy() {
        MockitoAnnotations.initMocks(this);

        Assert.assertEquals(3, spyExampleService.add(1, 2));

        when(spyExampleService.add(1, 2)).thenReturn(10);
        Assert.assertEquals(10, spyExampleService.add(1, 2));
    }
}
```

对于`@Spy`，如果发现修饰的变量是 null，会自动调用类的无参构造函数来初始化。

所以下面两种写法是等价的：

```java
// 写法1
@Spy
private ExampleService spyExampleService;

// 写法2
@Spy
private ExampleService spyExampleService = new ExampleService();
```

如果没有无参构造函数，必须使用写法2。例子：

```java
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

class ExampleService {
    private int a;

    public ExampleService(int a) {
        this.a = a;
    }

    int add(int b) {
        return a+b;
    }
}

public class MockitoDemo {
    @Spy
    private ExampleService spyExampleService = new ExampleService(1);

    @Test
    public void test_spy() {
        MockitoAnnotations.initMocks(this);

        Assert.assertEquals(3, spyExampleService.add(2));
    }
}
```

## @InjectMocks注解注入mock对象

mockito 会将 `@Mock`、`@Spy` 修饰的对象自动注入到 `@InjectMocks` 修饰的对象中。

注入方式有多种，mockito 会按照下面的顺序尝试注入：

1. 构造函数注入
2. 设值函数注入（set函数）
3. 属性注入

准备两个业务类：

```java
package demo;

import java.util.Random;

public class HttpService {
    public int queryStatus() {
        // 发起网络请求，提取返回结果
        // 这里用随机数模拟结果
        return new Random().nextInt(2);
    }
}
```

```java
package demo;

public class ExampleService {
    private HttpService httpService;

    public String hello() {
        int status = httpService.queryStatus();
        if (status == 0) {
            return "你好";
        }
        else if (status == 1) {
            return "Hello";
        }
        else {
            return "未知状态";
        }
    }
}
```

编写测试类：

```java
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;


public class ExampleServiceTest {
    @Mock
    private HttpService httpService;

    @InjectMocks
    private ExampleService exampleService = new ExampleService(); // 会将 httpService 注入进去

    @Test
    public void test01() {
        MockitoAnnotations.initMocks(this);

        when(httpService.queryStatus()).thenReturn(0);

        Assert.assertEquals("你好", exampleService.hello());
    }
}
```

## 使用thenReturn设置方法的返回值 {#1}

thenReturn 用来指定特定函数和参数调用的返回值。

```java
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Random;

public class MockitoDemo {
    @Test
    public void test() {
        Random mockRandom = mock(Random.class);

        when(mockRandom.nextInt()).thenReturn(1);

        Assert.assertEquals(1, mockRandom.nextInt());
    }
}
```

thenReturn 中可以指定多个返回值。在调用时返回值依次出现。若调用次数超过返回值的数量，再次调用时返回最后一个返回值。

```java
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Random;

public class MockitoDemo {
    @Test
    public void test() {
        Random mockRandom = mock(Random.class);

        when(mockRandom.nextInt()).thenReturn(1, 2, 3);

        Assert.assertEquals(1, mockRandom.nextInt());
        Assert.assertEquals(2, mockRandom.nextInt());
        Assert.assertEquals(3, mockRandom.nextInt());
        Assert.assertEquals(3, mockRandom.nextInt());
        Assert.assertEquals(3, mockRandom.nextInt());
    }
}
```

## 使用thenThrow让方法抛出异常

thenThrow 用来让函数调用抛出异常。

```java
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Random;

public class MockitoDemo {
    @Test
    public void test() {
        Random mockRandom = mock(Random.class);

        when(mockRandom.nextInt()).thenThrow(new RuntimeException("异常"));

        try {
            mockRandom.nextInt();
            Assert.fail();  // 上面会抛出异常，所以不会走到这里
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof RuntimeException);
            Assert.assertEquals("异常", ex.getMessage());
        }
    }
}
```

thenThrow 中可以指定多个异常。在调用时异常依次出现。若调用次数超过异常的数量，再次调用时抛出最后一个异常。

```java
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.Random;

public class MockitoDemo {
    @Test
    public void test() {
        Random mockRandom = mock(Random.class);

        when(mockRandom.nextInt()).thenThrow(new RuntimeException("异常1"), new RuntimeException("异常2"));

        try {
            mockRandom.nextInt();
            Assert.fail();
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof RuntimeException);
            Assert.assertEquals("异常1", ex.getMessage());
        }

        try {
            mockRandom.nextInt();
            Assert.fail();
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof RuntimeException);
            Assert.assertEquals("异常2", ex.getMessage());
        }
    }
}
```

对应返回类型是 void 的函数，thenThrow 是无效的，要使用 [doThrow](#2)。

## 使用then、thenAnswer自定义方法处理逻辑 {#3}

then 和 thenAnswer 的效果是一样的。它们的参数是实现 Answer 接口的对象，在改对象中可以获取调用参数，自定义返回值。

```java
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class MockitoDemo {
    static class ExampleService {
        public int add(int a, int b) {
            return a+b;
        }
    }

    @Mock
    private ExampleService exampleService;

    @Test
    public void test() {
        MockitoAnnotations.initMocks(this);

        when(exampleService.add(anyInt(),anyInt())).thenAnswer(new Answer<Integer>() {
            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                // 获取参数
                Integer a = (Integer) args[0];
                Integer b = (Integer) args[1];

                // 根据第1个参数，返回不同的值
                if (a == 1) {
                    return 9;
                }
                if (a == 2) {
                    return 99;
                }
                if (a == 3) {
                    throw new RuntimeException("异常");
                }
                return 999;
            }
        });

        Assert.assertEquals(9, exampleService.add(1, 100));
        Assert.assertEquals(99, exampleService.add(2, 100));

        try {
            exampleService.add(3, 100);
            Assert.fail();
        } catch (RuntimeException ex) {
            Assert.assertEquals("异常", ex.getMessage());
        }
    }
}
```

## 使用doReturn设置方法的返回值

doReturn 的作用和 [thenReturn](#1) 相同，但使用方式不同：

```java
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    @Test
    public void test() {
        MockitoAnnotations.initMocks(this);

        Random random = mock(Random.class);
        doReturn(1).when(random).nextInt();

        Assert.assertEquals(1, random.nextInt());
    }
}
```

## 使用doThrow让方法抛出异常 {#2}

如果一个对象的方法的返回值是 void，那么不能用 when .. thenThrow 让该方法抛出异常

如果有返回值，下面这种写法是错误的：

```java
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class MockitoDemo {
    static class ExampleService {
        public void hello() {
            System.out.println("Hello");
        }
    }

    @Mock
    private ExampleService exampleService;

    @Test
    public void test() {
        MockitoAnnotations.initMocks(this);

        // 这句编译不通过，IDE 也会提示错误，原因很简单，when 的参数是非 void
        when(exampleService.hello()).thenThrow(new RuntimeException("异常"));
    }
}
```

用 doThrow 可以让返回void的函数抛出异常，换成下面的写法即可：

```java
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.doThrow;

public class MockitoDemo {
    static class ExampleService {
        public void hello() {
            System.out.println("Hello");
        }
    }

    @Mock
    private ExampleService exampleService;

    @Test
    public void test() {
        MockitoAnnotations.initMocks(this);

        // 这种写法可以达到效果
        doThrow(new RuntimeException("异常")).when(exampleService).hello();

        try {
            exampleService.hello();
            Assert.fail();
        } catch (RuntimeException ex) {
            Assert.assertEquals("异常", ex.getMessage());
        }
    }
}
```

也可以用 doThrow 让返回非void的函数抛出异常

```java
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.Random;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    @Test
    public void test() {
        MockitoAnnotations.initMocks(this);

        Random random = mock(Random.class);

        // 下面这句等同于 when(random.nextInt()).thenThrow(new RuntimeException("异常"));
        doThrow(new RuntimeException("异常")).when(random).nextInt();

        try {
            random.nextInt();
            Assert.fail();
        } catch (RuntimeException ex) {
            Assert.assertEquals("异常", ex.getMessage());
        }
    }
}
```

## 使用doAnswer自定义方法处理逻辑

doAnswer 的作用和 [thenAnswer](#3) 相同，但使用方式不同：

```java
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Random;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    @Test
    public void test() {
        MockitoAnnotations.initMocks(this);

        Random random = mock(Random.class);
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return 1;
            }
        }).when(random).nextInt();

        Assert.assertEquals(1, random.nextInt());
    }
}
```

## 使用doNothing让void函数什么都不做

doNothing 用于让 void 函数什么都不做。因为 mock 对象中，void 函数就是什么都不做，所以该方法更适合 spy 对象。

```java
import org.junit.Test;
import static org.mockito.Mockito.*;

public class MockitoDemo {
    static class ExampleService {
        public void hello() {
            System.out.println("Hello");
        }
    }

    @Test
    public void test() {
        ExampleService exampleService = spy(new ExampleService());
        exampleService.hello();  // 会输出 Hello

        // 让 hello 什么都不做
        doNothing().when(exampleService).hello();
        exampleService.hello(); // 什么都不输出
    }
}
```

## 使用MockitoJUnitRunner运行JUnit测试

见[@Mock注解](#4)章节。主要作用是让 @Mock、@Spy 等注解生效。

## 使用 MockitoAnnotations.initMocks 让 @Mock 等注解生效

见[@Mock注解](#4)章节。

## 使用 reset 重置对象

使用 reset 方法，可以重置之前自定义的返回值和异常。

reset mock对象示例

```java
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    static class ExampleService {
        public int add(int a, int b) {
            return a+b;
        }
    }

    @Test
    public void test() {
        ExampleService exampleService = mock(ExampleService.class);

        // mock 对象方法的默认返回值是返回类型的默认值
        Assert.assertEquals(0, exampleService.add(1, 2));

        // 设置让 add(1,2) 返回 100
        when(exampleService.add(1, 2)).thenReturn(100);
        Assert.assertEquals(100, exampleService.add(1, 2));

        // 重置 mock 对象，add(1,2) 返回 0
        reset(exampleService);
        Assert.assertEquals(0, exampleService.add(1, 2));
    }
}
```

reset spy对象示例

```java
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    static class ExampleService {
        public int add(int a, int b) {
            return a+b;
        }
    }

    @Test
    public void test() {
        ExampleService exampleService = spy(new ExampleService());

        // spy 对象方法调用会用真实方法，所以这里返回 3
        Assert.assertEquals(3, exampleService.add(1, 2));

        // 设置让 add(1,2) 返回 100
        when(exampleService.add(1, 2)).thenReturn(100);
        Assert.assertEquals(100, exampleService.add(1, 2));

        // 重置 spy 对象，add(1,2) 返回 3
        reset(exampleService);
        Assert.assertEquals(3, exampleService.add(1, 2));
    }
}
```

## 使用 thenCallRealMethod 调用 spy 对象的真实方法

thenCallRealMethod 可以用来重置 spy 对象的特定方法特定参数调用。

```java
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    static class ExampleService {
        public int add(int a, int b) {
            return a+b;
        }
    }

    @Test
    public void test() {
        ExampleService exampleService = spy(new ExampleService());

        // spy 对象方法调用会用真实方法，所以这里返回 3
        Assert.assertEquals(3, exampleService.add(1, 2));

        // 设置让 add(1,2) 返回 100
        when(exampleService.add(1, 2)).thenReturn(100);
        when(exampleService.add(2, 2)).thenReturn(100);
        Assert.assertEquals(100, exampleService.add(1, 2));
        Assert.assertEquals(100, exampleService.add(2, 2));

        // 重置 spy 对象，让 add(1,2) 调用真实方法，返回 3
        when(exampleService.add(1, 2)).thenCallRealMethod();
        Assert.assertEquals(3, exampleService.add(1, 2));

        // add(2, 2) 还是返回 100
        Assert.assertEquals(100, exampleService.add(2, 2));
    }
}
```

## 使用 verify 校验是否发生过某些操作

使用 verify 可以校验 mock 对象是否发生过某些操作

```java
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    static class ExampleService {
        public int add(int a, int b) {
            return a+b;
        }
    }

    @Test
    public void test() {
        ExampleService exampleService = mock(ExampleService.class);

        // 设置让 add(1,2) 返回 100
        when(exampleService.add(1, 2)).thenReturn(100);

        exampleService.add(1, 2);

        // 校验是否调用过 add(1, 2) -> 校验通过
        verify(exampleService).add(1, 2);

        // 校验是否调用过 add(2, 2) -> 校验不通过
        verify(exampleService).add(2, 2);
    }
}
```

verify 配合 time 方法，可以校验某些操作发生的次数

```java
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    static class ExampleService {
        public int add(int a, int b) {
            return a+b;
        }
    }

    @Test
    public void test() {
        ExampleService exampleService = mock(ExampleService.class);

        // 第1次调用
        exampleService.add(1, 2);

        // 校验是否调用过一次 add(1, 2) -> 校验通过
        verify(exampleService, times(1)).add(1, 2);

        // 第2次调用
        exampleService.add(1, 2);

        // 校验是否调用过两次 add(1, 2) -> 校验通过
        verify(exampleService, times(2)).add(1, 2);
    }
}
```

## 使用 mockingDetails 判断对象是否为 mock对象、spy 对象

Mockito 的 mockingDetails 方法会返回 MockingDetails 对象，它的 isMock 方法可以判断对象是否为 mock 对象，isSpy 方法可以判断对象是否为 spy 对象。

示例：

```java
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    static class ExampleService {
        public int add(int a, int b) {
            return a+b;
        }
    }

    @Test
    public void test() {
        ExampleService exampleService = mock(ExampleService.class);

        // 判断 exampleService 是否为 mock 对象
        System.out.println( mockingDetails(exampleService).isMock() );     // true

        // 判断 exampleService 是否为 spy 对象
        System.out.println( mockingDetails(exampleService).isSpy() );      // false
    }
}
```

## 链式调用

thenReturn、doReturn 等函数支持链式调用，用来指定函数特定调用次数时的行为。

```java
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    static class ExampleService {
        public int add(int a, int b) {
            return a+b;
        }
    }

    @Test
    public void test() {
        ExampleService exampleService = mock(ExampleService.class);

        // 让第1次调用返回 100，第2次调用返回 200
        when(exampleService.add(1, 2)).thenReturn(100).thenReturn(200);

        Assert.assertEquals(100, exampleService.add(1, 2));
        Assert.assertEquals(200, exampleService.add(1, 2));
        Assert.assertEquals(200, exampleService.add(1, 2));
    }
}
```

```java
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class MockitoDemo {
    static class ExampleService {
        public int add(int a, int b) {
            return a+b;
        }
    }

    @Test
    public void test() {
        ExampleService exampleService = mock(ExampleService.class);

        // 让第1次调用返回 100，第2次调用返回 200
        doReturn(100).doReturn(200).when(exampleService).add(1, 2);

        Assert.assertEquals(100, exampleService.add(1, 2));
        Assert.assertEquals(200, exampleService.add(1, 2));
        Assert.assertEquals(200, exampleService.add(1, 2));

    }
}
```



## 测试隔离

根据JUnit单测隔离 ，当 Mockito 和 JUnit 配合使用时，也会将非static变量或者非单例隔离开。

比如使用 @Mock 修饰的 mock 对象在不同的单测中会被隔离开。

示例：

```java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoDemo {
    static class ExampleService {
        public int add(int a, int b) {
            return a+b;
        }
    }

    @Mock
    private ExampleService exampleService;

    @Test
    public void test01() {
        System.out.println("---call test01---");

        System.out.println("打桩前: " + exampleService.add(1, 2));

        when(exampleService.add(1, 2)).thenReturn(100);

        System.out.println("打桩后: " + exampleService.add(1, 2));
    }

    @Test
    public void test02() {
        System.out.println("---call test02---");

        System.out.println("打桩前: " + exampleService.add(1, 2));

        when(exampleService.add(1, 2)).thenReturn(100);

        System.out.println("打桩后: " + exampleService.add(1, 2));
    }
}
```

将两个单测一起运行，运行结果是：

```java
---call test01---
打桩前: 0
打桩后: 100
---call test02---
打桩前: 0
打桩后: 100
```

## 使用 PowerMock 让 Mockito 支持静态方法

PowerMock 是一个增强库，用来增加 Mockito 、EasyMock 等测试库的功能。

### Mockito 默认是不支持静态方法

比如我们在 ExampleService 类中定义静态方法 add：

```java
public class ExampleService {
        public static int add(int a, int b) {
            return a+b;
        }
}
```

尝试给静态方法打桩，会报错：

```java
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoDemo {
    @Test
    public void test() {
        // 会报错
        when(ExampleService.add(1, 2)).thenReturn(100);
    }
}
```

### 可以用 Powermock 弥补 Mockito 缺失的静态方法 mock 功能

在 build.gradle 中配置以下依赖：

```json
dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
    testCompile group: 'org.mockito', name: 'mockito-core', version: '2.25.1'

    // PowerMock 相关依赖
    testCompile group: 'org.powermock', name: 'powermock-core', version: '2.0.0'
    testCompile group: 'org.powermock', name: 'powermock-module-junit4', version: '2.0.0'
    testCompile group: 'org.powermock', name: 'powermock-api-mockito2', version: '2.0.0'
}
```

示例：

```java
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)     // 这是必须的
@PrepareForTest(ExampleService.class)  // 声明要处理 ExampleService
public class MockitoDemo {
    @Test
    public void test() {
        PowerMockito.mockStatic(ExampleService.class);  // 这也是必须的

        when(ExampleService.add(1, 2)).thenReturn(100);

        Assert.assertEquals(100, ExampleService.add(1, 2));
        Assert.assertEquals(0, ExampleService.add(2, 2));
    }
}
```

### PowerMockRunner 支持 Mockito 的 @Mock 等注解

上面我们用了 PowerMockRunner ，MockitoJUnitRunner 就不能用了。但不要担心， @Mock 等注解还能用。

```java
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Random;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
public class MockitoDemo {
    @Mock
    private Random random;

    @Test
    public void test() {
        when(random.nextInt()).thenReturn(1);
        Assert.assertEquals(1,  random.nextInt());
    }
}
```

# 需要注意的踩坑点

## mock和spy的区别

mock方法和spy方法都可以对`对象`进行mock。但是前者是接管了对象的全部方法，而后者只是将有桩实现（stubbing）的调用进行mock，其余方法仍然是实际调用。

示例：

```java
List<String> list = new LinkedList<String>();  
List<String> spy = spy(list);  
when(spy.size()).thenReturn(100);  
  
spy.add("one");  
spy.add("two");  
  
assertEquals(spy.get(0), "one");  
assertEquals(100, spy.size());
```

spy的标准是：如果不打桩，默认执行真实的方法，如果打桩则返回桩实现。

### spy是否真的调用了方法？

使用不同的打桩方式，对于spy是否真的调用该方法的影响是不同的。例如：

[difference between doReturn and when](https://stackoverflow.com/questions/20353846/mockito-difference-between-doreturn-and-when)

- `when(...) thenReturn(...)`**做了真实调用**。只是返回了指定的结果
- `doReturn(...) when(...)`**不做真实调用**

注意：

> This behavior just works for spied objects, since are “wrapper” of real objects. In the case of mocked objects, it does not matter if it’s when/thenReturn or doReturn/ when. Mocked objects never calls real methods.
> 对于mock对象，没有这种区别

### 另外一种部分Mock的方法——`callRealMethod()`

即使是mock对象，也可以去调用真实的方法，即使用`callRealMethod()`。

示例：

```java
@Test  
public void callRealMethodTest() {  
    Jerry jerry = mock(Jerry.class);  
  
    doCallRealMethod().when(jerry).goHome();  
    doCallRealMethod().when(jerry).doSomeThingB();  
  
    jerry.goHome();  
  
    verify(jerry).doSomeThingA();  
    verify(jerry).doSomeThingB();  
}  
  
class Jerry {  
    public void goHome() {  
        doSomeThingA();  
        doSomeThingB();  
    }  
  
    // real invoke it.  
    public void doSomeThingB() {  
        System.out.println("good day");    
    }  
  
    // auto mock method by mockito  
    public void doSomeThingA() {  
        System.out.println("you should not see this message.");  
    }  
}
```

## 使用PowerMock模拟私有方法、静态方法

模拟静态方法见上方mock静态方法相关小节。

在模拟私有方法时就需要用到spy了，示例如下:

```java
@Test
public void spy_private_method() throws Exception {
    UserController spy = PowerMockito.spy(controller);
    PowerMockito.when(spy, "check", any()).thenReturn(true);//私有方法mockito不行了，需要用无所不能的PowerMock监视spy
    String name = spy.getPrivateName("ljw");
    assertEquals("private 被mock 了", name);
}
```

在模拟私有方法、静态方法、final方法和PowerMockito.whenNew方法时，`一定注意`需要添加下方两个注解

@RunWith(PowerMockRunner.class)     // 这是必须的
@PrepareForTest({ExampleService.class})  // 声明要处理要处理的类

# 参考文献

* https://www.letianbiji.com/java-mockito/mockito-hello-world.html
* https://breeze924.github.io/2018/08/27/Mock%E5%92%8CSpy%E7%9A%84%E5%8C%BA%E5%88%AB/
* https://www.cnblogs.com/ljw-bim/p/9391770.html
* https://www.cnblogs.com/softidea/p/4204376.html
* https://blog.csdn.net/qaz296490709/article/details/72880370