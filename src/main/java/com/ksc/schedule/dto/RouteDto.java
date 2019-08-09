package com.ksc.schedule.dto;

import com.ksc.schedule.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteDto implements BaseDto {

    private String id;
    //private AgencyDto agency;
    private String shortName;
    private String longName;
    private String description;
    //private Integer type;
}
