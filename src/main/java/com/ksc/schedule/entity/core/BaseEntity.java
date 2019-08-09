package com.ksc.schedule.entity.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Entity {

    private static final String ID = "id";
    private static final String CREATED_DATE_TIME = "created";
    private static final String UPDATE_DATE_TIME = "updated";

    public BaseEntity(String id) {
        this.id = id;
        this.createDateTime = new Date();
        this.updateDateTime = new Date();
    }

    @Id
    @Column(name = ID)
    private String id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name=CREATED_DATE_TIME, columnDefinition= DATETIME_UTC, nullable=false, updatable=false)
    private Date createDateTime;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name=UPDATE_DATE_TIME, columnDefinition= DATETIME_UTC, nullable=false, updatable=true)
    private Date updateDateTime;
}
