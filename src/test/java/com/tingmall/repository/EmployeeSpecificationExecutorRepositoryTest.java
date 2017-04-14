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
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import javax.persistence.criteria.*;

/**
 * Created by lsx on 2017/4/13.
 */
public class EmployeeSpecificationExecutorRepositoryTest {
    private ApplicationContext ctx = null;
    private EmployeeJPASpecificationExecutorRepository employeeJPASpecificationExecutorRepositoryjRepository = null;

    @Before
    public void setup(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        employeeJPASpecificationExecutorRepositoryjRepository= ctx.getBean(EmployeeJPASpecificationExecutorRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testQuery(){
        //索引从0开始
        Sort.Order order=new Sort.Order(Sort.Direction.DESC,"id");
        Sort sort=new Sort(order);
        Pageable pageable=new PageRequest(0,4,sort);

        Specification<Employee> specification=new Specification<Employee>(){
            /**
             *
             * @param root 查询类型 此处为Employee
             * @param criteriaQuery  查询条件
             * @param criteriaBuilder 构建predict
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path path= root.get("age");
                //criteriaBuilder.gt(path,10);
                return criteriaBuilder.lt(path,10);
            }
        };

        Page<Employee> page=employeeJPASpecificationExecutorRepositoryjRepository.findAll(specification,pageable);
        System.out.println("getTotalElements总记录数"+page.getTotalElements());
        System.out.println("getTotalPages"+page.getTotalPages());
        System.out.println("getContent"+page.getContent());
        System.out.println("getNumber页码"+page.getNumber());
        System.out.println("getSize每页大小"+page.getSize());
        System.out.println("getNumberOfElements当前集合元素个数"+page.getNumberOfElements());




    }

}
