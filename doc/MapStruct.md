# 简介

MapStruct是满足JSR269规范的一个Java注解处理器，用于为Java Bean生成类型安全且高性能的映射。它基于编译阶段生成get/set代码，此实现过程中没有反射，不会造成额外的性能损失。

您所要做的就是定义一个mapper接口（@Mapper），该接口用于声明所有必须的映射方法。在编译期间MapStruct会为该接口自动生成实现类。该实现类使用简单的Java方法调用来映射source-target对象，在此过程中没有反射或类似的行为发生。

官网链接：[https://mapstruct.org/](https://mapstruct.org/)

# 优点

**与手工编写映射代码相比**
MapStruct通过生成冗长且容易出错的代码来节省时间。

**与动态映射框架相比**
简单泛型智能转换；
效率高：无需手动 set/get 或 implements Serializable 以达到深拷贝；
性能更高：使用简单的Java方法调用代替反射；
编译时类型安全：只能映射相同名称或带映射标记的属性；
编译时产生错误报告：如果映射不完整（存在未被映射的目标属性）或映射不正确（找不到合适的映射方法或类型转换）则会在编译时抛出异常。

# 引入

MapStruct主要由两部分组成：

**org.mapstruct:mapstruct**：包含了一些必要的注解，例如@Mapping。我们使用的JDK版本高于1.8，当我们在pom里面导入依赖时候，建议使用坐标是：org.mapstruct:mapstruct-jdk8，这可以帮助我们利用一些Java8的新特性。  

**org.mapstruct:mapstruct-processor**：注解处理器，根据注解自动生成mapper的实现。

# 使用

## MapStruct是用来做什么的？

现在有这么个场景，从数据库查询出来了一个user对象（包含id，用户名，密码，手机号，邮箱，角色这些字段）和一个对应的角色对象role（包含id，角色名，角色描述这些字段），现在在controller需要用到user对象的id，用户名，和角色对象的角色名三个属性。一种方式是直接把两个对象传递到controller层，但是这样会多出很多没用的属性。更通用的方式是需要用到的属性封装成一个类(DTO)，通过传输这个类的实例来完成数据传输。

User.java

```java
@AllArgsConstructor
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String phoneNum;
    private String email;
    private Role role;
}
```

Role.java
```java
@AllArgsConstructor
@Data
public class Role {
    private Long id;
    private String roleName;
    private String description;
}
```

UserRoleDto.java，这个类就是封装的类

```java
@Data
public class UserRoleDto {
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户名
     */
    private String name;
    /**
     * 角色名
     */
    private String roleName;
}
```

测试类，模拟将user对象转换成UserRoleDto对象

```java
public class MainTest {
    User user = null;

    /**
     * 模拟从数据库中查出user对象
     */
    @Before
    public void before() {
       Role role  = new Role(2L, "administrator", "超级管理员");
       user  = new User(1L, "zhangsan", "12345", "17677778888", "123@qq.com", role);
    }

    /**
     * 模拟把user对象转换成UserRoleDto对象
     */
    @Test
    public void test1() {
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId(user.getId());
        userRoleDto.setName(user.getUsername());
        userRoleDto.setRoleName(user.getRole().getRoleName());
        System.out.println(userRoleDto);
    }
}
```

从上面代码可以看出，通过getter、setter的方式把一个对象属性值复制到另一个对象中去还是很麻烦的，尤其是当属性过多的时候。而MapStruct就是用于解决这种问题的。

## 使用MapStruct解决上述问题

这里我们沿用User.java、Role.java、UserRoleDto.java。
新建一个UserRoleMapper.java，这个来用来定义User.java、Role.java和UserRoleDto.java之间属性对应规则：
UserRoleMapper.java

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Mapper 定义这是一个MapStruct对象属性转换接口，在这个类里面规定转换规则
 *          在项目构建时，会自动生成改接口的实现类，这个实现类将实现对象属性值复制
 */
@Mapper
public interface UserRoleMapper {

    /**
     * 获取该类自动生成的实现类的实例
     * 接口中的属性都是 public static final 的 方法都是public abstract的
     */
    UserRoleMapper INSTANCES = Mappers.getMapper(UserRoleMapper.class);

    /**
     * 这个方法就是用于实现对象属性复制的方法
     *
     * @Mapping 用来定义属性复制规则 source 指定源对象属性 target指定目标对象属性
     *
     * @param user 这个参数就是源对象，也就是需要被复制的对象
     * @return 返回的是目标对象，就是最终的结果对象
     */
    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "role.roleName", target = "roleName")
    })
    UserRoleDto toUserRoleDto(User user);

}
```

在测试类中测试：

```java
public class MainTest {
    User user = null;

