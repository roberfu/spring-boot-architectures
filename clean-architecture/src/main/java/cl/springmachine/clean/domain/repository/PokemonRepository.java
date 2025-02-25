package cl.springmachine.clean.domain.repository;

import org.springframework.stereotype.Component;

import cl.springmachine.clean.domain.model.Pokemon;

@Component
public interface PokemonRepository {

	Pokemon findByPokedexNumber(Integer pokedexNumber);

	Pokemon save(Pokemon pokemon);

}
