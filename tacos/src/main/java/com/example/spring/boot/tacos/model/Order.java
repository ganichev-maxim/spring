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
    private String deliveryName;
    @NotBlank(message="Street is required")
    @Column(name = "deliveryStreet")
    private String deliveryStreet;
    @NotBlank(message="City is required")
    @Column(name = "deliveryCity")
    private String deliveryCity;
    @NotBlank(message="State is required")
    @Column(name = "deliveryState")
    private String deliveryState;
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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

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

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String name) {
        this.deliveryName = name;
    }

    public String getDeliveryStreet() {
        return deliveryStreet;
    }

    public void setDeliveryStreet(String street) {
        this.deliveryStreet = street;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String city) {
        this.deliveryCity = city;
    }

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String state) {
        this.deliveryState = state;
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
                ", name='" + deliveryName + '\'' +
                ", street='" + deliveryStreet + '\'' +
                ", city='" + deliveryCity + '\'' +
                ", state='" + deliveryState + '\'' +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
