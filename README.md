# smart-framework

在看《架构探险：从零开始写Java Web框架》

1.配置文件

需要配置文件smart.properties，字段如下：
···
# JDBC connection
smart.framework.jdbc.driver=
smart.framework.jdbc.url=
smart.framework.jdbc.username=
smart.framework.jdbc.password=
# app path
smart.framework.app.base_package=
smart.framework.app.jsp_path=
smart.framework.asset_path=
···

## DispatcherServlet完成请求参数封装、分发、返回

2.Controller注解

作用于类，表示 前台页面请求的处理类  

3.Action注解

作用于方法，表示 处理对应请求的处理方法

值的格式为（method:/path_info）, 例如 @Action("get:/customer")

3.Param类

框架统一将请求参数封装到Param类中

4.Data/View类

框架统一返回处理结果

View，表示视图

Data，封装了要返回的对象，以Json串的形式返回

5.Inject注解

作用于自动注入的参数

## AOP相关功能

1.继承AspectProxy类

## Transaction相关功能

Transaction注解，作用于方法
