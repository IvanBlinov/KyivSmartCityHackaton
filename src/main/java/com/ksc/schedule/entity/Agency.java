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
@Table(name = Agency.TABLE)
@NoArgsConstructor
@AllArgsConstructor
public class Agency extends BaseEntity {

    static final String TABLE               = "agency";
    private static final String NAME        = "name";
    private static final String URL         = "url";
    private static final String TIME_ZONE   = "time_zone";
    private static final String PHONE       = "phone";
    private static final String LANGUAGE    = "language";

    public Agency(String id, String name, String url, String timeZone, String phone, String language) {
        super(id);
        this.name = name;
        this.url = url;
        this.timeZone = timeZone;
        this.phone = phone;
        this.language = language;
    }

    @Column(name = NAME)
    private String name;

    @Column(name = URL)
    private String url;

    @Column(name = TIME_ZONE)
    private String timeZone;

    @Column(name = PHONE)
    private String phone;

    @Column(name = LANGUAGE)
    private String language;
}
