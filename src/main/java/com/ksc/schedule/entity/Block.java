package com.ksc.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = Block.TABLE)
@NoArgsConstructor
@AllArgsConstructor
public class Block {

    static final String TABLE = "calendar";
    private static final String ROUTE_ID        = "route_id";
}
