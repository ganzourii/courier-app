package com.goods.courierapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pilots")
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pilot_id")
    private int pilotId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @Column(name = "plate_number")
    private String plateNumber;

    @Column(name = "license_number")
    private String licenseNumber;

    @Column(name = "shipments_delivered")
    private int shipmentsDelivered;

    public Pilot() {
    }

    public Pilot(User user, String plateNumber, String licenseNumber, int shipmentsDelivered) {
        this.user = user;
        this.plateNumber = plateNumber;
        this.licenseNumber = licenseNumber;
        this.shipmentsDelivered = shipmentsDelivered;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getShipmentsDelivered() {
        return shipmentsDelivered;
    }

    public void setShipmentsDelivered(int shipmentsDelivered) {
        this.shipmentsDelivered = shipmentsDelivered;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "pilotId=" + pilotId +
                ", user=" + user.toString() +
                ", plateNumber='" + plateNumber + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", shipmentsDelivered=" + shipmentsDelivered +
                '}';
    }
}
