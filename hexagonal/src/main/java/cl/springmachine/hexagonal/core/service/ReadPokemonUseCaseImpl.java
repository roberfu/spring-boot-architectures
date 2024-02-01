package cl.springmachine.hexagonal.core.service;

import cl.springmachine.hexagonal.core.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.core.usecases.ReadPokemonUseCase;
import cl.springmachine.hexagonal.ports.outbound.PokemonRepositoryPort;
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
