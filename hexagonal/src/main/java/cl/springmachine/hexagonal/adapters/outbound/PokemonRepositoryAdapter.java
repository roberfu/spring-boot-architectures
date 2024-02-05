package cl.springmachine.hexagonal.adapters.outbound;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.springmachine.hexagonal.core.domain.pokemon.Pokemon;
import cl.springmachine.hexagonal.ports.outbound.PokemonRepositoryPort;

@Repository
public class PokemonRepositoryAdapter implements PokemonRepositoryPort {

	private final JpaRepositoryAdapter repositoryAdapter;

	public PokemonRepositoryAdapter(JpaRepositoryAdapter repositoryAdapter) {
		this.repositoryAdapter = repositoryAdapter;
	}

	@Override
	public Integer savePokemon(Pokemon pokemon) {
		return repositoryAdapter.save(new PokemonEntity(null, pokemon.getName(), pokemon.getPokedexNumber())).getId();
	}

	@Override
	public Pokemon getPokemon(Integer id) {
		Optional<PokemonEntity> optional = repositoryAdapter.findById(id);
		return optional.map(pokemonEntity -> new Pokemon(pokemonEntity.getId(), pokemonEntity.getName(),
				pokemonEntity.getPokedexNumber())).orElse(null);
	}

	@Override
	public void deletePokemon(Integer id) {
		repositoryAdapter.deleteById(id);
	}
}
