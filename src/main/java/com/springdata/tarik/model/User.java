package com.springdata.tarik.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "tbluser")
 public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Double wage;
    @JsonIgnore
    private boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonBackReference
    private Project project;


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

   public String getSurname() {
      return surname;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public Double getWage() {
      return wage;
   }

   public void setWage(Double wage) {
      this.wage = wage;
   }

   public boolean isDeleted() {
      return deleted;
   }

   public void setDeleted(boolean deleted) {
      this.deleted = deleted;
   }

   public Project getProject() {
      return project;
   }

   public void setProject(Project project) {
      this.project = project;
   }


}


