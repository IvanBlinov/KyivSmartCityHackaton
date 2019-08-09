package com.ksc.schedule.dto;

import com.ksc.schedule.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgencyDto implements BaseDto {

    private String id;
    private String name;
    private String url;
    private String timeZone;
    private String phone;
    private String language;
}
