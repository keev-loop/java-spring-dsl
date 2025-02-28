package com.petshop.house.pets;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PetDto {
	private UUID petId;
    private String petName;
    private PetGender petGender;
    private String petRace;
}
