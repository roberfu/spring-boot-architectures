package cl.springmachine.onion.core.service;

import cl.springmachine.onion.core.domain.pokemon.Pokemon;
import cl.springmachine.onion.core.usecases.ReadPokemonUseCase;
import cl.springmachine.onion.ports.outbound.PokemonRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class ReadPokemonUseCaseImpl implements ReadPokemonUseCase {

    private final PokemonRepositoryPort repositoryPort;

    public ReadPokemonUseCaseImpl(PokemonRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Pokemon readPokemon(Integer id) {
        return repositoryPort.getPokemon(id);
    }
}
