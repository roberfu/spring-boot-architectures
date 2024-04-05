package cl.springmachine.custom.web;

import cl.springmachine.custom.service.pokemon.PokemonService;
import cl.springmachine.custom.service.pokemon.dto.PokemonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping()
    ResponseEntity<Map<String, Integer>> save(@RequestBody PokemonDTO request) {
        Integer id = pokemonService.save(request);
        Map<String, Integer> response = new HashMap<>();
        response.put("id", id);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    ResponseEntity<PokemonDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(pokemonService.get(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePokemon(@PathVariable Integer id) {
        pokemonService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
