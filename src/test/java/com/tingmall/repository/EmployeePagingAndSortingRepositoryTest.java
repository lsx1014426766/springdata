package com.tingmall.repository;

import com.tingmall.domain.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by lsx on 2017/4/13.
 */
public class EmployeePagingAndSortingRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeePageAndSortingRepository employeePagingAndSortingRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeePagingAndSortingRepository= ctx.getBean(EmployeePageAndSortingRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testPaging(){
        //索引从0开始
        Pageable pageable=new PageRequest(0,4);
 Page<Employee> page=employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("getTotalElements总记录数"+page.getTotalElements());
        System.out.println("getTotalPages"+page.getTotalPages());
        System.out.println("getContent"+page.getContent());
        System.out.println("getNumber页码"+page.getNumber());
        System.out.println("getSize每页大小"+page.getSize());
        System.out.println("getNumberOfElements当前集合元素个数"+page.getNumberOfElements());




    }
    @Test
    public void testPageAndSort(){
        //索引从0开始
        Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort=new Sort(order);
        Pageable pageable=new PageRequest(0,4,sort);
        Page<Employee> page=employeePagingAndSortingRepository.findAll(pageable);
        System.out.println("getTotalElements总记录数"+page.getTotalElements());
        System.out.println("getTotalPages"+page.getTotalPages());
        System.out.println("getContent"+page.getContent());
        System.out.println("getNumber页码"+page.getNumber());
        System.out.println("getSize每页大小"+page.getSize());
        System.out.println("getNumberOfElements当前集合元素个数"+page.getNumberOfElements());




    }
}
