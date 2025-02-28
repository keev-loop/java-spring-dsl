package com.petshop.house.pets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum PetGender {
    MALE('M'),
    FEMALE('F'),
    UNDEFINED('U');

    @Setter
    private char gender;
}
