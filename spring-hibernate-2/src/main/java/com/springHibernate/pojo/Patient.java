package com.springHibernate.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="student")
public class Patient {
    @Id
    @Column(name="id")
    private int id;
}