    /**
     * 模拟从数据库中查出user对象
     */
    @Before
    public void before() {
       Role role  = new Role(2L, "administrator", "超级管理员");
       user  = new User(1L, "zhangsan", "12345", "17677778888", "123@qq.com", role);
    }

    /**
     * 模拟通过MapStruct把user对象转换成UserRoleDto对象
     */
    @Test
    public void test2() {
        UserRoleDto userRoleDto = UserRoleMapper.INSTANCES.toUserRoleDto(user);
        System.out.println(userRoleDto);
    }
}
```

通过上面的例子可以看出，使用MapStruct方便许多。

## 添加默认方法

添加默认方法是为了这个类（接口）不只是为了做数据转换用的，也可以做一些其他的事。

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Mapper 定义这是一个MapStruct对象属性转换接口，在这个类里面规定转换规则
 *          在项目构建时，会自动生成改接口的实现类，这个实现类将实现对象属性值复制
 */
@Mapper
public interface UserRoleMapper {

    /**
     * 获取该类自动生成的实现类的实例
     * 接口中的属性都是 public static final 的 方法都是public abstract的
     */
    UserRoleMapper INSTANCES = Mappers.getMapper(UserRoleMapper.class);

    /**
     * 这个方法就是用于实现对象属性复制的方法
     *
     * @Mapping 用来定义属性复制规则 source 指定源对象属性 target指定目标对象属性
     *
     * @param user 这个参数就是源对象，也就是需要被复制的对象
     * @return 返回的是目标对象，就是最终的结果对象
     */
    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "role.roleName", target = "roleName")
    })
    UserRoleDto toUserRoleDto(User user);

    /**
     * 提供默认方法，方法自己定义，这个方法是我随便写的，不是要按照这个格式来的
     * @return
     */
    default UserRoleDto defaultConvert() {
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId(0L);
        userRoleDto.setName("None");
        userRoleDto.setRoleName("None");
        return userRoleDto;
    }

}
```

测试代码：

```java
@Test
public void test3() {
    UserRoleMapper userRoleMapperInstances = UserRoleMapper.INSTANCES;
    UserRoleDto userRoleDto = userRoleMapperInstances.defaultConvert();
    System.out.println(userRoleDto);
}
```

## 可以使用abstract class来代替接口

mapper可以用接口来实现，也可以完全由抽象来完全代替

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Mapper 定义这是一个MapStruct对象属性转换接口，在这个类里面规定转换规则
 *          在项目构建时，会自动生成改接口的实现类，这个实现类将实现对象属性值复制
 */
@Mapper
public abstract class UserRoleMapper {

    /**
     * 获取该类自动生成的实现类的实例
     * 接口中的属性都是 public static final 的 方法都是public abstract的
     */
    public static final UserRoleMapper INSTANCES = Mappers.getMapper(UserRoleMapper.class);

    /**
     * 这个方法就是用于实现对象属性复制的方法
     *
     * @Mapping 用来定义属性复制规则 source 指定源对象属性 target指定目标对象属性
     *
     * @param user 这个参数就是源对象，也就是需要被复制的对象
     * @return 返回的是目标对象，就是最终的结果对象
     */
    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "role.roleName", target = "roleName")
    })
    public abstract UserRoleDto toUserRoleDto(User user);

    /**
     * 提供默认方法，方法自己定义，这个方法是我随便写的，不是要按照这个格式来的
     * @return
     */
    UserRoleDto defaultConvert() {
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId(0L);
        userRoleDto.setName("None");
        userRoleDto.setRoleName("None");
        return userRoleDto;
    }

}
```

## 可以使用多个参数

可以绑定多个对象的属性值到目标对象中：

```java
package com.mapstruct.demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Mapper 定义这是一个MapStruct对象属性转换接口，在这个类里面规定转换规则
 *          在项目构建时，会自动生成改接口的实现类，这个实现类将实现对象属性值复制
 */
@Mapper
public interface UserRoleMapper {

    /**
     * 获取该类自动生成的实现类的实例
     * 接口中的属性都是 public static final 的 方法都是public abstract的
     */
    UserRoleMapper INSTANCES = Mappers.getMapper(UserRoleMapper.class);

