package com.productservice.productservice.inheritancerelations.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_mentor")
@PrimaryKeyJoinColumn(name="user_id")   //name to be given to FK in child tables
public class Mentor extends User {
    private double avgRating;
}
