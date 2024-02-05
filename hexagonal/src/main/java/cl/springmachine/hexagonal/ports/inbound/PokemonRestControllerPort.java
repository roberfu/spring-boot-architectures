package cl.springmachine.hexagonal.ports.inbound;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface PokemonRestControllerPort {

	ResponseEntity<Map<String, Integer>> savePokemon(PokemonDto request);

	ResponseEntity<PokemonDto> getPokemon(Integer id);

	ResponseEntity<Void> deletePokemon(Integer id);

}
