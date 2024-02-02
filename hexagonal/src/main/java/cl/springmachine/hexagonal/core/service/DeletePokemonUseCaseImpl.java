package cl.springmachine.onion.core.service;

import cl.springmachine.onion.core.usecases.DeletePokemonUseCase;
import cl.springmachine.onion.ports.outbound.PokemonRepositoryPort;
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
