package com.petshop.house.guardian;

import java.util.List;
import java.util.UUID;

public interface GuardianServicePort {
    List<GuardianDto> searchAll();
    GuardianDto searchById(UUID id);
    GuardianDto create(GuardianDto dto);
}
