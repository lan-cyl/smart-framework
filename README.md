# smart-framework

基于《架构探险：从零开始写Java Web框架》这本书整理的代码，实现方式也略有不同

搭建的maven项目，demo和framework是俩module，demo依赖framework，框架用法可参考demo

下面说下该framework的特性：

#### 1.轻量

```
// 仅依赖如下开源项目
jstl:1.2
slf4j-log4j12:1.7.19
mysql-connector-java:5.1.38
jackson-databind:2.8.4
commons-lang3:3.1
commons-collections:3.2.1
commons-dbutils:1.6
commons-dbcp:1.4
cglib:3.2.4
```

#### 2.功能完善

```
@Controller
@Action(get:/customer)
@Service
@Inject
@Aspect(Controller.class) 标记类为切面，现在用起来还是稍麻烦，参看demo里的ControllerAspect类
@Transaction 作用于方法，且类被@Service标记
```

### 改进：

1.Transaction的实现基于AspectProxy框架，重写intercept方法来过滤带有事物注解的方法

### 不足：

1.切面只能切到 类注解，即在类上加相应注解才能切入，不能对应到方法

要想过滤方法，用户需在自己的切面类中重写intercept方法

2.事物功能太死板，作用于Service注解的类，然后过滤方法上加Transaction注解的方法

且仅提供一种基本的事务功能