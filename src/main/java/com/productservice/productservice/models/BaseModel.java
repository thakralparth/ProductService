package com.productservice.productservice.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass  //to not make object of this class and pass its attributes in the child classes
public class BaseModel {
    @Id
    private Long id;
}
