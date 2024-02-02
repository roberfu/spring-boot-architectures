package cl.springmachine.onion.ports.inbound;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface PokemonRestControllerPort {

    ResponseEntity<Map<String, Integer>> savePokemon(PokemonDto request);

    ResponseEntity<PokemonDto> getPokemon(Integer id);

    ResponseEntity<Void> deletePokemon(Integer id);

}
