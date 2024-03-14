package com.goods.courierapp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipment_id")
    private int shipmentId;

    @Column(name = "sender_id")
    private int senderId;

    @Column(name = "receiver_id")
    private int receiverId;

    @Column(name = "pilot_id")
    private int pilotId;

    @Column(name = "pickup_location")
    private String pickupLocation;

    @Column(name = "destination_location")
    private String destinationLocation;

    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Shipment() {
    }

    public Shipment(int shipmentId, int senderId, int receiverId, int pilotId, String pickupLocation, String destinationLocation, String status) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.pilotId = pilotId;
        this.pickupLocation = pickupLocation;
        this.destinationLocation = destinationLocation;
        this.status = status;
    }

    @PrePersist
    public void prePersistCreatedAt() { this.createdAt = LocalDateTime.now(); }
    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId=" + shipmentId +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", pilotId=" + pilotId +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", destinationLocation='" + destinationLocation + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
