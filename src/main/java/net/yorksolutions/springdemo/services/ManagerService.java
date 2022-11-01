package net.yorksolutions.springdemo.services;

import net.yorksolutions.springdemo.models.Employee;
import net.yorksolutions.springdemo.models.Manager;
import net.yorksolutions.springdemo.repositories.EmployeeRepository;
import net.yorksolutions.springdemo.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private final ManagerRepository repository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public ManagerService(ManagerRepository repository, EmployeeRepository employeeRepository) {
        this.repository = repository;
        this.employeeRepository = employeeRepository;
    }

    public Manager addNewManager(Manager manager) {
       // repository.save(manager);
        return repository.save(manager);
    }

    public void addDirectReport(Long employee_id, Long manager_id) {
        // Get the Employee associated with the employee_id
        final var employee = employeeRepository.findById(employee_id).orElseThrow();
        final var manager = repository.findById(manager_id).orElseThrow();
        manager.getReports().add(employee); // No DB interaction here  , set reports?
        repository.save(manager);
    }

    public Iterable<Manager> getAll() {
        return repository.findAll();
    }

    public void removeEmployeeFromAllManagers(Employee employee) {
        for (Manager manager: getAll()) {
            manager.getReports().remove(employee); // set reports?
            repository.save(manager);
        }
    }
}