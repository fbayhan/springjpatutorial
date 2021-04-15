package com.springdata.tarik.model;

import javax.persistence.*;

@Entity
@Table(name = "tbladdress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adressId;

    private String adressDetail;


    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

}
