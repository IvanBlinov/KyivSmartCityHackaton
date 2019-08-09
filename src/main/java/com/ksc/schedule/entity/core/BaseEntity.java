package com.ksc.schedule.entity.core;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity implements Entity {

    private static final String CREATED_DATE_TIME = "created";
    private static final String UPDATE_DATE_TIME = "updated";

    @Id
    @GeneratedValue
    @Generated(GenerationTime.INSERT)
    @Column(columnDefinition = "serial")
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
