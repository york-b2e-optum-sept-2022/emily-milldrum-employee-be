package net.yorksolutions.springdemo.contollers;

import net.yorksolutions.springdemo.models.Manager;
import net.yorksolutions.springdemo.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
@CrossOrigin
public class ManagerController {
    private final ManagerService service;

    @Autowired
    public ManagerController(ManagerService service) {
        this.service = service;
    }

    @PostMapping("/add")
    Manager addNewManager(@RequestBody Manager manager) {
        return service.addNewManager(manager);
    }

    @PutMapping
    public void addDirectReport(@RequestParam Long manager_id, @RequestParam Long employee_id) {
        service.addDirectReport(employee_id, manager_id);
    }

    @GetMapping
    public Iterable<Manager> getAll() {
    //public String getAll() {
        return service.getAll();
        //return "made it to get all";
    }
}
