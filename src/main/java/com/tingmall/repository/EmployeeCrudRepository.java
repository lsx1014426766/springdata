package com.tingmall.repository;

import com.tingmall.domain.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lsx on 2017/4/13.
 * //不需要写方法，执行使用CrudRepository提供的方法即可
 */
public interface EmployeeCrudRepository extends CrudRepository<Employee,Integer> {
}
