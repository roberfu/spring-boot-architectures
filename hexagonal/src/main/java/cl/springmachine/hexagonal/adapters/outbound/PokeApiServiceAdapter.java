package cl.springmachine.hexagonal.adapters.outbound;

import cl.springmachine.hexagonal.ports.inbound.PokemonDto;
import cl.springmachine.hexagonal.ports.outbound.PokeApiServicePort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokeApiServiceAdapter implements PokeApiServicePort {

    private final RestTemplate restTemplate;

    public PokeApiServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PokemonDto getPokemonInfoPokeApi(String name) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        PokeApiPokemonDto pokeApiPokemonDto = restTemplate.getForObject(url, PokeApiPokemonDto.class);
        assert pokeApiPokemonDto != null;
        return PokemonDto.builder()
                .name(pokeApiPokemonDto.getName())
                .pokedexNumber(pokeApiPokemonDto.getId())
                .type(pokeApiPokemonDto.getTypes()
                        .stream().findFirst().map(pokemonType -> pokemonType.getType().getName()).orElseThrow())
                .build();
    }
}
