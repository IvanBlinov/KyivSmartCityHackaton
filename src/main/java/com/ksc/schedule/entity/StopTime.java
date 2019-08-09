package com.ksc.schedule.entity;

import com.ksc.schedule.entity.core.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = StopTime.TABLE)
@NoArgsConstructor
public class StopTime extends BaseEntity {
//trip_id,arrival_time,departure_time,stop_id,stop_sequence,stop_headsign,pickup_type,drop_off_type
    static final String TABLE                   = "stop_time";
    private static final String TRIP_ID         = "trip_id";
    private static final String ARRIVAL         = "arrival_time";
    private static final String DEPARTURE       = "departure_time";
    private static final String STOP_ID         = "stop_id";
    private static final String STOP_SEQ        = "stop_sequence";
    private static final String STOP_HEADSIGN   = "stop_headsign";
    private static final String PICKUP_TYPE     = "pickup_type";
    private static final String DROP_OFF_TYPE   = "drop_off_type";

    public StopTime(Trip trip, String arrival, String departure, Stop stop, String stopSequence, String pickupType, String dropOffType) {
        super(UUID.randomUUID().toString().split("-")[0]);
        this.trip = trip;
        this.arrival = arrival;
        this.departure = departure;
        this.stop = stop;
        this.stopSequence = stopSequence;
        this.pickupType = pickupType;
        this.dropOffType = dropOffType;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = TRIP_ID)
    private Trip trip;

    @Column(name = ARRIVAL)
    private String arrival;

    @Column(name = DEPARTURE)
    private String departure;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = STOP_ID)
    private Stop stop;

    @Column(name = STOP_SEQ)
    private String stopSequence;

    @Column(name = PICKUP_TYPE)
    private String pickupType;

    @Column(name = DROP_OFF_TYPE)
    private String dropOffType;
}
