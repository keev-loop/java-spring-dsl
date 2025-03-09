package com.petshop.house.guardian;

import java.util.Date;
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
public class GuardianDto {
	private UUID guardianId;
    private String guardianName;
    private Date guardianCreationDate;
    private Date guardianUpdatingDate;
    private Boolean guardianStatus;
}