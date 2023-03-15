package com.example.superkassa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class ObjJson implements Serializable {

    private Long current;
}
