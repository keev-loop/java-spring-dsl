package com.petshop.house.guardian;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "T_GUARDIAN")
public class GuardianEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false, name = "guardian_id")
	private UUID guardianId;

    @Column(nullable = false, name = "guardian_name")
    private String guardianName;

    @Builder.Default
    @Column(nullable = false, name = "guardian_creation_date")
    private Date guardianCreationDate = new Date();

    @Builder.Default
    @Column(nullable = false, name = "guardian_updating_date")
    private Date guardianUpdatingDate = new Date();

    @Builder.Default
    @Column(nullable = false, name = "guardian_status")
    private Boolean guardianStatus = true;
}