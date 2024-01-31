package cl.springmachine.layered.controllers;

import cl.springmachine.layered.commons.dtos.PokemonDto;
import cl.springmachine.layered.services.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping("/{pokemonName}")
    ResponseEntity<Map<String, String>> createPokemon(@PathVariable String pokemonName) {
        String id = pokemonService.createPokemon(pokemonName);
        Map<String, String> response = new HashMap<>();
        response.put("id", id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{pokemonId}")
    ResponseEntity<PokemonDto> readPokemon(@PathVariable Integer pokemonId) {
        return new ResponseEntity<>(pokemonService.readPokemon(pokemonId), HttpStatus.OK);
    }

    @PatchMapping("/{pokemonId}/{pokemonName}")
    ResponseEntity<Void> createPokemon(@PathVariable Integer pokemonId, @PathVariable String pokemonName) {
        pokemonService.updatePokemon(pokemonId, pokemonName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{pokemonId}")
    ResponseEntity<Void> createPokemon(@PathVariable Integer pokemonId) {
        pokemonService.deletePokemon(pokemonId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
