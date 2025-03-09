package com.petshop.house.pets;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class PetRequest {
    @NotNull
    @NotEmpty
    @JsonProperty("name")
    private String petName;
    @NotNull
    @NotEmpty
    @Size(min=4)
    @JsonProperty("gender")
    private PetGender petGender;
    @NotNull
    @NotEmpty
    @JsonProperty("race")
    private String petRace;
    @NotNull
    @NotEmpty
    @JsonProperty("guardian")
    private UUID petGuardian;
}
