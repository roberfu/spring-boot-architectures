package cl.springmachine.hexagonal.ports.outbound;

import cl.springmachine.hexagonal.core.domain.pokemon.Pokemon;

public interface PokemonRepositoryPort {

	Integer savePokemon(Pokemon pokemon);

	Pokemon getPokemon(Integer id);

	void deletePokemon(Integer id);

}
