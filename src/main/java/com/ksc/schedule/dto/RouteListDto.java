package com.ksc.schedule.dto;

import com.ksc.schedule.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteListDto implements BaseDto {

    private String transportNumber;
    private String departure;
    private String arrival;
    private String depStationName;
    private String depStationId;
    private String arrStationName;
    private String arrStationId;
}
