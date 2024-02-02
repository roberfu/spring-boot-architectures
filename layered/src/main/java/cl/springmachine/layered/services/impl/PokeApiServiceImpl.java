package cl.springmachine.onion.services.impl;

import cl.springmachine.onion.dtos.PokeApiPokemonDto;
import cl.springmachine.onion.dtos.PokemonDto;
import cl.springmachine.onion.services.PokeApiService;
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
