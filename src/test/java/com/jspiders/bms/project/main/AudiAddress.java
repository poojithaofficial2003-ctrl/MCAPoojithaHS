package com.jspiders.bms.project.main;

import jakarta.persistence.*;

@Entity
@Table(name ="audi_address")
public class AudiAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "area_name")
    private String areaName;
    @Column(name = "city")
    private String city;
    @Column(name = "pincode")
    private Integer pincode;

    @OneToOne(mappedBy = "audiAddress" )
    private Auditorium auditorium;

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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }
}
