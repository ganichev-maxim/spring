package com.example.spring.boot.tacos.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Taco_Order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "placedAt")
    private Date placedAt;
    @NotBlank(message="Name is required")
    @Column(name = "deliveryName")
    private String name;
    @NotBlank(message="Street is required")
    @Column(name = "deliveryStreet")
    private String street;
    @NotBlank(message="City is required")
    @Column(name = "deliveryCity")
    private String city;
    @NotBlank(message="State is required")
    @Column(name = "deliveryState")
    private String state;
    @NotBlank(message="Zip code is required")
    @Column(name = "deliveryZip")
    private String deliveryZip;
    @CreditCardNumber(message="Not a valid credit card number")
    @Column(name = "ccNumber")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    @Column(name = "ccExpiration")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    @Column(name="ccCVV")
    private String ccCVV;
    @ManyToMany(targetEntity=Taco.class)
    private List<Taco> tacos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(Date placedAt) {
        this.placedAt = placedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDeliveryZip() {
        return deliveryZip;
    }

    public void setDeliveryZip(String deliveryZip) {
        this.deliveryZip = deliveryZip;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }

    public void addDesign(Taco design) {
        this.tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", placedAt=" + placedAt +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", deliveryZip='" + deliveryZip + '\'' +
                ", ccNumber='" + ccNumber + '\'' +
                ", ccExpiration='" + ccExpiration + '\'' +
                ", ccCVV='" + ccCVV + '\'' +
                '}';
    }

    public List<Taco> getTacos() {
        return tacos;
    }

    public void setTacos(List<Taco> tacos) {
        this.tacos = tacos;
    }
}
