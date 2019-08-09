package com.ksc.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = Route.TABLE)
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    static final String TABLE = "routes";
    private static final String ROUTE_ID        = "route_id";
}
