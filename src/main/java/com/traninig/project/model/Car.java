package com.traninig.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Car {

    @Id
    @Column(nullable = false)
    private int plateNumber;
    private String carType;

    @ManyToOne
    @JoinColumn (name = "customer_id")
    private Customer customer;

    @ManyToMany
    private List<Spot> spot ;

    @OneToMany(mappedBy = "car")
    private List<Service> service ;

    public Car(int plateNumber, String carType, Customer customer, List<Spot> spot, List<Service> service) {
        this.plateNumber = plateNumber;
        this.carType = carType;
        this.customer = customer;
        this.spot = spot;
        this.service = service;
    }

    public Car() {

    }

    public Car(int plateNumber, String carType) {
        this.plateNumber = plateNumber;
        this.carType = carType;

    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Spot> getSpot() {
        return spot;
    }

    public void setSpot(List<Spot> spot) {
        this.spot = spot;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }
}
