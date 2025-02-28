package com.petshop.house.pets;

@Data
public enum PetGender {
    MALE('M'),
    FEMALE('F'),
    UNDEFINED('U');

    private Char gender;
}
