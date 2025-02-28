package com.petshop.house.pets;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_PET")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, name = "pet_id")
	private UUID petId;

    @Column(nullable = false, name = "pet_name")
    private String petName;

    @Enumerated
    @Column(nullable = false, name = "pet_gender")
    private PetGender petGender;

    @Column(nullable = false, name = "pet_race")
    private String petRace;

}
