package cl.springmachine.onion.core.service;

import cl.springmachine.onion.core.domain.pokemon.Pokemon;
import cl.springmachine.onion.core.usecases.CreatePokemonUseCase;
import cl.springmachine.onion.ports.outbound.PokemonRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class CreatePokemonUseCaseImpl implements CreatePokemonUseCase {

    private final PokemonRepositoryPort repositoryPort;

    public CreatePokemonUseCaseImpl(PokemonRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Integer createPokemon(Pokemon pokemon) {
        return repositoryPort.savePokemon(pokemon);
    }
}
