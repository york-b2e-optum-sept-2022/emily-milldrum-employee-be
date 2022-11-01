package net.yorksolutions.springdemo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    String name;
    String role;
    boolean manager;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    public Employee() {}
    public Employee(String name, String role, boolean manager){
        this.name = name;
        this.role = role;
        this.manager = manager;
    }

    //setters & getters?


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
