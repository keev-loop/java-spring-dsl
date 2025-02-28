package com.petshop.house.pets;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PetController {
    private final PetService petService;
    private final PetMapper petMapper;

    @GetMapping
    public List<PetResponse> findAll() {
        return petService
                .findAll()
                .map(pet -> petMapper.toResponse(pet))
                .collect(Collectors.toList());
    }
}
