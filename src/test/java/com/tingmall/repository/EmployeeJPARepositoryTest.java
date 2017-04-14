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
public class EmployeeJPARepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJPARepository employeeJPARepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJPARepository= ctx.getBean(EmployeeJPARepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFind(){

        Employee e=employeeJPARepository.findOne(5);
        System.out.println("e:"+e);
        System.out.println("e100:"+employeeJPARepository.exists(100));


    }

}
