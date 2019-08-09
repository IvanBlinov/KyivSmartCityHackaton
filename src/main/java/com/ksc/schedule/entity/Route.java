package com.ksc.schedule.entity;

import com.ksc.schedule.entity.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = Route.TABLE)
@NoArgsConstructor
@AllArgsConstructor
public class Route extends BaseEntity {

    static final String TABLE               = "route";
    private static final String AGENCY_ID   = "agency_id";
    private static final String SHORT_NAME  = "short_name";
    private static final String LONG_NAME   = "long_name";
    private static final String DESCRIPTION = "description";
    private static final String TYPE        = "type";

    public Route(String id, Agency agency, String shortName, String longName, String description, Integer type) {
        super(id);
        this.agency = agency;
        this.shortName = shortName;
        this.longName = longName;
        this.description = description;
        this.type = type;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = AGENCY_ID)
    private Agency agency;

    @Column(name = SHORT_NAME)
    private String shortName;

    @Column(name = LONG_NAME)
    private String longName;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = TYPE)
    private Integer type;
}
