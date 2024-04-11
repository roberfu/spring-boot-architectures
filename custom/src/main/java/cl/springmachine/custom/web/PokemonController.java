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

    @PostMapping("/{name}")
    ResponseEntity<Map<String, Integer>> save(@PathVariable String name) {
        Integer pokedexNumber = pokemonService.savePokemon(name);
        Map<String, Integer> response = new HashMap<>();
        response.put("pokeDexNumber", pokedexNumber);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{pokedexNumber}")
    ResponseEntity<PokemonDTO> get(@PathVariable Integer pokedexNumber) {
        return new ResponseEntity<>(pokemonService.getPokemon(pokedexNumber), HttpStatus.OK);
    }

}
