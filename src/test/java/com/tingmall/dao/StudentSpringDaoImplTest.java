package com.tingmall.dao;

import com.tingmall.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by lsx on 2017/4/13.
 */
public class StudentSpringDaoImplTest {
    ApplicationContext ctx=null;
    StudentDAO studentDAO=null;
    @Before
    public  void before(){
        ctx=new ClassPathXmlApplicationContext("beans.xml");
        studentDAO = (StudentDAO)ctx.getBean("studentDAO");
        System.out.println("setup");
    }
    @After
    public  void after(){
        ctx = null;
        System.out.println("tearDown");

    }
    @Test
    public void testStudentSpringDaoImplTest(){
        List<Student> students = studentDAO.query();

        for (Student student : students) {
            System.out.println("id:" + student.getId()
                    + " , name:" + student.getName()
                    + ", age:" + student.getAge());
        }
    }
    @Test
    public void testSave() {
        Student student = new Student();
        student.setName("test-spring-jdbc");
        student.setAge(40);

        studentDAO.save(student);
    }

}
