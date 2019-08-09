package com.ksc.schedule.dto;

import com.ksc.schedule.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockDto implements BaseDto {

    private String id;
    private String code;
    private String name;
    private Integer sequence;
    private Integer shift;
}
