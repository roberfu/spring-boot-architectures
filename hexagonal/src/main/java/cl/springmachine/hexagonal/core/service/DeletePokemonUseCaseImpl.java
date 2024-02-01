package cl.springmachine.hexagonal.core.service;

import cl.springmachine.hexagonal.core.usecases.DeletePokemonUseCase;
import cl.springmachine.hexagonal.ports.outbound.PokemonRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class DeletePokemonUseCaseImpl implements DeletePokemonUseCase {

    private final PokemonRepositoryPort repositoryPort;

    public DeletePokemonUseCaseImpl(PokemonRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public void deletePokemon(Integer id) {
        repositoryPort.deletePokemon(id);
    }
}
