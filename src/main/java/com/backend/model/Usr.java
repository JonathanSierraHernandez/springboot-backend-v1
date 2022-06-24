package com.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usr")
public class Usr implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "email", unique=true)
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "plate")
    private String plate;


    // standard constructors / setters / getters / toString
    public Usr() {
    }

    public Usr(String name, String surname, String telephone, String email, String address, String plate) {
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
        this.plate = plate;
    }
    public void setId(int id) { this.id = id;}

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setEmail(String email) { this.email = email; }

    public long getId() { return id; }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPlate() {
        return plate;
    }


}
