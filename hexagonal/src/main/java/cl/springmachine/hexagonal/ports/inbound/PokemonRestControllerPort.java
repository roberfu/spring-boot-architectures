package cl.springmachine.hexagonal.ports.inbound;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface PokemonRestControllerPort {

    ResponseEntity<Map<String, Integer>> savePokemon(String name);

    ResponseEntity<PokemonDto> getPokemon(Integer pokedexNumber);

}
