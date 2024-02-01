package cl.springmachine.hexagonal.services.impl;

import cl.springmachine.hexagonal.dtos.PokeApiPokemonDto;
import cl.springmachine.hexagonal.dtos.PokemonDto;
import cl.springmachine.hexagonal.services.PokeApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiServiceImpl implements PokeApiService {

    private final RestTemplate restTemplate;

    public PokeApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokemonDto getPokemonInfo(String name) {

        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        PokeApiPokemonDto pokeApiPokemonDto = restTemplate.getForObject(url, PokeApiPokemonDto.class);
        assert pokeApiPokemonDto != null;
        return PokemonDto.builder()
                .name(pokeApiPokemonDto.getName())
                .pokedexNumber(pokeApiPokemonDto.getId())
                .build();
    }
}