    /**
     * 这个方法就是用于实现对象属性复制的方法
     *
     * @Mapping 用来定义属性复制规则 source 指定源对象属性 target指定目标对象属性
     *
     * @param user 这个参数就是源对象，也就是需要被复制的对象
     * @return 返回的是目标对象，就是最终的结果对象
     */
    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "role.roleName", target = "roleName")
    })
    UserRoleDto toUserRoleDto(User user);

    /**
     * 多个参数中的值绑定 
     * @param user 源1
     * @param role 源2
     * @return 从源1、2中提取出的结果
     */
    @Mappings({
            @Mapping(source = "user.id", target = "userId"), // 把user中的id绑定到目标对象的userId属性中
            @Mapping(source = "user.username", target = "name"), // 把user中的username绑定到目标对象的name属性中
            @Mapping(source = "role.roleName", target = "roleName") // 把role对象的roleName属性值绑定到目标对象的roleName中
    })
    UserRoleDto toUserRoleDto(User user, Role role);
}
```

## 直接使用参数作为属性值

```java
package com.mapstruct.demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Mapper 定义这是一个MapStruct对象属性转换接口，在这个类里面规定转换规则
 *          在项目构建时，会自动生成改接口的实现类，这个实现类将实现对象属性值复制
 */
@Mapper
public interface UserRoleMapper {

    /**
     * 获取该类自动生成的实现类的实例
     * 接口中的属性都是 public static final 的 方法都是public abstract的
     */
    UserRoleMapper INSTANCES = Mappers.getMapper(UserRoleMapper.class);

    /**
     * 直接使用参数作为值
     * @param user
     * @param myRoleName
     * @return
     */
    @Mappings({
            @Mapping(source = "user.id", target = "userId"), // 把user中的id绑定到目标对象的userId属性中
            @Mapping(source = "user.username", target = "name"), // 把user中的username绑定到目标对象的name属性中
            @Mapping(source = "myRoleName", target = "roleName") // 把role对象的roleName属性值绑定到目标对象的roleName中
    })
    UserRoleDto useParameter(User user, String myRoleName);

}
```

## 更新对象属性

在之前的例子中`UserRoleDto useParameter(User user, String myRoleName);`都是通过类似上面的方法来生成一个对象。而MapStruct提供了另外一种方式来更新一个对象中的属性。`@MappingTarget`

```java
public interface UserRoleMapper1 {

    UserRoleMapper1 INSTANCES = Mappers.getMapper(UserRoleMapper1.class);

    @Mappings({
            @Mapping(source = "userId", target = "id"),
            @Mapping(source = "name", target = "username"),
            @Mapping(source = "roleName", target = "role.roleName")
    })
    void updateDto(UserRoleDto userRoleDto, @MappingTarget User user);


    @Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "role.roleName", target = "roleName")
    })
    void update(User user, @MappingTarget UserRoleDto userRoleDto);

}
```

通过`@MappingTarget`来指定目标类是谁（谁的属性需要被更新）。@Mapping还是用来定义属性对应规则。
以此为例说明：

```java
@Mappings({
            @Mapping(source = "id", target = "userId"),
            @Mapping(source = "username", target = "name"),
            @Mapping(source = "role.roleName", target = "roleName")
    })
    void update(User user, @MappingTarget UserRoleDto userRoleDto);
```

@MappingTarget标注的类UserRoleDto 为目标类，user类为源类，调用此方法，会把源类中的属性更新到目标类中。更新规则还是由@Mapping指定。

## 没有getter/setter也能赋值

对于没有getter/setter的属性也能实现赋值操作

```java
public class Customer {

    private Long id;
    private String name;

    //getters and setter omitted for brevity
}

public class CustomerDto {

    public Long id;
    public String customerName;
}

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );

    @Mapping(source = "customerName", target = "name")
    Customer toCustomer(CustomerDto customerDto);

    @InheritInverseConfiguration
    CustomerDto fromCustomer(Customer customer);
}
```

`@Mapping(source = “customerName”, target = “name”)`还是用来指定属性映射的，**如果两个对象的属性名相同是可以省略@Mapping的**。
MapStruct生成的实现类：

```java
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-02-14T15:41:21+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( customerDto.customerName );
        customer.setId( customerDto.id );

        return customer;
    }

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.customerName = customer.getName();
        customerDto.id = customer.getId();

        return customerDto;
    }
}
```

@InheritInverseConfiguration在这里的作用就是实现customerDto.customerName = customer.getName();功能的。如果没有这个注解，toCustomerDto这个方法则不会有customerName 和name两个属性的对应关系的。

## 使用Spring依赖注入

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
}

@Data
public class CustomerDto {
    private Long id;
    private String customerName;
}

// 这里主要是这个componentModel 属性，它的值就是当前要使用的依赖注入的环境
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "name", target = "customerName")
    CustomerDto toCustomerDto(Customer customer);
}
```

