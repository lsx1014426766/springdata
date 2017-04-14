1创建maven项目
2mvn依赖导入  mvnrepository.com
    <!--mysql-connector-java -->
        <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <version>5.1.38</version>
        </dependency>

        <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>3.8.1</version>
          <scope>test</scope>
        </dependency>
3 db table准备
  create database springdata;
  use springdata;
  show tables;
  create table student(
  id int not null auto_increment,
  name varchar(20) not null,
  age int not null,
  primary key(id)
  );
  show tables;
  desc student;
  insert into student(name,age)values("zhangsan",20);
  insert into student(name,age)values("lisi",21);
  insert into student(name,age)values("wangwu",25);

4 开发JDBCUtil 工具类
5 Spring jdbcTemplate方式
   maven依赖
   datasource 依赖注入

   再高级，封装的再深，数据源都是要提供的

   1添加依赖
    <!--spring jdbcTemplate方式-->
       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-jdbc</artifactId>
         <version>4.3.5.RELEASE</version>
       </dependency>

       <dependency>
         <groupId>org.springframework</groupId>
         <artifactId>spring-context</artifactId>
         <version>4.3.5.RELEASE</version>
       </dependency>

     2配置beans.xml
     3开发 spring jdbc版本的query save方法

2種方式的比较
   原生态或者使用spring jdbc 代码量都很大
   分页功能

 第三种方式   spring data JPA

  1添加依赖
   <!--spring data jpa-->
      <dependency>
        <groupId>org.springframework.data</groupId>
        <artifactId>spring-data-jpa</artifactId>
        <version>1.8.0.RELEASE</version>
      </dependency>

      <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-entitymanager</artifactId>
        <version>4.3.6.Final</version>
      </dependency>
   2在xml配置文件中做配置
   3Reository 是springdata的核心
   RepositoryDefinition
   Repository Query Specifications
   Query Annotation
   UPDATE DELETE Transaction
   体系结构
      crud
      paging and sorting
      jpa
      japspecificationexecutor

    Repository详解
    Spring Data的核心接口 不提供任何方法
    Repository类的定义：
    public interface Repository<T, ID extends Serializable> {

    }

    1）Repository是一个空接口，标记接口
    没有包含方法声明的接口

    2）如果我们定义的接口EmployeeRepository extends Repository

    如果我们自己的接口没有extends Repository，运行时会报错：
    org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.tingmall.repository.EmployeeRepository' available

    3) 添加注解能到达到不用extends Repository的功能
    @RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)

    子接口
    Repository中查询方法定义规则和使用
    查询方法名称的定义规则
    复杂查询


    insert into employee (name, age) values ("test1",20);
    insert into employee (name, age) values ("test2",21);
    insert into employee (name, age) values ("test3",22);
    insert into employee (name, age) values ("test4",20);
    insert into employee (name, age) values ("test5",21);
    insert into employee (name, age) values ("test6",22);
    insert into employee (name, age) values ("test16",22);

对于按照方法命名规则来使用的话，有弊端：
1）方法名会比较长： 约定大于配置
2）对于一些复杂的查询，是很难实现


@Query
在Resposity中使用不用遵循命名规则
只需将@Query定义在Repository的方法上
命名参数及索引的使用
本地查询


事务在Spring data中的使用：
1）事务一般是在Service层
2）@Query、 @Modifying、@Transactional的综合使用

子接口PagingAndSortingRepository
分页和排序功能
 带排序功能：findAll(Sort sort)
 带排序的分页查询findAll(Pageable pageable)

 jpaspecificationexecutor