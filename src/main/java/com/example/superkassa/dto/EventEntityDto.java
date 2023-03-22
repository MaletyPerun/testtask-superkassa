package com.example.superkassa.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
public class EventEntityDto {

    @NotNull
    public int id;
    @NotNull
    public int add;
}
