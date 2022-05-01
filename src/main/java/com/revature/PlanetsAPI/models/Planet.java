package com.revature.PlanetsAPI.models;


import javax.persistence.*;

@Entity
@Table
public class Planet {

    @Id //to treat this as the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // primary key value would be auto generated
    private int id;

    @Column(name = "planet_name", nullable = false) // cannot be null
    private String name;

    @Column
    private double mass;


    public Planet() {
    }

    public Planet(int id, String name, double mass) {
        this.id = id;
        this.name = name;
        this.mass = mass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mass=" + mass +
                '}';
    }
}
