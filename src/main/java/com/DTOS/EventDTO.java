package com.DTOS;

import com.Domian.Enums.EventCategory;
import com.Domian.Enums.Status;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class EventDTO {
    private Long id;
    private String title;
    private String description;
    private Long organizerId;
    private EventCategory category;
    private String location;
    private LocalDateTime dateTime;
    private Status status;
}
