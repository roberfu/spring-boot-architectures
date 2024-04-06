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
    public PokemonDTO getPokemonInfo(String name) {

        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        PokemonPokeApiDTO pokeApiPokemonDto = restTemplate.getForObject(url, PokemonPokeApiDTO.class);
        assert pokeApiPokemonDto != null;
        return PokemonDTO.builder()
                .name(pokeApiPokemonDto.getName())
                .pokedexNumber(pokeApiPokemonDto.getId())
                .type(pokeApiPokemonDto.getTypes()
                        .stream().findFirst().map(pokemonType -> pokemonType.getType().getName()).orElseThrow())
                .build();
    }
}
