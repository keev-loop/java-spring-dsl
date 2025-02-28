package com.petshop.house.pets;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetRequest {
	private UUID petId;
    private String petName;
    private PetGender petGender;
    private String petRace;
}
