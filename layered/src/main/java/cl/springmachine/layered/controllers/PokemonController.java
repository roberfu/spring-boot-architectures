package cl.springmachine.layered.controllers;

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

import cl.springmachine.layered.dtos.PokemonDto;
import cl.springmachine.layered.services.PokemonService;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

	private final PokemonService pokemonService;

	public PokemonController(PokemonService pokemonService) {
		this.pokemonService = pokemonService;
	}

	@PostMapping()
	ResponseEntity<Map<String, Integer>> createPokemon(@RequestBody PokemonDto request) {
		Integer id = pokemonService.createPokemon(request);
		Map<String, Integer> response = new HashMap<>();
		response.put("id", id);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	ResponseEntity<PokemonDto> readPokemon(@PathVariable Integer id) {
		return new ResponseEntity<>(pokemonService.readPokemon(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Void> deletePokemon(@PathVariable Integer id) {
		pokemonService.deletePokemon(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
