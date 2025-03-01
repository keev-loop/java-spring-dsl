package com.petshop.house.pets;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "pet_gender")
    private PetGender petGender;

    @Column(nullable = false, name = "pet_race")
    private String petRace;

    @Builder.Default
    @Column(nullable = false, name = "pet_creation_date")
    private Date petCreationDate = new Date();

    @Builder.Default
    @Column(nullable = false, name = "pet_updating_date")
    private Date petUpdatingDate = new Date();

    @Builder.Default
    @Column(nullable = false, name = "pet_status")
    private Boolean petStatus = true;
}
