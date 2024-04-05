package cl.springmachine.layered.service.impl;

import cl.springmachine.layered.dto.PokeApiPokemonDTO;
import cl.springmachine.layered.dto.PokemonDTO;
import cl.springmachine.layered.service.PokeApiExternalService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiExternalServiceImpl implements PokeApiExternalService {

    private final RestTemplate restTemplate;

    public PokeApiExternalServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokemonDTO getPokemonInfo(String name) {

        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        PokeApiPokemonDTO pokeApiPokemonDto = restTemplate.getForObject(url, PokeApiPokemonDTO.class);
        assert pokeApiPokemonDto != null;
        return PokemonDTO.builder()
                .name(pokeApiPokemonDto.getName())
                .pokedexNumber(pokeApiPokemonDto.getId())
                .type(pokeApiPokemonDto.getTypes()
                        .stream().findFirst().map(pokemonType -> pokemonType.getType().getName()).orElseThrow())
                .build();
    }
}
