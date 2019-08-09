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
@Table(name = Calendar.TABLE)
@NoArgsConstructor
@AllArgsConstructor
public class Calendar extends BaseEntity {

    static final String TABLE               = "calendar";
    private static final String MONDAY      = "monday";
    private static final String TUESDAY     = "tuesday";
    private static final String WEDNESDAY   = "wednesday";
    private static final String THURSDAY    = "thursday";
    private static final String FRIDAY      = "friday";
    private static final String SATURDAY    = "saturday";
    private static final String SUNDAY      = "sunday";
    private static final String START_DATE  = "start_date";
    private static final String END_DATE    = "end_date";

    public Calendar(String id, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday, String start_date, String end_date) {
        super(id);
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    @Column(name = MONDAY)
    private String monday;

    @Column(name = TUESDAY)
    private String tuesday;

    @Column(name = WEDNESDAY)
    private String wednesday;

    @Column(name = THURSDAY)
    private String thursday;

    @Column(name = FRIDAY)
    private String friday;

    @Column(name = SATURDAY)
    private String saturday;

    @Column(name = SUNDAY)
    private String sunday;

    @Column(name = START_DATE)
    private String start_date;

    @Column(name = END_DATE)
    private String end_date;
}
