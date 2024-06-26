package cl.springmachine.layered.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.springmachine.layered.dto.PokeApiPokemonDTO;
import cl.springmachine.layered.service.PokeApiExternalService;

@Service
public class PokeApiExternalServiceImpl implements PokeApiExternalService {

    private final RestTemplate restTemplate;

    public PokeApiExternalServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokeApiPokemonDTO getPokemonInfo(String name) {

        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        PokeApiPokemonDTO pokeApiPokemonDto = restTemplate.getForObject(url, PokeApiPokemonDTO.class);
        assert pokeApiPokemonDto != null;
        return pokeApiPokemonDto;
    }
}
