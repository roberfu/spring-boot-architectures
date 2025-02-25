package cl.springmachine.clean.presenter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.springmachine.clean.application.operations.CreatePokemonUseCase;
import cl.springmachine.clean.application.retrievals.ReadPokemonUseCase;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pokemon")
public class PokemonController {

	private final ReadPokemonUseCase readPokemonUseCase;

	private final CreatePokemonUseCase createPokemonUserCase;

	@GetMapping("/{pokedexNumber}")
	public ResponseEntity<PokemonDto> getPokemon(@PathVariable Integer pokedexNumber) {
		return new ResponseEntity<>(readPokemonUseCase.readPokemon(pokedexNumber), HttpStatus.OK);
	}

	@PostMapping("/{name}")
	public ResponseEntity<Map<String, Integer>> postMethodName(@PathVariable String name) {
		Map<String, Integer> response = new HashMap<>();
		response.put("pokedex_number", createPokemonUserCase.createPokemon(name));
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
