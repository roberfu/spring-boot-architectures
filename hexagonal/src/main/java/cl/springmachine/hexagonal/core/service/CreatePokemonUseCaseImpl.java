package cl.springmachine.hexagonal.core.service;

import cl.springmachine.hexagonal.core.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.core.usecases.CreatePokemonUseCase;
import cl.springmachine.hexagonal.ports.inbound.PokeApiServicePort;
import cl.springmachine.hexagonal.ports.inbound.PokemonDto;
import cl.springmachine.hexagonal.ports.outbound.PokemonRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreatePokemonUseCaseImpl implements CreatePokemonUseCase {

    private final PokemonRepositoryPort repositoryPort;

    private final PokeApiServicePort pokeApiServicePort;

    public CreatePokemonUseCaseImpl(PokemonRepositoryPort repositoryPort, PokeApiServicePort pokeApiServicePort) {
        this.repositoryPort = repositoryPort;
        this.pokeApiServicePort = pokeApiServicePort;
    }

    @Override
    public Integer createPokemon(String name) {
        PokemonDto pokemon = pokeApiServicePort.getPokemonPokeApi(name);
        return repositoryPort.savePokemon(Pokemon.builder()
                .name(pokemon.getName())
                .pokedexNumber(pokemon.getPokedexNumber())
                .build());
    }
}
