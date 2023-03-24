package com.example.superkassa.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EventEntityDto {

    @NotNull
    public int id;
    @NotNull
    public int add;
}
