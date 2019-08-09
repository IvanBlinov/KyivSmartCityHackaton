package com.ksc.schedule.entity.core;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
@Data
public class VersionedEntity extends BaseEntity {

    private static final String VERSION = "version";

    @Column(name = VERSION)
    @Version
    private int version;
}
