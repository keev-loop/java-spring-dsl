package com.petshop.house.pets;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_PET")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, name = "pet_id")
	private UUID petId;

    @Column(nullable = false, name = "pet_id")
    private String petName;

    @Column(nullable = false, name = "pet_gender")
    private PetGender petGender;

    @Column(nullable = false, name = "pet_race")
    private String petRace;

}
