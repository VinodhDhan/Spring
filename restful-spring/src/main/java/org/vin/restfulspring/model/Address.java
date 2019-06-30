package org.vin.restfulspring.model;

import javax.persistence.*;

@Entity
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String streetName;

    private String city;

    private String State;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }


}
