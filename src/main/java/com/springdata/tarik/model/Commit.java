package com.springdata.tarik.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tblcommit")
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="projectid",referencedColumnName="id")
    private Project project;

    @OneToOne
    @JoinColumn(name="userid",referencedColumnName="id")
    private User user;

    @Temporal(TemporalType.DATE)
    private Date day;
    private long count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Commit{" +
                "id=" + id +
                ", project=" + project +
                ", user=" + user +
                ", day=" + day +
                ", count=" + count +
                '}';
    }
}