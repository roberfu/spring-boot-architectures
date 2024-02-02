package cl.springmachine.onion.controllers;

import cl.springmachine.onion.dtos.PokemonDto;
import cl.springmachine.onion.services.PokemonService;
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
