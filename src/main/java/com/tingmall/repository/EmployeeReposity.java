package com.tingmall.repository;

import com.tingmall.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lsx on 2017/4/13.
 * 这里继承了Repository，就把这个接口交给了spring来管理
 */
public interface EmployeeReposity extends Repository<Employee,Integer> {
    //此方法只写到这里就可以直接调用了springdata把具体实现已经疯传实现，但是此方法的命名规则也必须遵守才行
    public Employee findByName(String name);
    //where name like ?% and age<?
    public List<Employee> findByNameStartingWithAndAgeLessThan(String name, Integer age);


    // where name like %? and age <?
    public List<Employee> findByNameEndingWithAndAgeLessThan(String name, Integer age);

    // where name in (?,?....) or age <?
    public List<Employee> findByNameInOrAgeLessThan(List<String> names, Integer age);

    // where name in (?,?....) and age <?
    public List<Employee> findByNameInAndAgeLessThan(List<String> names, Integer age);


    @Query("select o from Employee o where id=(select max(id) from Employee t1)")
    public Employee getEmployeeByMaxId();

    //索引参数方式 sql中相当于之前写过的hql，是针对对象操作的
    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    public List<Employee> queryParams1(String name, Integer age);

    //命名参数方式，这种方式必须进行参数绑定
    @Query("select o from Employee o where o.name=:name and o.age=:age")
    public List<Employee> queryParams2(@Param("name")String name, @Param("age")Integer age);

    @Query("select o from Employee o where o.name like %?1%")
    public List<Employee> queryLike1(String name);

    @Query("select o from Employee o where o.name like %:name%")
    public List<Employee> queryLike2(@Param("name")String name);

    //针对表操作，即本地查询，默认是关闭的，需要手动打开
    @Query(nativeQuery = true, value = "select count(1) from employee")
    public long getCount();

    //关于更新和删除类操作 需要在Query基础上加上modifying可修改，而且需在service上加事务transaction
    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    public void update(@Param("id")Integer id, @Param("age")Integer age);

}
