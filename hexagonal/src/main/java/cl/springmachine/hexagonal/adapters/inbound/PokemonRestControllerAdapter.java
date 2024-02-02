package cl.springmachine.onion.adapters.inbound;

import cl.springmachine.onion.core.domain.pokemon.Pokemon;
import cl.springmachine.onion.core.usecases.CreatePokemonUseCase;
import cl.springmachine.onion.core.usecases.DeletePokemonUseCase;
import cl.springmachine.onion.core.usecases.ReadPokemonUseCase;
import cl.springmachine.onion.ports.inbound.PokemonDto;
import cl.springmachine.onion.ports.inbound.PokemonRestControllerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pokemon")
public class PokemonRestControllerAdapter implements PokemonRestControllerPort {

    private final CreatePokemonUseCase createPokemonUseCase;

    private final ReadPokemonUseCase readPokemonUseCase;

    private final DeletePokemonUseCase deletePokemonUseCase;

    public PokemonRestControllerAdapter(CreatePokemonUseCase createPokemonUseCase, ReadPokemonUseCase readPokemonUseCase, DeletePokemonUseCase deletePokemonUseCase) {
        this.createPokemonUseCase = createPokemonUseCase;
        this.readPokemonUseCase = readPokemonUseCase;
        this.deletePokemonUseCase = deletePokemonUseCase;
    }

    @Override
    @PostMapping()
    public ResponseEntity<Map<String, Integer>> savePokemon(@RequestBody PokemonDto request) {
        Map<String, Integer> response = new HashMap<>();
        response.put("id", createPokemonUseCase.createPokemon(new Pokemon(null, request.getName(), request.getPokedexNumber())));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<PokemonDto> getPokemon(@PathVariable Integer id) {
        Pokemon pokemon = readPokemonUseCase.readPokemon(id);
        PokemonDto response = PokemonDto.builder()
                .id(pokemon.getId())
                .name(pokemon.getName())
                .pokedexNumber(pokemon.getPokedexNumber())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletePokemon(Integer id) {
        deletePokemonUseCase.deletePokemon(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
