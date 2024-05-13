package com.productservice.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortParams {
    private String sortParamsName;
    private String sortType; // ASC or DESC
}
