package org.vin.restfulspring.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;
import java.util.List;

@Entity
@JacksonXmlRootElement(localName = "Friend")
public class Friend {

    @JacksonXmlProperty
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @JacksonXmlProperty
    String firstName;

    @JacksonXmlProperty
    String lastName;

    @JacksonXmlProperty
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FRIEND_ID")
    List<Address> addresses;

    public Friend(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
