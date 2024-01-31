package cl.springmachine.layered.commons.services.impl;

import cl.springmachine.layered.commons.dtos.PokeApiPokemonDto;
import cl.springmachine.layered.commons.dtos.PokemonDto;
import cl.springmachine.layered.commons.services.PokeApiService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiServiceImpl implements PokeApiService {

    private final RestTemplate restTemplate;

    public PokeApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokemonDto getPokemonInfo(String pokemonName) {
        
        String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
        PokeApiPokemonDto pokeApiPokemonDto = restTemplate.getForObject(url, PokeApiPokemonDto.class);
        assert pokeApiPokemonDto != null;
        return PokemonDto.builder()
                .name(pokeApiPokemonDto.getName())
                .pokedexNumber(pokeApiPokemonDto.getId())
                .build();
    }
}
