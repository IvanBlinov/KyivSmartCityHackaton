package com.ksc.schedule.dto;

import com.ksc.schedule.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TripDto implements BaseDto {

    private String id;
    private RouteDto route;
    //private CalendarDto calendar;
    private String name;
    //private BlockDto block;
}
