package cl.springmachine.onion.presenter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.springmachine.onion.domain.pokemon.Pokemon;
import cl.springmachine.onion.domain.service.PokemonService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	private final PokemonService pokemonService;

	@PostMapping()
	public ResponseEntity<Map<String, Integer>> savePokemon(@RequestBody PokemonDto request) {
		Map<String, Integer> response = new HashMap<>();
		response.put("id", pokemonService.createPokemon(request.getName()));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PokemonDto> getPokemon(@PathVariable Integer id) {
		Pokemon pokemon = pokemonService.readPokemon(id);
		return new ResponseEntity<>(PokemonDto.builder().id(pokemon.getId()).name(pokemon.getName())
				.pokedexNumber(pokemon.getPokedexNumber()).build(), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePokemon(@PathVariable Integer id) {
		pokemonService.deletePokemon(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
