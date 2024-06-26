package cl.springmachine.custom.client.pokeapi.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.springmachine.custom.client.pokeapi.PokeApiClient;
import cl.springmachine.custom.client.pokeapi.dto.PokemonPokeApiDTO;

@Service
public class PokeApiClientImpl implements PokeApiClient {

    private final RestTemplate restTemplate;

    public PokeApiClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokemonPokeApiDTO getPokemonInfo(String name) {

        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        PokemonPokeApiDTO pokeApiPokemonDto = restTemplate.getForObject(url, PokemonPokeApiDTO.class);
        assert pokeApiPokemonDto != null;
        return pokeApiPokemonDto;
    }
}
