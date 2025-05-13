package com.Domian;

import com.Domian.Enums.EventCategory;
import com.Domian.Enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Description is required")
    private String description;
    @NotNull(message = "Organizer ID is required")
    private Long organizerId;
    @NotNull(message = "Category is required")
    private EventCategory category;
    @NotBlank(message = "Location is required")
    private String location;
    @NotNull(message = "Date and Time are required")
    private LocalDateTime dateTime;
    @NotNull(message = "Status is required")
    private Status status;

}