package net.yorksolutions.springdemo.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    @OneToMany
    Set<Employee> reports;
    //@ManyToOne manager
    //@ManyToMany

    public Manager(){}
    public Manager(String name) {

        this.name = name;
    }
    public Manager(String name, Long id) {

        this.name = name;
        this.id = id;
    }



    // Set - just like a list, except no duplicates are allowed
    // [ 1, 2, 3 ] is a set
    // [ 1, 2, 1 ] not a set


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getReports() {
        return reports;
    }

    public void setReports(Set<Employee> reports) {
        this.reports = reports;
    }
}
