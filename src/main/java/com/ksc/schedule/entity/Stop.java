package com.ksc.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = Stop.TABLE)
@NoArgsConstructor
@AllArgsConstructor
public class Stop {

    static final String TABLE = "trips";
    private static final String ROUTE_ID        = "route_id";
}
