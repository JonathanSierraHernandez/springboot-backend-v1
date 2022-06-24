package com.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inout")
public class Inout implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "enter")
    private String enter;
    @Column(name = "out")
    private String out;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usr", referencedColumnName = "id")
    private Usr usr;

    // standard constructors / setters / getters / toString
    public Inout() {
    }

    public Inout(Usr usr, String enter, String out) {
        this.usr = usr;
        this.enter = enter;
        this.out = out;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEnter() {
        return enter;
    }

    public void setEnter(String enter) {
        this.enter = enter;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public Usr getUsr() {
        return usr;
    }

    public void setUsr(Usr usr) {
        this.usr = usr;
    }
}
