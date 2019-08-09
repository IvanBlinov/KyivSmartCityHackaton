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

    static final String TABLE = "trips";
    private static final String ROUTE_ID        = "route_id";
    private static final String NAME            = "name";
    private static final String BLOCK_ID        = "block_id";

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = ROUTE_ID)
    private Route route;

    @Column(name = NAME)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = BLOCK_ID)
    private Block block;
}
