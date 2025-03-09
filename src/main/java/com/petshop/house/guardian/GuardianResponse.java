package com.petshop.house.guardian;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class GuardianResponse {
    @NotNull
    @NotEmpty
    @JsonProperty("id")
	private UUID guardianId;
    @NotNull
    @NotEmpty
    @JsonProperty("name")
    private String guardianName;
}
