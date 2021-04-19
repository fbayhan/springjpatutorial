package com.springdata.tarik.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblproject")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy="project")
    private List<User> employees = new ArrayList<>();

    @Transient
    private double totalWage;

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

    public List<User> getEmployees() {
        return employees;
    }

    public void setEmployees(List<User> employees) {
        this.employees = employees;
    }

    public double getTotalWage() {
        return totalWage;
    }

    public void setTotalWage(double totalWage) {
        this.totalWage = totalWage;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                ", totalWage=" + totalWage +
                '}';
    }
}