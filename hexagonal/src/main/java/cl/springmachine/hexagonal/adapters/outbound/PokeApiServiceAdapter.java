package cl.springmachine.hexagonal.adapters.outbound;

import cl.springmachine.hexagonal.ports.inbound.PokeApiServicePort;
import cl.springmachine.hexagonal.ports.inbound.PokemonDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiServiceAdapter implements PokeApiServicePort {

    private final RestTemplate restTemplate;

    public PokeApiServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokemonDto getPokemonPokeApi(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        PokeApiPokemonDto pokeApiDto = restTemplate.getForObject(url, PokeApiPokemonDto.class);
        assert pokeApiDto != null;
        return PokemonDto.builder()
                .name(pokeApiDto.getName())
                .pokedexNumber(pokeApiDto.getId())
                .build();
    }
}
