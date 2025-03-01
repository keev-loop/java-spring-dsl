package com.petshop.house.pets;

import lombok.Getter;

@Getter
public enum PetGender {
    MALE,
    FEMALE,
    UNDEFINED;

/*    private char gender;

    public static PetGender findByValue(String value) {
        return Enum.valueOf(PetGender.class, value);
    }*/
}
