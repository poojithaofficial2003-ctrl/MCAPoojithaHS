package com.jspiders.bms.project.main;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "audi")
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="audi_name")
    private String name;
    @Column(name="audi_seat_rows")
    private Integer seat_rows;
    @Column(name="audi_seat_columns")
    private Integer seat_columns;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name =  "address_id")
    private AudiAddress audiAddress;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "audi_id")
    private List<Shows> shows = new ArrayList<>();

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "audi_id")
//    private AuditoriumProperties auditoriumProperties;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeat_rows() {
        return seat_rows;
    }

    public void setSeat_rows(Integer seat_rows) {
        this.seat_rows = seat_rows;
    }

    public Integer getSeat_columns() {
        return seat_columns;
    }

    public void setSeat_columns(Integer seat_columns) {
        this.seat_columns = seat_columns;
    }

    public AudiAddress getAudiAddress() {
        return audiAddress;
    }

    public void setAudiAddress(AudiAddress audiAddress) {
        this.audiAddress = audiAddress;
    }

    public List<Shows> getShows() {
        return shows;
    }

    public void setShows(List<Shows> shows) {
        this.shows = shows;
    }
}
