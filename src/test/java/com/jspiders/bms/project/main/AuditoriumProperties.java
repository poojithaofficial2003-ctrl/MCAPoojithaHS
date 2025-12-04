package com.jspiders.bms.project.main;

import jakarta.persistence.*;

@Entity
@Table(name = "audi_properties")
public class AuditoriumProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "screen_type")
    private String screenType;
    @Column(name = "sound")
    private String sound;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