`@Mapper(componentModel = “spring”)`，表示把当前Mapper类纳入spring容器。可以在其它类中直接注入了：

```java
@SpringBootApplication
@RestController
public class DemoMapstructApplication {

	// 注入Mapper
    @Autowired
    private CustomerMapper mapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoMapstructApplication.class, args);
    }

    @GetMapping("/test")
    public String test() {
        Customer customer = new Customer(1L, "zhangsan");
        CustomerDto customerDto = mapper.toCustomerDto(customer);
        return customerDto.toString();
    }

}
```

看一下由mapstruct自动生成的类文件，会发现标记了@Component注解。

```java
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-02-14T15:54:17+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCustomerName( customer.getName() );
        customerDto.setId( customer.getId() );

        return customerDto;
    }
}
```

## 自定义类型转换

有时候，在对象转换的时候可能会出现这样一个问题，就是源对象中的类型是Boolean类型，而目标对象类型是String类型，这种情况可以通过@Mapper的uses属性来实现：

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Long id;
    private String name;
    private Boolean isDisable;
}

@Data
public class CustomerDto {
    private Long id;
    private String customerName;
    private String disable;
}
```

定义转换规则的类：

```java
public class BooleanStrFormat {
    public String toStr(Boolean isDisable) {
        if (isDisable) {
            return "Y";
        } else {
            return "N";
        }
    }
    public Boolean toBoolean(String str) {
        if (str.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }
}
```

定义Mapper，`@Mapper( uses = { BooleanStrFormat.class})`，注意，这里的users属性用于引用之前定义的转换规则的类：

```java
@Mapper( uses = { BooleanStrFormat.class})
public interface CustomerMapper {

    CustomerMapper INSTANCES = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "customerName"),
            @Mapping(source = "isDisable", target = "disable")
    })
    CustomerDto toCustomerDto(Customer customer);
}
```

这样子，Customer类中的isDisable属性的true就会转变成CustomerDto中的disable属性的yes。
MapStruct自动生成的类中的代码：

```java
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-02-14T16:49:18+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

	// 引用 uses 中指定的类
    private final BooleanStrFormat booleanStrFormat = new BooleanStrFormat();

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();
		// 转换方式的使用
        customerDto.setDisable( booleanStrFormat.toStr( customer.getIsDisable() ) );
        customerDto.setCustomerName( customer.getName() );
        customerDto.setId( customer.getId() );

        return customerDto;
    }
}
```

要注意的是，如果使用了例如像spring这样的环境，Mapper引入uses类实例的方式将是自动注入，那么这个类也应该纳入Spring容器：
CustomerMapper.java指定使用spring

```java
@Mapper(componentModel = "spring", uses = { BooleanStrFormat.class})
public interface CustomerMapper {

    CustomerMapper INSTANCES = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "customerName"),
            @Mapping(source = "isDisable", target = "disable")
    })
    CustomerDto toCustomerDto(Customer customer);
}
```

转换类要加入Spring容器：

```java
@Component
public class BooleanStrFormat {
    public String toStr(Boolean isDisable) {
        if (isDisable) {
            return "Y";
        } else {
            return "N";
        }
    }
    public Boolean toBoolean(String str) {
        if (str.equals("Y")) {
            return true;
        } else {
            return false;
        }
    }
}
```

MapStruct自动生成的类：

```java
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-02-14T16:55:35+0800",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

	// 使用自动注入的方式引入
    @Autowired
    private BooleanStrFormat booleanStrFormat;

    @Override
    public CustomerDto toCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setDisable( booleanStrFormat.toStr( customer.getIsDisable() ) );
        customerDto.setCustomerName( customer.getName() );
        customerDto.setId( customer.getId() );

        return customerDto;
    }
}
```

## 转换类型不一致和使用枚举类型

参考[https://www.cnblogs.com/mmzs/p/12735212.html](https://www.cnblogs.com/mmzs/p/12735212.html)

# 参考文献

* [https://blog.csdn.net/qq122516902/article/details/87259752](https://blog.csdn.net/qq122516902/article/details/87259752)
* [https://www.cnblogs.com/mmzs/p/12735212.html](https://www.cnblogs.com/mmzs/p/12735212.html)
* [https://lux-sun.blog.csdn.net/article/details/113946112](https://lux-sun.blog.csdn.net/article/details/113946112)
* [http://www.tianshouzhi.com/api/tutorials/mapstruct/291](http://www.tianshouzhi.com/api/tutorials/mapstruct/291)

