package com.tingmall.repository;

import com.tingmall.domain.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by lsx on 2017/4/13.
 */
public interface EmployeePageAndSortingRepository extends PagingAndSortingRepository<Employee,Integer> {
}
