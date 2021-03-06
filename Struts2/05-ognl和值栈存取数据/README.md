# ognl和值栈存取数据

### OGNL概述
```
1 之前web阶段，学习过EL表达式，EL表达式在jsp中获取域对象里面的值
2 OGNL是一种表达式，这个表达式功能更加强大，
（1）在struts2里面操作值栈数据
（2）一般把ognl在struts2操作：和struts2标签一起使用操作值栈
3 OGNL不是struts2的一部分，单独的项目，经常和struts2一起使用
（1）使用ognl时候首先导入jar包，struts2提供jar包
```

### OGNL入门案例
```
1 使用ognl+struts2标签实现计算字符串长度
（1）在java代码中，调用字符串.length();
2 使用struts2标签
（1）使用jstl时候，导入jar包之外，在jsp页面中引入标签库
使用struts2标签时候，在jsp中引入标签库
（2）使用struts2标签实现操作
```

### 什么是值栈
```
1 之前在web阶段，在servlet里面进行操作，把数据放到域对象里面，在页面中使用el表达式获取到，域对象在一定范围内，存值和取值
2 在struts2里面提供本身一种存储机制，类似于域对象，是值栈，可以存值和取值
（1）在action里面把数据放到值栈里面，在页面中获取到值栈数据
3 servlet和action区别
（1）Servlet：默认在第一次访问时候创建，创建一次，单实例对象
（2）Action：访问时候创建，每次访问action时候，都会创建action对象，创建多次，多实例对象

4 值栈存储位置
（1）每次访问action时候，都会创建action对象，
（2）在每个action对象里面都会有一个值栈对象（只有一个）
```

### 获取值栈对象
```
1 获取值栈对象有多种方式
（1）常用方式：使用ActionContext类里面的方法得到值栈对象
2 每个action对象中只有一个值栈对象
```
 
 

### 值栈内部结构
```
1 值栈分为两部分：
第一部分 root，结构是list集合
（1）一般操作都是root里面数据
第二部分 context，结构map集合
2 struts2里面标签 s:debug，使用这个标签可以查看值栈结构和存储值
（1）访问action，执行action的方法有返回值，配置返回值到jsp页面中，在jsp页面中使用这个标签
点击超链接看到结构
（2）在action没有做任何操作，栈顶元素是 action引用
- action对象里面有值栈对象
- 值栈对象里面有action引用
```

### 向值栈放数据
```
1 向值栈放数据多种方式
第一种 获取值栈对象，调用值栈对象里面的 set 方法
第二种 获取值栈对象，调用值栈对象里面的  push方法
第三种 在action定义变量，生成变量的get方法
```

### 向值栈放对象
```
1 实现步骤
第一步 定义对象变量
第二步 生成变量的get方法
第三步 在执行的方法里面向对象中设置值
```

### 从值栈获取数据
```
使用struts2的标签+ognl表达式获取值栈数据
  <s:property value=”ognl表达式”/>
获取字符串
  1 向值栈放字符串
  2 在jsp使用struts2标签+ognl表达式获取
获取对象
  1 向值栈放对象
  2 在页面中获取值
```


### EL表达式获取值栈数据（为什么）
```
1 EL表达式获取域对象值
2 向域对象里面放值使用setAttribute方法，获取值使用getAttribute方法
3 底层增强request对象里面的方法getAttribute方法
（1）首先从request域获取值，如果获取到，直接返回
（2）如果从request域获取不到值，到值栈中把值获取出来，把值放到域对象里面
```
 
 

### OGNL的#、%使用
```
#使用
  1 使用#获取context里面数据
  2 演示# 操作
  （1）向request域放值
  （2）在页面中使用ognl获取
%使用
  1 在struts2标签中表单标签
  （1）在struts2标签里面使用ognl表达式，如果直接在struts2表单标签里面使用ognl表达式不识别，只有%之后才会识别。
 ```
