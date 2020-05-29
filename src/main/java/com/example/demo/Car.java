package com.example.demo;

import javax.persistence.*;

@Entity
public class Car {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String make;
    private String Model;
    private int year;
    private double MSRP;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    public Car() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMSRP() {
        return MSRP;
    }

    public void setMSRP(double MSRP) {
        this.MSRP = MSRP;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category catagory) {
        this.category = catagory;
    }
}
