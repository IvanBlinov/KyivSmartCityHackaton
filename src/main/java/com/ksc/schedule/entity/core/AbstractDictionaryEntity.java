package com.ksc.schedule.entity.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class AbstractDictionaryEntity extends BaseEntity {
    public static final String DISPLAY_NAME = "display_name";
    public static final String DESCRIPTION = "description";

    @Column(name = DISPLAY_NAME, length = 50, nullable=false, unique = true)
    private String code;

    @Column(name = DESCRIPTION, length = 1000)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractDictionaryEntity that = (AbstractDictionaryEntity) o;
        return code.equals(that.code) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), code, description);
    }
}
