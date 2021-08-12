package com.traninig.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Spot {

    @Id
    private int spotID;
    private boolean status;

    @ManyToMany(mappedBy = "spot")
    private List<Car> car ;


    public Spot(int spotID, boolean status, List<Car> car) {
        this.spotID = spotID;
        this.status = status;
        this.car = car;
    }

    public Spot() {
    }

    public int getSpotID() {
        return spotID;
    }

    public void setSpotID(int spotID) {
        this.spotID = spotID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Car> getCar() {
        return car;
    }

    public void setCar(List<Car> car) {
        this.car = car;
    }
}
