package net.yorksolutions.springdemo.repositories;

import net.yorksolutions.springdemo.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.ForeignKey;

@Repository

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
