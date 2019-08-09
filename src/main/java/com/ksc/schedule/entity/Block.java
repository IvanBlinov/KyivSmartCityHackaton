package com.ksc.schedule.entity;

import com.ksc.schedule.entity.core.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = Block.TABLE)
@NoArgsConstructor
public class Block extends BaseEntity {

    static final String TABLE               = "block";
    private static final String CODE        = "code";
    private static final String NAME        = "name";
    private static final String SEQUENCE    = "sequence";
    private static final String SHIFT       = "shift";

    public Block(String id, String code, String name, Integer sequence, Integer shift) {
        super(id);
        this.code = code;
        this.name = name;
        this.sequence = sequence;
        this.shift = shift;
    }

    @Column(name = CODE)
    private String code;

    @Column(name = NAME)
    private String name;

    @Column(name = SEQUENCE)
    private Integer sequence;

    @Column(name = SHIFT)
    private Integer shift;
}
