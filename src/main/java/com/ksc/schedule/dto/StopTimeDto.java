package com.ksc.schedule.dto;

import com.ksc.schedule.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StopTimeDto implements BaseDto {

    private String id;
    private TripDto trip;
    private String arrival;
    private String departure;
    private StopDto stop;
    //private String stopSequence;
    //private String pickupType;
    //private String dropOffType;
}
