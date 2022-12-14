package net.yorksolutions.springdemo.services;

import net.yorksolutions.springdemo.models.Employee;
import net.yorksolutions.springdemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final ManagerService managerService;

    @Autowired
    public EmployeeService(EmployeeRepository repository, ManagerService managerService) {
        this.repository = repository;
        this.managerService = managerService;
    }

//    public boolean addNewEmployee(Employee employee) {
//
//        try {
//            repository.save(employee);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

    public Employee addNewEmployee(Employee employee) {
        repository.save(employee);
        return employee;
    }

    public Iterable<Employee> getAllEmployees() {
        //Collections.sort(repository.findAll());
        System.out.println("find all service");
        return repository.findAll();
    }

    public Optional<Employee> getById(Long id) {
        // null - references no object
        // null Reference Exception
        // Optional - to make it easy to write null safe code
        return repository.findById(id);
    }

    /**
     *
     * @param id
     * @return - true if the id was found and deleted, false otherwise
     */
    public boolean deleteById(Long id) {
        try {
            final var employee = repository.findById(id).orElseThrow();
            managerService.removeEmployeeFromAllManagers(employee);
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean updateById(Long id, Employee employee) {
        try {
            repository.findById(id).orElseThrow();
            repository.save(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
