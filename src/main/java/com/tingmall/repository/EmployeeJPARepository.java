package com.tingmall.repository;

import com.tingmall.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lsx on 2017/4/13.
 */
public interface EmployeeJPARepository extends JpaRepository<Employee,Integer> {
}
