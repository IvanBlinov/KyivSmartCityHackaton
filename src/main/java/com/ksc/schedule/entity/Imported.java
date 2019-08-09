package com.ksc.schedule.entity;

import com.ksc.schedule.entity.core.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = Imported.TABLE)
@NoArgsConstructor
public class Imported extends BaseEntity {

    static final String TABLE               = "imported";
    private static final String SOMETHING   = "something";

    public Imported(String something) {
        super(UUID.randomUUID().toString().split("-")[0]);
        this.something = something;
    }

    @Column(name = SOMETHING)
    private String something;
}
