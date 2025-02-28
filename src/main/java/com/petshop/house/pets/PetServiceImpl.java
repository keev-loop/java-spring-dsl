package com.petshop.house.pets;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Override
    public List<PetDto> findAll() {
        return petRepository
                .findAll()
                .stream()
                .map(pet -> petMapper.toDto(pet))
                .collect(Collectors.toList())
    }
}
