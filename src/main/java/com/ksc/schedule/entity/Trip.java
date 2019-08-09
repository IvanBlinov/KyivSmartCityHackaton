package com.ksc.schedule.entity;

import com.ksc.schedule.entity.core.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = Trip.TABLE)
@NoArgsConstructor
@AllArgsConstructor
public class Trip extends BaseEntity {
//route_id,service_id,trip_id,trip_headsign,block_id
    static final String TABLE = "trip";
    private static final String ROUTE_ID        = "route_id";
    private static final String CALENDAR_ID     = "calendar_id";
    private static final String NAME            = "name";
    private static final String BLOCK_ID        = "block_id";

    public Trip(String id, Route route, Calendar calendar, String name, Block block) {
        super(id);
        this.route = route;
        this.calendar = calendar;
        this.name = name;
        this.block = block;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = ROUTE_ID)
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = CALENDAR_ID)
    private Calendar calendar;

    @Column(name = NAME)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = BLOCK_ID)
    private Block block;
}
