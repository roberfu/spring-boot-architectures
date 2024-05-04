package cl.springmachine.onion.presenter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@PostMapping("/{name}")
	public ResponseEntity<Map<String, Integer>> savePokemon(@PathVariable String name) {
		Map<String, Integer> response = new HashMap<>();
		response.put("pokedex_number", pokemonService.createPokemon(name));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{pokedexNumber}")
	public ResponseEntity<PokemonDto> getPokemon(@PathVariable Integer pokedexNumber) {
		Pokemon pokemon = pokemonService.readPokemon(pokedexNumber);
		return new ResponseEntity<>(PokemonDto.builder().pokedexNumber(pokemon.getPokedexNumber())
				.name(pokemon.getName()).type(pokemon.getType()).build(), HttpStatus.OK);
	}
}
