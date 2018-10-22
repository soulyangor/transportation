/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ivc.transportation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Nesterov Yuriy
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"transportDep"})
@ToString(exclude = {"transportDep"})
@NoArgsConstructor
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String firstname;

    @NonNull
    @Column(nullable = false)
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private Date birthday; //date of birthday driver

    @NonNull
    @Column(length = 1024)
    private String addres;

    @NonNull
    private String phone;

    @NonNull
    @Column(nullable = false)
    private String vacant;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private TransportDep transportDep;

    public Driver(String firstname, String name, String surname, Date birthday, String addres, String phone, String vacant,TransportDep transportDep) {
        this.firstname = firstname;
        this.surname = surname;
        this.birthday = birthday;
        this.addres = addres;
        this.phone = phone;
        this.vacant = vacant;
        this.name = name;
        this.transportDep = transportDep;
    }

    /*public Driver(String firstname, String name, String surname, Date birthday, String addres, String phone, String vacant) {
        this.firstname = firstname;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.addres = addres;
        this.phone = phone;
        this.vacant = vacant;
    }*/


}
