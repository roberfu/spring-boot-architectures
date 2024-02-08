package cl.springmachine.onion.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.springmachine.onion.domain.pokemon.Pokemon;
import cl.springmachine.onion.domain.service.PokemonProvider;

public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer>, PokemonProvider {

	default Integer createPokemon(Pokemon pokemon) {
		PokemonEntity entity = save(new PokemonEntity(null, pokemon.getName(), pokemon.getPokedexNumber()));
		return entity.getId();
	}

	default Pokemon readPokemon(Integer id) {
		Optional<PokemonEntity> optional = findById(id);
		return optional
				.map(t -> Pokemon.builder().id(t.getId()).name(t.getName()).pokedexNumber(t.getPokedexNumber()).build())
				.orElse(null);
	}

	default void deletePokemon(Integer id) {
		deleteById(id);
	}

}
