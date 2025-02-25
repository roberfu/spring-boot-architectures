package cl.springmachine.hexagonal.adapters.outbound;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.springmachine.hexagonal.ports.outbound.PokeApiServicePort;

@Service
public class PokeApiServiceAdapter implements PokeApiServicePort {

    private final RestTemplate restTemplate;

    public PokeApiServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokeApiPokemonDto getPokemonInfoPokeApi(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        PokeApiPokemonDto pokeApiPokemonDto = restTemplate.getForObject(url, PokeApiPokemonDto.class);
        assert pokeApiPokemonDto != null;
        return pokeApiPokemonDto;
    }
}
