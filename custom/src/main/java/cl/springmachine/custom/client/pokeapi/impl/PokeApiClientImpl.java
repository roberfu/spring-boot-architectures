package cl.springmachine.custom.client.pokeapi.impl;

import cl.springmachine.custom.client.pokeapi.PokeApiClient;
import cl.springmachine.custom.client.pokeapi.dto.PokemonPokeApiDTO;
import cl.springmachine.custom.service.pokemon.dto.PokemonDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiClientImpl implements PokeApiClient {

    private final RestTemplate restTemplate;

    public PokeApiClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokemonDTO getInfo(String name) {

        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        PokemonPokeApiDTO response = restTemplate.getForObject(url, PokemonPokeApiDTO.class);
        assert response != null;
        return PokemonDTO.builder().name(response.getName()).pokedexNumber(response.getId()).build();
    }
}
