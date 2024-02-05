package cl.springmachine.hexagonal.core.service;

import org.springframework.stereotype.Service;

import cl.springmachine.hexagonal.core.usecases.DeletePokemonUseCase;
import cl.springmachine.hexagonal.ports.outbound.PokemonRepositoryPort;

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
