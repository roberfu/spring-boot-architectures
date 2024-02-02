package cl.springmachine.hexagonal.adapters.outbound;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiServiceAdapter {

    private final RestTemplate restTemplate;

    public PokeApiServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public PokeApiPokemonDto getPokemonPokeApi(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        PokeApiPokemonDto pokeApiDto = restTemplate.getForObject(url, PokeApiPokemonDto.class);
        assert pokeApiDto != null;
        return pokeApiDto;
    }
}
