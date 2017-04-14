package com.tingmall.repository;

import com.tingmall.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lsx on 2017/4/13.
 */
public class EmployeeReposityTest {
    private ApplicationContext ctx = null;
    private EmployeeReposity employeeReposity = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeReposity= ctx.getBean(EmployeeReposity.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testEmployReposity(){
        System.out.println(employeeReposity);
        Employee employee = employeeReposity.findByName("lsx");
        System.out.println("id:" + employee.getId()
                + " , name:" + employee.getName()
                + " ,age:" + employee.getAge());


    }
    @Test
    public void testFindByNameStartingWithAndAgeLessThan(){

        List<Employee> employees = employeeReposity.findByNameStartingWithAndAgeLessThan("test1",30);
        for(Employee employee:employees){
            System.out.println("id:" + employee.getId()
                    + " , name:" + employee.getName()
                    + " ,age:" + employee.getAge());
        }



    }
    @Test
    public void testFindByNameEndingWithAndAgeLessThan() {
        List<Employee> employees = employeeReposity.findByNameEndingWithAndAgeLessThan("6", 23);

        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId()
                    + " , name:" + employee.getName()
                    + " ,age:" + employee.getAge());
        }
    }


    @Test
    public void testFindByNameInOrAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeReposity.findByNameInOrAgeLessThan(names, 22);

        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId()
                    + " , name:" + employee.getName()
                    + " ,age:" + employee.getAge());
        }
    }

    @Test
    public void testFindByNameInAndAgeLessThan() {
        List<String> names = new ArrayList<String>();
        names.add("test1");
        names.add("test2");
        names.add("test3");
        List<Employee> employees = employeeReposity.findByNameInAndAgeLessThan(names, 22);

        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId()
                    + " , name:" + employee.getName()
                    + " ,age:" + employee.getAge());
        }
    }
    @Test
    public void testGetEmployeeByMaxId() {

        Employee employee = employeeReposity.getEmployeeByMaxId();


            System.out.println("id:" + employee.getId()
                    + " , name:" + employee.getName()
                    + " ,age:" + employee.getAge());

    }
    @Test
    public void testQueryParams1() {
        List<Employee> employees = employeeReposity.queryParams1("zhangsan", 20);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId()
                    + " , name:" + employee.getName()
                    + " ,age:" + employee.getAge());
        }
    }

    @Test
    public void testQueryParams2() {
        List<Employee> employees = employeeReposity.queryParams2("zhangsan", 20);
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId()
                    + " , name:" + employee.getName()
                    + " ,age:" + employee.getAge());
        }
    }


    @Test
    public void testQueryLike1() {
        List<Employee> employees = employeeReposity.queryLike1("test");
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId()
                    + " , name:" + employee.getName()
                    + " ,age:" + employee.getAge());
        }
    }

    @Test
    public void testQueryLike2() {
        List<Employee> employees = employeeReposity.queryLike2("test1");
        for (Employee employee : employees) {
            System.out.println("id:" + employee.getId()
                    + " , name:" + employee.getName()
                    + " ,age:" + employee.getAge());
        }
    }

    @Test
    public void testGetCount() {
        long count = employeeReposity.getCount();
        System.out.println("count:" + count);
    }




}
