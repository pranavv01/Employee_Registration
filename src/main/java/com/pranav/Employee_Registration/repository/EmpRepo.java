package com.pranav.Employee_Registration.repository;

import com.pranav.Employee_Registration.model.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);
}
