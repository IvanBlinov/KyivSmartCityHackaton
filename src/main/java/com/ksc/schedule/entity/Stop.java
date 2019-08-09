package com.ksc.schedule.entity;

import com.ksc.schedule.entity.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = Stop.TABLE)
@NoArgsConstructor
@AllArgsConstructor
public class Stop  extends BaseEntity {

    static final String TABLE           = "stop";
    private static final String NAME    = "name";
    private static final String LAT     = "lat";
    private static final String LON     = "lon";
    private static final String URL     = "url";

    public Stop(String id, String name, String lat, String lon, String url) {
        super(id);
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.url = url;
    }

    @Column(name = NAME)
    private String name;

    @Column(name = LAT)
    private String lat;

    @Column(name = LON)
    private String lon;

    @Column(name = URL)
    private String url;
}
