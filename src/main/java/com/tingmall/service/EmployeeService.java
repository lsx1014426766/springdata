package com.tingmall.service;

import com.tingmall.domain.Employee;
import com.tingmall.repository.EmployeeCrudRepository;
import com.tingmall.repository.EmployeeReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

//不用在beans-new.xml中配置，因为配置了某包下的扫描
@Service
public class EmployeeService {

    //这里设置了自动注入，不用再写getter setter方法，其实这个方法也是为了注入使用的，现在有了自动注入也就不需要了
    @Autowired
    private EmployeeReposity employeeRepository;
    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;

    @Transactional
    public void update(Integer id, Integer age) {
        employeeRepository.update(id, age);
    }
    @Transactional
    public void save(List<Employee>list){
        employeeCrudRepository.save(list);
    };

}
